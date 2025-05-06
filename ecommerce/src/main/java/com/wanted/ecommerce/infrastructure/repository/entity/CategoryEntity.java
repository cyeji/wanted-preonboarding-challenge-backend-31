package com.wanted.ecommerce.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 상품 카테고리
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    /**
     * 카테고리명
     */
    @Column
    private String name;

    /**
     * 카테고리 슬러그
     */
    @Column
    private String slug;

    /**
     * 카테고리 설명
     */
    @Column
    private String description;

    /**
     * 카테고리 이미지
     */
    @Column
    private String imageUrl;

    /**
     * 카테고리 레벨
     * (1: 대분류, 2: 중분류, 3: 소분류)
     */
    @Column
    private Integer level;

    /**
     * 카테고리 부모 ID  (FK, 자기참조)
     */
    @ManyToOne @JoinColumn(name = "parent_id")
    private CategoryEntity parent;

    @OneToMany(mappedBy = "parent")
    private List<CategoryEntity> children;

}
