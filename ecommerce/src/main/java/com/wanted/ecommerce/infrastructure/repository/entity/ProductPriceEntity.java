package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.presentation.dto.request.ProductPrice;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

/**
 * 상품 가격 엔티티
 */
@Builder
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "product_prices")
public class ProductPriceEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    public ProductPrice toDomain() {
        return ProductPrice.builder()
            .basePrice(basePrice)
            .salePrice(salePrice)
            .costPrice(costPrice)
            .currency(currency)
            .taxRate(taxRate)
            .build();
    }

}
