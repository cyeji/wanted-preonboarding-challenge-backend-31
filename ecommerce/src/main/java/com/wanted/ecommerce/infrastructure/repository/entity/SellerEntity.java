package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;

@Entity
public class SellerEntity extends UpdatedEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

}
