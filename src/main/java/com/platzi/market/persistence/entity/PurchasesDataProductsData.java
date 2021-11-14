package com.platzi.market.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "purchases_products")
@Getter
@Setter
public class PurchasesDataProductsData {

    @EmbeddedId
    private PurchasesDataProductsDataPK id;

    private Integer amount;

    private Double total;

    private Boolean status;

    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
    private PurchaseData purchase;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private ProductData product;
}
