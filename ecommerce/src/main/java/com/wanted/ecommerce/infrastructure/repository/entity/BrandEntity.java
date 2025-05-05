package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "brands")
public class BrandEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String name;

    private String slug;

    private String description;

    private String logoUrl;

    private String website;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

}
