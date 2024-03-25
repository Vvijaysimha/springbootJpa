package com.vijay.inventoryservice.Contorller;

import com.vijay.inventoryservice.Dto.InventoryResponse;
import com.vijay.inventoryservice.Model.Inventory;
import com.vijay.inventoryservice.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventorySerivce;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
    return  inventorySerivce.isInStock(skuCode);
    }
}
