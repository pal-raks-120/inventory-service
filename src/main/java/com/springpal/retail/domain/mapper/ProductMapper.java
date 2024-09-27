package com.springpal.retail.domain.mapper;

import com.springpal.retail.domain.objects.Product;
import com.springpal.retail.domain.repo.ProductEntity;

public class ProductMapper {
    public static Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getPrice());
    }
}
