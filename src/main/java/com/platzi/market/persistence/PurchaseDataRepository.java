package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.PurchaseCrudRepository;
import com.platzi.market.persistence.entity.PurchaseData;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PurchaseDataRepository implements PurchaseRepository {
    private final PurchaseCrudRepository purchaseCrudRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAllPurchases() {
        return purchaseMapper.toPurchases((List<PurchaseData>) purchaseCrudRepository.findAll());
    }

    @Override
    public List<Purchase> getPurchasesByClient(String clientId) {
        return purchaseMapper.toPurchases(purchaseCrudRepository.findByClientId(clientId));
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {
        PurchaseData purchaseData = purchaseMapper.toPurchaseData(purchase);
        purchaseData.getProducts().forEach(product -> product.setPurchase(purchaseData));
        return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseData));
    }
}
