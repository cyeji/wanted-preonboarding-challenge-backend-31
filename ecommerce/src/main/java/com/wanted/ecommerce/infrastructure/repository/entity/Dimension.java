package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.presentation.dto.request.ProductDimension;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Dimension {

    /**
     * 상품 폭
     */
    private Integer width;

    /**
     * 상품 길이
     */
    private Integer height;

    /**
     * 상품 너비
     */
    private Integer depth;

    public Dimension(Integer width, Integer height, Integer depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public ProductDimension toDomain() {
        return ProductDimension.builder()
            .width(width)
            .height(height)
            .depth(depth)
            .build();
    }

}
