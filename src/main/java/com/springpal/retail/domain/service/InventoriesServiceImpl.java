package com.springpal.retail.domain.service;


import com.springpal.retail.common.ApplicationProperties;
import com.springpal.retail.common.PagedResult;
import com.springpal.retail.domain.dto.Product;
import com.springpal.retail.domain.mapper.ProductMapper;
import com.springpal.retail.domain.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class InventoriesServiceImpl implements InventoriesService {
    private final ProductRepository productRepository;
    private final ApplicationProperties properties;

    InventoriesServiceImpl(ProductRepository productRepository, ApplicationProperties properties) {
        this.productRepository = productRepository;
        this.properties=properties;
    }

    @Override
    public PagedResult<Product> getListOfInventories(int pageNo) {
        Sort sort = Sort.by("name").ascending();
        pageNo = pageNo <= 1 ? 0 : pageNo - 1;
        Pageable pageable = PageRequest.of(pageNo,properties.pageSize(),sort);
       var productsPage = productRepository.findAll(pageable).
               map(ProductMapper::toProduct);
        return new PagedResult<>(
                productsPage.getContent(),
                productsPage.getTotalElements(),
                productsPage.getNumber() + 1,
                productsPage.getTotalPages(),
                productsPage.isFirst(),
                productsPage.isLast(),
                productsPage.hasNext(),
                productsPage.hasPrevious());
    }

    public Optional<Product> getProductByCode(String code) {
        return productRepository.findByCode(code).map(ProductMapper::toProduct);
    }
}
