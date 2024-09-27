package com.springpal.retail.domain.objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateProductRequest(
        @Valid  @NotBlank(message = "Product name is required") String name,
        @Valid  @NotBlank(message = "Product description is required") String description,
        String imageUrl,
        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer=3, fraction=2)
        BigDecimal price) {}