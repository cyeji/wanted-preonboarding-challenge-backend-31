package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;

@Entity
public class ProductOptionGroup {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    /**
     * 상품 옵션 그룹명 (ex: 색상, 사이즈)
     */
    @Column
    private String name;

    /**
     * 표시 순서
     */
    @Column
    private Integer displayOrder;

}
