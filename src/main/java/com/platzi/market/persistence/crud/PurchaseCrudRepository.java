package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.PurchaseData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseData, Integer> {
    List<PurchaseData> findByClientId(String clientId);
}
