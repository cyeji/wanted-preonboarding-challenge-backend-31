package com.wanted.ecommerce.presentation.dto.request;

import com.wanted.ecommerce.domain.Product;
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

    private List<ProductDetailCreateRequest> detail;

    public Product convertToDomain() {
        List<ProductDetail> detailList = this.detail.stream()
            .map(ProductDetailCreateRequest::toDomain)
            .toList();

        return Product.builder().brandId(brandId)
            .name(name)
            .slug(slug)
            .shortDescription(shortDescription)
            .fullDescription(fullDescription)
            .status(status)
            .details(detailList)
            .build();
    }

}
