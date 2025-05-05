package com.wanted.ecommerce.presentation.dto.response;

import com.wanted.ecommerce.domain.ProductDetail;
import com.wanted.ecommerce.presentation.dto.request.ProductDimension;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductDetailResponse {

    private double weight;
    private int width;
    private int height;
    private int depth;
    private String materials;
    private ProductDimension dimensions;

    public static ProductDetailResponse from(ProductDetail detail) {
        return ProductDetailResponse.builder()
            .weight(detail.getWeight())
            .dimensions(detail.getDimensions())
            .materials(detail.getMaterials())
            .build();
    }

}
