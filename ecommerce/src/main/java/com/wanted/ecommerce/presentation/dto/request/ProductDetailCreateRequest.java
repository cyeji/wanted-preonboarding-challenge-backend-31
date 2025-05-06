package com.wanted.ecommerce.presentation.dto.request;

import com.wanted.ecommerce.domain.ProductDetail;
import lombok.Data;

/**
 * 상품 등록 상세 dto
 */
@Data
public class ProductDetailCreateRequest {

    private Double weight;

    private ProductDimension dimensions;

    private String materials;

    private String countryOfOrigin;

    private String warrantyInfo;

    private String careInstructions;

    private AdditionalInfo additionalInfo;

    public ProductDetail toDomain() {
        return ProductDetail.builder()
            .weight(weight)
            .dimensions(dimensions)
            .materials(materials)
            .countryOfOrigin(countryOfOrigin)
            .warrantyInfo(warrantyInfo)
            .careInstructions(careInstructions)
            .additionalInfo(additionalInfo)
            .build();
    }

}
