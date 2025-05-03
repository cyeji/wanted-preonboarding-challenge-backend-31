package com.wanted.ecommerce.presentation.dto.request;

import lombok.Data;

import java.util.List;

/**
 * 상품 등록 상세 dto
 */
@Data
public class ProductDetailCreateRequest {

    private Double weight;

    private ProductDimension dimensions;

    private String materials;

    private String countryOfOrigin;

    private String warrantyInfo;

    private String careInstructions;

    private AdditionalInfo additionalInfo;

    private ProductPrice price;

    private List<ProductCategory> categories;

    private List<OptionGroup> optionGroups;

}
