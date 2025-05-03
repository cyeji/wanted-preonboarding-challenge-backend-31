package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.presentation.dto.request.AdditionalInfo;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

/**
 * 상품 상세 테이블
 */
@Entity
public class ProductDetailEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    /**
     * 무게
     */
    @Column
    private String weight;

    /**
     * 크기
     */
    @Type(JsonType.class)
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
    private AdditionalInfo additionalInfo;

}
