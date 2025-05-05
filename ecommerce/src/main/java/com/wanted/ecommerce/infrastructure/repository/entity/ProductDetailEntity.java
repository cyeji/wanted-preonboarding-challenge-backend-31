package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.domain.ProductDetail;
import com.wanted.ecommerce.presentation.dto.request.AdditionalInfo;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

/**
 * 상품 상세 테이블
 */
@Builder
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_details")
public class ProductDetailEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    /**
     * 무게
     */
    @Column
    private Double weight;

    /**
     * 크기
     */
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Dimension dimensions;

    /**
     * 소재
     */
    @Column
    private String materials;

    /**
     * 원산지
     */
    @Column
    private String countryOfOrigin;

    /**
     * 추가 정보
     */
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private AdditionalInfo additionalInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public ProductDetail toDomain() {
        return ProductDetail.builder()
            .weight(weight)
            .dimensions(dimensions.toDomain())
            .materials(materials)
            .countryOfOrigin(countryOfOrigin)
            .additionalInfo(additionalInfo)
            .build();
    }

}
