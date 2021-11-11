package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getScarceProducts(int stock) {
        return productCrudRepository.findByStockLessThanAndStatus(stock, true);
    }
}
