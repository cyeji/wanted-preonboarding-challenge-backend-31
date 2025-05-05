package com.wanted.ecommerce.domain;

import com.wanted.ecommerce.presentation.enums.ProductStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Product {

    private Long id;

    private String name;

    private String slug;

    private String shortDescription;

    private String fullDescription;

    private Long sellerId;

    private Long brandId;

    private ProductStatus status;

    private List<ProductDetail> details;

}
