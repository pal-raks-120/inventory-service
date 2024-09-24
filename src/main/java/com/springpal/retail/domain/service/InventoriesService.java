package com.springpal.retail.domain.service;

import com.springpal.retail.common.PagedResult;
import com.springpal.retail.domain.dto.Product;

import java.util.List;
import java.util.Optional;

public interface InventoriesService {
    PagedResult<Product> getListOfInventories(int page);
}
