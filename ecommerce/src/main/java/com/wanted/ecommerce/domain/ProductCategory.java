package com.wanted.ecommerce.domain;

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

}
