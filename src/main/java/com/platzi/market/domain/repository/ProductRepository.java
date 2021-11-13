package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAllProducts();

    List<Product> getProductsByCategory(int categoryId);

    List<Product> getScarceProducts(int quantity);

    Optional<Product> getProduct(int productId);

    Product saveProduct(Product product);

    void deleteProduct(int productId);
}
