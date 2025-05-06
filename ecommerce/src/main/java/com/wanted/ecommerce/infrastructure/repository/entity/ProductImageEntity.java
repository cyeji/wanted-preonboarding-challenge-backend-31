package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.presentation.dto.request.ProductImage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_images")
public class ProductImageEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String altText;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    private ProductOptionEntity option;

    public ProductImageEntity(ProductImage productImage, ProductEntity productEntity) {
        this.url = productImage.getUrl();
        this.altText = productImage.getAltText();
        this.isPrimary = productImage.getIsPrimary();
        this.displayOrder = productImage.getDisplayOrder();
        this.product = productEntity;
    }

    public static ProductImageEntity from(ProductImage productImage, ProductEntity productEntity) {
        return new ProductImageEntity(productImage, productEntity);
    }

}
