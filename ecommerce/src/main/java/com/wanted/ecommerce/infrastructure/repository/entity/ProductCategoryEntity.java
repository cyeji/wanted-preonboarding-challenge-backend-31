package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.domain.ProductCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 상품 카테고리 매핑 테이블
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_categories")
public class ProductCategoryEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    /**
     * 주요 카테고리 여부
     */
    @Column
    private Boolean isPrimary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    public ProductCategoryEntity(ProductCategory productCategory) {
        this.id = productCategory.getCategoryId();
        this.isPrimary = productCategory.getIsPrimary();
    }

    public static ProductCategoryEntity from(ProductCategory productCategory) {
        return new ProductCategoryEntity(productCategory);
    }

}
