package com.wanted.ecommerce.presentation.dto.request;

import com.wanted.ecommerce.presentation.enums.ProductStatus;
import lombok.Data;

import java.util.List;

/**
 * 상품 등록 요청
 */
@Data
public class ProductCreateRequest {

    private String name;

    private String slug;

    private String shortDescription;

    private String fullDescription;

    private Long sellerId;

    private Long brandId;

    private ProductStatus status;

    private List<ProductDetailCreateRequest> detail;

}
