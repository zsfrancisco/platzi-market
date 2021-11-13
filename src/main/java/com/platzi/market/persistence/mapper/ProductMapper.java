package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.ProductData;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mapping(source = "idProduct", target = "productId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "idCategory", target = "categoryId")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "status", target = "active")
    @Mapping(source = "category", target = "category")
    Product toProduct(ProductData product);

    List<Product> toProducts(List<ProductData> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    ProductData toProductData(Product product);
}
