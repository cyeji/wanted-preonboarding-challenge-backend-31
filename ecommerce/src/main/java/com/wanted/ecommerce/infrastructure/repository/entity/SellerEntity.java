package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "sellers")
public class SellerEntity extends UpdatedEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String logoUrl;

    @Column
    private Double rating;

    @Column
    private String contactEmail;

    @Column
    private String contactPhone;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

}
