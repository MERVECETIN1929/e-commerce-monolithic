package com.example.ecommercemono2.common.mapper;


import com.example.ecommercemono2.business.abstracts.BrandService;
import com.example.ecommercemono2.business.abstracts.CategoryService;
import com.example.ecommercemono2.business.dto.request.product.CreateProductRequest;
import com.example.ecommercemono2.business.dto.request.product.UpdateProductRequest;
import com.example.ecommercemono2.entities.Brand;
import com.example.ecommercemono2.entities.Category;
import com.example.ecommercemono2.entities.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductMapper {
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final ModelMapper mapper;

    public Product createProductRerquestToProduct(CreateProductRequest request) {
        Brand brand = mapper.map(brandService.getById(request.getBrandId()), Brand.class);
        Category category = mapper.map(categoryService.getById(request.getCategoryId()), Category.class);
        Product product = new Product();
        product.setId(null);
        product.setBrand(brand);
        product.setCategory(category);
        product.setName(request.getName());
        product.setColor(request.getColor());
        product.setStock(request.getStock());
        product.setInformation(request.getInformation());
        product.setUnitPrice(request.getUnitPrice());
        return product;
    }

    public Product updateProductRerquestToProduct(UpdateProductRequest request) {
        Brand brand = mapper.map(brandService.getById(request.getBrandId()), Brand.class);
        Category category = mapper.map(categoryService.getById(request.getCategoryId()), Category.class);
        Product product = new Product();
        product.setBrand(brand);
        product.setCategory(category);
        product.setName(request.getName());
        product.setColor(request.getColor());
        product.setStock(request.getStock());
        product.setInformation(request.getInformation());

        return product;
    }
}
