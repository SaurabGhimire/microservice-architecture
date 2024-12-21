package com.sourrab.microservices.product.service;

import com.sourrab.microservices.product.dto.ProductRequest;
import com.sourrab.microservices.product.dto.ProductResponse;
import com.sourrab.microservices.product.model.Product;
import com.sourrab.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse create(ProductRequest productRequest){
        Product product = Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product with id {}, name {}, created", productRequest.id(), productRequest.name());
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public Collection<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream().map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice())).toList();
    }
}
