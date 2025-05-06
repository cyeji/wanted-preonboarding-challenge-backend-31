package com.wanted.ecommerce.domain;

import com.wanted.ecommerce.presentation.dto.request.AdditionalInfo;
import com.wanted.ecommerce.presentation.dto.request.ProductCategoryRequest;
import com.wanted.ecommerce.presentation.dto.request.ProductDimension;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductDetail {

    private Double weight;

    private ProductDimension dimensions;

    private String materials;

    private String countryOfOrigin;

    private String warrantyInfo;

    private String careInstructions;

    private AdditionalInfo additionalInfo;

    private List<ProductCategoryRequest> categories;

}
