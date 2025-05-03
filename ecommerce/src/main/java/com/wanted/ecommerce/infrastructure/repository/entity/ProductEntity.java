package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.presentation.enums.ProductStatus;
import jakarta.persistence.*;

/**
 * 상품 엔티티
 */
@Entity
public class ProductEntity extends CreatedEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    /**
     * 상품명
     */
    @Column
    private String name;

    /**
     * 상품 슬러그
     */
    @Column
    private String slug;

    /**
     * 상품 썸네일
     */
    @Column
    private String shortDescription;

    /**
     * 상품 상세 설명
     */
    @Column
    private String fullDescription;

    /**
     * 판매 상태
     */
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

}
