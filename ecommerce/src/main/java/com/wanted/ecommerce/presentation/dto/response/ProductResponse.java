package com.wanted.ecommerce.presentation.dto.response;

import com.wanted.ecommerce.domain.Product;
import com.wanted.ecommerce.presentation.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private Long sellerId;
    private Long brandId;
    private ProductStatus status;
    private List<ProductDetailResponse> details = new ArrayList<>();

    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .slug(product.getSlug())
            .shortDescription(product.getShortDescription())
            .fullDescription(product.getFullDescription())
            .sellerId(product.getSellerId())
            .brandId(product.getBrandId())
            .status(product.getStatus())
            .details(product.getDetails().stream()
                         .map(ProductDetailResponse::from)
                         .toList())
            .build();
    }

}
