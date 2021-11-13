package com.platzi.market.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private int productId;
    private String name;
    private int categoryId;
    private BigDecimal price;
    private Integer stock;
    private Boolean active;
    private Category category;
}
