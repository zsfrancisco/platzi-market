package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.CategoryData;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "idCategory", target = "categoryId")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "status", target = "active")
    Category toCategory(CategoryData category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryData toCategoryData(Category category);
}
