package com.wanted.ecommerce.presentation.dto.request;

import com.wanted.ecommerce.domain.Product;
import com.wanted.ecommerce.domain.ProductCategory;
import com.wanted.ecommerce.domain.ProductDetail;
import com.wanted.ecommerce.presentation.enums.ProductStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 상품 등록 요청
 */
@Builder
@Data
public class ProductCreateRequest {

    private String name;

    private String slug;

    private String shortDescription;

    private String fullDescription;

    private Long sellerId;

    private Long brandId;

    private ProductStatus status;

    private ProductPrice price;

    private List<ProductDetailCreateRequest> detail;

    private List<ProductImageRequest> images;

    private List<OptionGroup> optionGroups;

    private List<ProductCategoryRequest> categories;

    public Product convertToDomain() {
        List<ProductDetail> detailList = this.detail.stream()
            .map(ProductDetailCreateRequest::toDomain)
            .toList();

        List<ProductImage> productList = this.images.stream().map(ProductImage::toDomain).toList();

        List<ProductCategory> categories = this.categories.stream().map(ProductCategory::toDomain).toList();

        return Product.builder().brandId(brandId)
            .sellerId(sellerId)
            .name(name)
            .price(price)
            .slug(slug)
            .shortDescription(shortDescription)
            .fullDescription(fullDescription)
            .status(status)
            .details(detailList)
            .images(productList)
            .optionGroups(optionGroups)
            .categories(categories)
            .build();
    }

}
