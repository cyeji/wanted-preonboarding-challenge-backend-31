package com.wanted.ecommerce.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wanted.ecommerce.infrastructure.repository.entity.Dimension;
import lombok.Builder;
import lombok.Getter;

/**
 * 상품 수치 dto
 */
@Getter
@Builder
public class ProductDimension {

    /**
     * 상품 폭
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * 상품 길이
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * 상품 너비
     */
    @JsonProperty("depth")
    private Integer depth;

    public Dimension toDto() {
        return new Dimension(width, height, depth);
    }

}
