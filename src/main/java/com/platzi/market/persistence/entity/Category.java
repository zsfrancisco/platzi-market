package com.platzi.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCategory;

    private String description;

    private Boolean status;

    public Integer getIdCategory() {
        return idCategory;
    }

    public Category setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public Category setStatus(Boolean status) {
        this.status = status;
        return this;
    }
}
