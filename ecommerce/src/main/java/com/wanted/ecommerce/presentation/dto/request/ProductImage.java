package com.wanted.ecommerce.presentation.dto.request;

import com.wanted.ecommerce.infrastructure.repository.entity.ProductImageEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductImage {

    private String url;

    private String altText;

    private Boolean isPrimary;

    private Integer displayOrder;

    private Long optionId;

    public static ProductImage toDomain(ProductImageEntity productImageEntity) {
        return ProductImage.builder()
            .url(productImageEntity.getUrl())
            .altText(productImageEntity.getAltText())
            .isPrimary(productImageEntity.getIsPrimary())
            .displayOrder(productImageEntity.getDisplayOrder())
            .build();
    }

    public static ProductImage toDomain(ProductImageRequest productImageRequest) {
        return ProductImage.builder()
            .url(productImageRequest.getUrl())
            .altText(productImageRequest.getAltText())
            .isPrimary(productImageRequest.getIsPrimary())
            .displayOrder(productImageRequest.getDisplayOrder())
            .build();
    }

}
