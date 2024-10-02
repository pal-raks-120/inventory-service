package com.springpal.retail.web.controller;

import com.springpal.retail.common.PagedResult;
import com.springpal.retail.domain.mapper.ProductMapper;
import com.springpal.retail.domain.objects.CreateProductRequest;
import com.springpal.retail.domain.objects.CreateProductResponse;
import com.springpal.retail.domain.objects.Product;
import com.springpal.retail.domain.service.InventoriesService;
//import lombok.extern.slf4j.Slf4j;
import com.springpal.retail.web.exception.ProductNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventories")
//@Slf4j->this needs extra dependancy which lombok won't dowload autoatically,so choose org.slf4j
/*<dependency>
<groupId>org.slf4j</groupId>
<artifactId>slf4j-api</artifactId>
<version>1.7.26</version>
</dependency>*/
class InventoryController {
    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);
    private final InventoriesService inventoriesService;
    private InventoryController(InventoriesService inventoriesService){
        this.inventoriesService=inventoriesService;
    }
    @GetMapping
    public PagedResult<Product> getInventoriesList(@RequestParam(name="page", defaultValue = "1") int pageNo){
        log.info("Fetching products for page: {}", pageNo);
        return inventoriesService.getListOfInventories(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code) {
        log.info("Fetching product for code: {}", code);
        return inventoriesService
                .getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateProductResponse addProductForInvetory(@Valid @RequestBody CreateProductRequest productRequest) {
        log.info("Creating product: {}", productRequest);
       Product product= ProductMapper.toProductFromRequest(productRequest);
        return inventoriesService.createProduct(product);
    }
}
