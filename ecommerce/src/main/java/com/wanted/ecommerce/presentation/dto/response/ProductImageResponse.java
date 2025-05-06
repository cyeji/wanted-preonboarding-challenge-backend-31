package com.wanted.ecommerce.presentation.dto.response;

import com.wanted.ecommerce.presentation.dto.request.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ProductImageResponse {

    private String url;

    private String altText;

    private Boolean isPrimary;

    private Integer displayOrder;

    private Long optionId;

    public ProductImageResponse(ProductImage productImage) {
        this.url = productImage.getUrl();
        this.altText = productImage.getAltText();
        this.isPrimary = productImage.getIsPrimary();
        this.displayOrder = productImage.getDisplayOrder();
        this.optionId = productImage.getOptionId();
    }

    public static ProductImageResponse from(ProductImage productImage) {
        return new ProductImageResponse(productImage);
    }

}
