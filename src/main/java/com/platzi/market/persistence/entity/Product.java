package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    private String name;

    @Column(name = "id_category")
    private Integer idCategory;

    private String barCode;

    private BigDecimal price;

    private Integer stock;

    private Boolean status;

    public Integer getIdProduct() {
        return idProduct;
    }

    public Product setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public Product setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
        return this;
    }

    public String getBarCode() {
        return barCode;
    }

    public Product setBarCode(String barCode) {
        this.barCode = barCode;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public Product setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public Product setStatus(Boolean status) {
        this.status = status;
        return this;
    }
}
