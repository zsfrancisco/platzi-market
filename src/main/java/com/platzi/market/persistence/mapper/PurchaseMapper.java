package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.entity.PurchaseData;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseProductMapper.class})
public interface PurchaseMapper {
    @Mapping(source = "idPurchase", target = "purchaseId")
    @Mapping(source = "idClient", target = "clientId")
    @Mapping(source = "status", target = "state")
    Purchase toPurchase(PurchaseData purchase);

    List<Purchase> toPurchases(List<PurchaseData> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    PurchaseData toPurchaseData(Purchase purchase);
}
