package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PurchasesProductsPK implements Serializable {

    @Column(name = "id_purchase")
    private Integer idPurchase;

    @Column(name = "id_product")
    private Integer idProduct;

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public PurchasesProductsPK setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
        return this;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public PurchasesProductsPK setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
        return this;
    }
}
