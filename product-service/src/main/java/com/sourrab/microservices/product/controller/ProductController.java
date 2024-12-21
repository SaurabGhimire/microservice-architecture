package com.sourrab.microservices.product.controller;

import com.sourrab.microservices.product.dto.ProductRequest;
import com.sourrab.microservices.product.dto.ProductResponse;
import com.sourrab.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(ProductRequest productRequest){
        return productService.create(productRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Collection<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
