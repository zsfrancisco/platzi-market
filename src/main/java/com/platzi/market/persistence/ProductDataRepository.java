package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.ProductData;
import com.platzi.market.persistence.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductDataRepository implements ProductRepository {

    private final ProductCrudRepository productCrudRepository;
    private final ProductMapper productMapper;

    @Override
    public List<Product> getAllProducts() {
        List<ProductData> products = (List<ProductData>) productCrudRepository.findAll();
        return productMapper.toProducts(products);
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        List<ProductData> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return productMapper.toProducts(products);
    }

    @Override
    public List<Product> getScarceProducts(int quantity) {
        List<ProductData> products = productCrudRepository.findByStockLessThanAndStatus(quantity, true);
        return productMapper.toProducts(products);
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(productMapper::toProduct);
    }

    @Override
    public Product saveProduct(Product product) {
        ProductData productData = productMapper.toProductData(product);
        return productMapper.toProduct(productCrudRepository.save(productData));
    }

    @Override
    public void deleteProduct(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
