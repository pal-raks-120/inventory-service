package com.springpal.retail.domain.service;

import com.springpal.retail.common.PagedResult;
import com.springpal.retail.domain.objects.CreateProductRequest;
import com.springpal.retail.domain.objects.CreateProductResponse;
import com.springpal.retail.domain.objects.Product;

import java.util.Optional;

public interface InventoriesService {
    PagedResult<Product> getListOfInventories(int page);
    Optional<Product> getProductByCode(String code);
    CreateProductResponse createProduct(Product product);
}
