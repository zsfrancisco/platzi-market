package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @GetMapping()
    @ApiOperation("Get all supermarket purchases")
    @ApiResponse(code = 200, message = "Purchases")
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(purchaseService.getAllPurchases());
    }

    @GetMapping("/client/{id}")
    @ApiOperation("Get all supermarket purchases by client id")
    @ApiResponse(code = 200, message = "Purchases")
    public ResponseEntity<List<Purchase>> getPurchasesByClient(@PathVariable("id") String clientId) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(purchaseService.getPurchasesByClient(clientId));
    }

    @PostMapping()
    @ApiOperation("Save a new supermarket purchase")
    @ApiResponse(code = 200, message = "Purchase created")
    public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(purchaseService.savePurchase(purchase));
    }
}
