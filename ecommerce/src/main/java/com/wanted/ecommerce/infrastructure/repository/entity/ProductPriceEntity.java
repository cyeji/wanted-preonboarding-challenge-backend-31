package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;

/**
 * 상품 가격 엔티티
 */
@Entity
public class ProductPriceEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    /**
     * 기본 가격
     */
    @Column
    private Double basePrice;

    /**
     * 할인 가격
     */
    @Column
    private Double salePrice;

    /**
     * 정가
     */
    @Column
    private Double costPrice;

    /**
     * 통화
     */
    @Column
    private String currency = "KRW";

    /**
     * 세금 비율
     */
    @Column
    private Integer taxRate;

}
