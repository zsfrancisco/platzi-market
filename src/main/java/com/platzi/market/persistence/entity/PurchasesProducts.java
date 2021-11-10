package com.platzi.market.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "purchases_products")
public class PurchasesProducts {

    @EmbeddedId
    private PurchasesProductsPK id;

    private Integer amount;

    private Double total;

    private Boolean status;

    public PurchasesProductsPK getId() {
        return id;
    }

    public PurchasesProducts setId(PurchasesProductsPK id) {
        this.id = id;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public PurchasesProducts setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public PurchasesProducts setTotal(Double total) {
        this.total = total;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public PurchasesProducts setStatus(Boolean status) {
        this.status = status;
        return this;
    }
}