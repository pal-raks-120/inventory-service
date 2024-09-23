package com.springpal.retail.web;

import com.springpal.retail.domain.service.InventoriesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retail-inventories")
public class InventoryController {

    private final InventoriesService inventoriesService;
    private InventoryController(InventoriesService inventoriesService){
        this.inventoriesService=inventoriesService;
    }
    @GetMapping("/inventories")
    public String getInventoriesList(@RequestParam(name="page", defaultValue = "10") int pageNo){
        inventoriesService.getListOfInventories(pageNo);
        return "hi";
    }

}
