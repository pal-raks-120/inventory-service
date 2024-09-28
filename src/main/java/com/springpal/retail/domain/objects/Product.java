package com.springpal.retail.domain.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
/*@NoArgsConstructor
@AllArgsConstructor
@Builder*/
//Current scenario as adding code in request so no need to builder
@Getter
public record Product(String code, String name, String description, String imageUrl, BigDecimal price) {}
