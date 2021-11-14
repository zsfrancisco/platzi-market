package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.getAllPurchases();
    }

    public List<Purchase> getPurchasesByClient(String clientId) {
        return purchaseRepository.getPurchasesByClient(clientId);
    }

    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.savePurchase(purchase);
    }
}
