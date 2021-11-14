package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseProduct;
import com.platzi.market.persistence.entity.PurchasesDataProductsData;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseProductMapper {
    @Mapping(source = "id.idProduct", target = "productId")
    @Mapping(source = "amount", target = "quantity")
    @Mapping(source = "status", target = "active")
    PurchaseProduct toPurchaseProduct(PurchasesDataProductsData purchaseProduct);

    @InheritInverseConfiguration
    @Mapping(target = "purchase", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id.idPurchase", ignore = true)
    PurchasesDataProductsData toPurchasesDataProductsData(PurchaseProduct product);
}
