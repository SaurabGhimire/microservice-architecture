package com.sourrab.microservices.order.dto;

import java.math.BigDecimal;

public record OrderRequest(
        String skuCode,
        BigDecimal price,
        Integer quantity
) {
}