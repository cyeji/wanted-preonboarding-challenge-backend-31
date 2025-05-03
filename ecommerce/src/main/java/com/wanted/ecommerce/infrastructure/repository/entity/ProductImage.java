package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;

@Entity
public class ProductImage {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    /**
     * 이미지 url
     */
    @Column
    private String url;

    /**
     * 대체 텍스트
     */
    @Column
    private String allText;

    /**
     * 대표 이미지 여부
     */
    @Column
    private Boolean isPrimary;

    /**
     * 표시 순서
     */
    @Column
    private Integer displayOrder;

}
