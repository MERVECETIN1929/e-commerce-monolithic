package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.OrderDetailsService;
import com.example.ecommercemono2.business.dto.response.orderDetails.GetAllOrderDetailsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/order-detail")
@RestController
@AllArgsConstructor
public class OrderDetailsController {
    private final OrderDetailsService service;
    @GetMapping("/{orderId}")
    //@PostAuthorize("returnObject.userId.equals(authentication.principal.id)")
    public List<GetAllOrderDetailsResponse> getAllOrderDetailsByOrderId(@RequestParam UUID orderId){
        return service.getAllOrderDetailsByOrderId(orderId);
    }

}
