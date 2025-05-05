package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_options")
public class ProductOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 연관 관계 설정 (ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_group_id", nullable = false)
    private ProductOptionGroupEntity optionGroup;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "additional_price")
    private Double additionalPrice = 0.0;

    @Column(length = 100)
    private String sku;

    @Column
    private Integer stock = 0;

    @Column(name = "display_order")
    private Integer displayOrder = 0;

}
