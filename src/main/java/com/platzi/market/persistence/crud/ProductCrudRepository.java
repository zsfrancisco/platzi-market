package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.ProductData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<ProductData, Integer> {

    List<ProductData> findByIdCategoryOrderByNameAsc(int idCategory);

    List<ProductData> findByStockLessThanAndStatus(int stock, boolean status);
}
