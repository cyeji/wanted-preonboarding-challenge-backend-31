package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;

/**
 * 상품 카테고리 매핑 테이블
 */
@Entity
public class ProductCategoryEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    /**
     * 주요 카테고리 여부
     */
    @Column
    private Boolean isPrimary;

}
