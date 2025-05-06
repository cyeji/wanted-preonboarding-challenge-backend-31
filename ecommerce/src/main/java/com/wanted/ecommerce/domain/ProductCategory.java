package com.wanted.ecommerce.domain;

import com.wanted.ecommerce.infrastructure.repository.entity.ProductCategoryEntity;
import com.wanted.ecommerce.presentation.dto.request.ProductCategoryRequest;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProductCategory {

    private Long categoryId;

    private Boolean isPrimary;

    public ProductCategory(Long categoryId, Boolean isPrimary) {
        this.categoryId = categoryId;
        this.isPrimary = isPrimary;
    }

    public ProductCategory(ProductCategoryEntity productCategoryEntity) {
        this.categoryId = productCategoryEntity.getId();
        this.isPrimary = productCategoryEntity.getIsPrimary();
    }

    public static ProductCategory from(ProductCategoryEntity productCategoryEntity) {
        return new ProductCategory(productCategoryEntity);
    }

    public static ProductCategory toDomain(ProductCategoryRequest productCategoryRequest) {
        return new ProductCategory(productCategoryRequest.getCategoryId(), productCategoryRequest.getIsPrimary());
    }

}
