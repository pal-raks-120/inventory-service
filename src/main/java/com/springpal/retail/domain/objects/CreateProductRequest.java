package com.springpal.retail.domain.objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
@Getter
public record CreateProductRequest(
        @Valid  @NotBlank(message = "Product code is required") String code,
        @Valid  @NotBlank(message = "Product name is required") String name,
        @Valid  @NotBlank(message = "Product description is required") String description,
        String imageUrl,
        @DecimalMin(value = "0.0", inclusive = false)
        @NumberFormat(style = NumberFormat.Style.CURRENCY)
        BigDecimal price) {}