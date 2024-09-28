package com.springpal.retail.domain.mapper;

import com.springpal.retail.domain.objects.CreateProductRequest;
import com.springpal.retail.domain.objects.Product;
import com.springpal.retail.domain.repo.ProductEntity;

public class ProductMapper {
    public static Product toProductFromEntity(ProductEntity productEntity) {
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImageUrl(),
                productEntity.getPrice());
    }

    public static Product toProductFromRequest(CreateProductRequest productRequest) {
      /*  return Product.builder().name(productRequest.name()).description(productRequest.description())
                .imageUrl(productRequest.imageUrl()).price(productRequest.price()).build();*/
        //No need for builder
        return new  Product(
                productRequest.getCode(),
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getImageUrl(),
                productRequest.getPrice());
    }

    public static ProductEntity convertToEntity(Product product){
        ProductEntity productEntity= new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setImageUrl(product.getImageUrl());
        productEntity.setPrice(product.getPrice());
        return productEntity;
    }
}
