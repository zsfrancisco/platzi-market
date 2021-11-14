package com.platzi.market.domain.repository;

import com.platzi.market.domain.Purchase;

import java.util.List;

public interface PurchaseRepository {
    List<Purchase> getAllPurchases();

    List<Purchase> getPurchasesByClient(String clientId);

    Purchase savePurchase(Purchase purchase);
}
