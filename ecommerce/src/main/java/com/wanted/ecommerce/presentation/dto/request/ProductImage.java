package com.wanted.ecommerce.presentation.dto.request;

import lombok.Data;

@Data
public class ProductImage {

    private String url;

    private String altText;

    private Boolean isPrimary;

    private Integer displayOrder;

    private Long optionId;

}
