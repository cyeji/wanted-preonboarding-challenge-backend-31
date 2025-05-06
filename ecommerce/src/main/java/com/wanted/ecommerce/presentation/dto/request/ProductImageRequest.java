package com.wanted.ecommerce.presentation.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductImageRequest {

    private String url;

    private String altText;

    private Boolean isPrimary;

    private Integer displayOrder;

    private Long optionId;

}
