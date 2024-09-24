package com.springpal.retail.domain.service;


import com.springpal.retail.common.PagedResult;
import com.springpal.retail.domain.dto.Product;
import com.springpal.retail.domain.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
class InventoriesServiceImpl implements InventoriesService {
    private final ProductRepository productRepository;

    InventoriesServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public PagedResult<Product> getListOfInventories(int page) {
        Pageable pageable = PageRequest.of(1,2);
       // Page<Product> productsPage =
                productRepository.findAll(pageable);

        return null;
    }
}
