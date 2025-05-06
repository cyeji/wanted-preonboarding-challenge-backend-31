package com.wanted.ecommerce.presentation.dto.request;

import com.wanted.ecommerce.presentation.enums.ProductStatus;
import lombok.Data;

@Data
public class ProductGetRequest {


    /**
     * 상품 상태 필터
     */
    private ProductStatus status;

    /**
     * 최소 가격
     */
    private Double minPrice;

    /**
     * 최대 가격
     */
    private Double maxPrice;

    /**
     * 카테고리 ID 필터
     */
    private int[] categories;

    /**
     * 판매자 ID
     */
    private Long seller;

    /**
     * 브랜드 ID
     */
    private Long brand;

    /**
     * 재고 유무 필터
     */
    private boolean inStock;

    /**
     * 검색어
     */
    private String search;
}
