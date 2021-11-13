package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public List<Product> getProductsByCategory(int categoryId) {
        return productRepository.getProductsByCategory(categoryId);
    }

    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    public boolean deleteProduct(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.deleteProduct(productId);
            return true;
        }).orElse(false);
    }
}
