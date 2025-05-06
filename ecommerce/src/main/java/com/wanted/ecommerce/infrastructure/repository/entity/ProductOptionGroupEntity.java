package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.presentation.dto.request.OptionGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_option_groups")
public class ProductOptionGroupEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    public ProductOptionGroupEntity(OptionGroup optionGroup) {
        this.name = optionGroup.getName();
        this.displayOrder = optionGroup.getDisplayOrder();
    }

    public static ProductOptionGroupEntity from(OptionGroup optionGroup) {
        return new ProductOptionGroupEntity(optionGroup);
    }

}
