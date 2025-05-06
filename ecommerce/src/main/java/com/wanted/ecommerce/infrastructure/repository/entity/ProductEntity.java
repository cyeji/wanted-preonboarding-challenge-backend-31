package com.wanted.ecommerce.infrastructure.repository.entity;

import com.wanted.ecommerce.domain.Product;
import com.wanted.ecommerce.domain.ProductCategory;
import com.wanted.ecommerce.presentation.dto.request.OptionGroup;
import com.wanted.ecommerce.presentation.dto.request.ProductImage;
import com.wanted.ecommerce.presentation.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 상품 엔티티
 */
@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class ProductEntity extends CreatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    /**
     * 상품명
     */
    @Column
    private String name;

    /**
     * 상품 슬러그
     */
    @Column
    private String slug;

    /**
     * 상품 썸네일
     */
    @Column
    private String shortDescription;

    /**
     * 상품 상세 설명
     */
    @Column
    private String fullDescription;

    /**
     * 판매 상태
     */
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private SellerEntity seller;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductDetailEntity> productDetail = new HashSet<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ProductPriceEntity price;

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductImageEntity> images = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductOptionGroupEntity> optionGroups = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductCategoryEntity> categories = new HashSet<>();

    public static ProductEntity of(Product productRequest, SellerEntity sellerEntity, BrandEntity brandEntity) {
        return ProductEntity.builder()
                .name(productRequest.getName())
                .slug(productRequest.getSlug())
                .shortDescription(productRequest.getShortDescription())
                .fullDescription(productRequest.getFullDescription())
                .status(productRequest.getStatus())
                .seller(sellerEntity)
                .brand(brandEntity)
                .build();
    }

    public Product toDomain() {
        return Product.builder()
                .id(this.id)
                .name(this.name)
                .slug(this.slug)
                .shortDescription(this.shortDescription)
                .fullDescription(this.fullDescription)
                .status(this.status)
                .sellerId(this.seller != null ? this.seller.getId() : null)
                .brandId(this.brand != null ? this.brand.getId() : null)
                .details(this.productDetail.stream().map(ProductDetailEntity::toDomain)
                        .toList())
                .price(this.price.toDomain())
                .images(this.images.stream().map(ProductImage::toDomain).toList())
                .optionGroups(this.optionGroups.stream().map(OptionGroup::from).toList())
                .categories(this.categories.stream().map(ProductCategory::from).toList())
                .build();
    }

    public Product toDomain(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .slug(productEntity.getSlug())
                .shortDescription(productEntity.getShortDescription())
                .fullDescription(productEntity.getFullDescription())
                .status(productEntity.getStatus())
                .sellerId(productEntity.getSeller() != null ? productEntity.getSeller().getId() : null)
                .brandId(productEntity.getBrand() != null ? productEntity.getBrand().getId() : null)
                .details(productEntity.getProductDetail().stream().map(ProductDetailEntity::toDomain)
                        .toList())
                .price(productEntity.getPrice().toDomain())
                .images(productEntity.getImages().stream().map(ProductImage::toDomain).toList())
                .optionGroups(productEntity.getOptionGroups().stream().map(OptionGroup::from).toList())
                .categories(productEntity.getCategories().stream().map(ProductCategory::from).toList())
                .build();
    }


}
