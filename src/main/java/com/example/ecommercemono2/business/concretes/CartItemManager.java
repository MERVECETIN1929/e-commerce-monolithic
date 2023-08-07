package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.CartItemService;
import com.example.ecommercemono2.business.abstracts.CartService;
import com.example.ecommercemono2.business.abstracts.ProductService;
import com.example.ecommercemono2.business.dto.request.cartItem.CreateCartItemRequest;
import com.example.ecommercemono2.business.dto.request.cartItem.UpdateCartItemRequest;
import com.example.ecommercemono2.business.dto.request.cartItem.UpdateCartItemUnitPrice;
import com.example.ecommercemono2.business.dto.response.cartItem.CreateCartItemResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.GetAllCartItemsResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.GetCartItemResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.UpdateCartItemResponse;
import com.example.ecommercemono2.business.rules.CartItemRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Cart;
import com.example.ecommercemono2.entities.CartItem;
import com.example.ecommercemono2.entities.Product;
import com.example.ecommercemono2.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartItemManager implements CartItemService {
    private final CartItemRules rules;
    private final CartItemRepository repository;
    private final ModelMapperService mapper;
    private final CartService cartService;
    private final ProductService productService;


    public CreateCartItemResponse add(CreateCartItemRequest request) {
        // EĞER SEPET İD VE KULLANICI İD AYNI OLAN KAYIR VARSA ADD SADECE SEPETTE BULUNAN ÜRÜNÜN MİKTARINI ARTTIRIR
        Cart cart=mapper.forRequest().map(cartService.getCartByUserId(request.getUserId()),Cart.class);
        CartItem cartItem = repository.findCartItemByCartIdAndProductId(cart.getId(), request.getProductId());
        CartItem requestCartItem = mapper.forRequest().map(request, CartItem.class);
        Product product = mapper.forResponse().map(productService.getById(request.getProductId()), Product.class);
        if (cartItem == null) {
            cartItem = requestCartItem;
            cartItem.setCart(cart);
            cartItem.setId(UUID.randomUUID());
            cartService.addPriceTotalPrice(product.getUnitPrice() * request.getQuantity(), cart.getId());
            cartItem.setTotalPrice(request.getQuantity() * product.getUnitPrice());

        } else {
            increaseQuantity(request, cartItem.getId());
        }
        var saveCartItem = repository.save(cartItem);
        return mapper.forResponse().map(saveCartItem, CreateCartItemResponse.class);
    }

    public UpdateCartItemResponse update(UUID cartItemId, UpdateCartItemRequest request) {
        CartItem cartItem = mapper.forRequest().map(request, CartItem.class);
        Product product = mapper.forResponse().map(productService.getById(request.getProductId()), Product.class);
        rules.existCartById(cartItemId);
        cartItem.setId(cartItemId);
        cartItem.setTotalPrice(totalPrice(product.getUnitPrice(), cartItem.getQuantity()));
        var saveCartItem = repository.save(cartItem);
        return mapper.forResponse().map(saveCartItem, UpdateCartItemResponse.class);
    }

    public GetCartItemResponse getById(UUID cartItemId) {
        rules.existCartById(cartItemId);
        CartItem cartItem = repository.findById(cartItemId).orElseThrow();
        Product product = mapper.forResponse().map(productService.getById(cartItem.getProduct().getId()), Product.class);
        cartItem.setTotalPrice(totalPrice(product.getUnitPrice(), cartItem.getQuantity()));
        repository.save(cartItem);
        return mapper.forResponse().map(cartItem, GetCartItemResponse.class);
    }

    public List<GetAllCartItemsResponse> getAll() {
        List<CartItem> cartItems = repository.findAll();
        for (CartItem cartItem : cartItems) {
            Product product = mapper.forResponse().map(productService.getById(cartItem.getProduct().getId()), Product.class);
            cartItem.setTotalPrice(totalPrice(product.getUnitPrice(), cartItem.getQuantity()));
            repository.save(cartItem);
        }
        return cartItems.stream().
                map(cartItem -> mapper.forResponse().map(cartItem, GetAllCartItemsResponse.class)).toList();

    }

    @Override
    public List<CartItem> getAllCartItemsByCartId(UUID cartId) {
        rules.cardIsEmpty(cartId);
        return repository.findAllByCartId(cartId);
    }

    public void delete(UUID cartItemId) {
        // sepetten ürünün direkt olarak silinmesi işini yapan metot
        rules.existCartById(cartItemId);
        CartItem cartItem = mapper.forRequest().map(getById(cartItemId), CartItem.class);
        repository.deleteById(cartItemId);
        Product product = mapper.forResponse().map(productService.getById(cartItem.getProduct().getId()), Product.class);
        cartService.minusPriceTotalPrice(cartItem.getQuantity() * product.getUnitPrice(), cartItem.getCart().getId());
    }

    @Override
    public void increaseQuantity(CreateCartItemRequest request, UUID cartItemId) {
        // sepette bulunan ürünün miktarını arttıran metot
        Cart cart=mapper.forRequest().map(cartService.getCartByUserId(request.getUserId()),Cart.class);
        CartItem cartItem = mapper.forRequest().map(getById(cartItemId), CartItem.class);
        cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
        cartItem.setId(cartItemId);
        Product product = mapper.forResponse().map(productService.getById(request.getProductId()), Product.class);
        cartService.addPriceTotalPrice(totalPrice(product.getUnitPrice(), request.getQuantity()), cart.getId());
        cartItem.setTotalPrice(cartItem.getTotalPrice() + totalPrice(product.getUnitPrice(), request.getQuantity()));
        repository.save(cartItem);
    }

    @Override
    public void reduceQuantity(CreateCartItemRequest request, UUID cartItemId) {
        // sepette bulunan ürünün miktarını azaltan metot.
        // sadece tek ürün varsa cartItemi direkt olarak sil.
        CartItem cartItem = mapper.forRequest().map(getById(cartItemId), CartItem.class);
        Cart cart=mapper.forRequest().map(cartService.getCartByUserId(request.getUserId()),Cart.class);
        if (cartItem.getQuantity() == 1) {
            delete(cartItemId);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            Product product = mapper.forResponse().map(productService.getById(request.getProductId()), Product.class);
            cartService.minusPriceTotalPrice(totalPrice(product.getUnitPrice(), request.getQuantity()), cart.getId());
            cartItem.setId(cartItemId);
            cartItem.setTotalPrice(cartItem.getTotalPrice() - totalPrice(product.getUnitPrice(), request.getQuantity()));
            repository.save(cartItem);
        }

    }

    @Override
    public void deleteAllByCartId(UUID cartId) {
        repository.deleteAllByCartId(cartId);
    }

    @Override
    public void updateCartItemUnitPriceAntTotalPrice(UpdateCartItemUnitPrice updateCartItemUnitPrice) {

    }

    private double calculateFinalPrice(double price, int discount) {
        return price - ((price * discount) / 100);
    }

    private double totalPrice(double price, int quantity) {
        return price * quantity;
    }

}
