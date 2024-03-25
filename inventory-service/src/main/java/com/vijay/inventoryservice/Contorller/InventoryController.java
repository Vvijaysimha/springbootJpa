package com.vijay.inventoryservice.Contorller;

import com.vijay.inventoryservice.Model.Inventory;
import com.vijay.inventoryservice.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventorySerivce;
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable ("sku-code")String skuCode){
    return  inventorySerivce.isInStock(skuCode);
    }
}
