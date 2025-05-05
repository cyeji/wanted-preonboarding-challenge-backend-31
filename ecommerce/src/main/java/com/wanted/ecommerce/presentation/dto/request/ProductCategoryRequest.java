package com.wanted.ecommerce.presentation.dto.request;

import lombok.Data;

@Data
public class ProductCategoryRequest {

    private Long categoryId;

    private Boolean isPrimary;

}
