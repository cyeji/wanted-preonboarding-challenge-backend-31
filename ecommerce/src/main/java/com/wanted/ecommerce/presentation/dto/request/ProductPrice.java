package com.wanted.ecommerce.presentation.dto.request;

import lombok.Data;

@Data
public class ProductPrice {

    private Double basePrice;

    private Double salePrice;

    private Double costPrice;

    private String currency;

    private Integer taxRate;

}
