package com.wanted.ecommerce.presentation.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class OptionGroup {

    private String name;

    private Double additionalPrice;

    private String sku;

    private Long stock;

    private Integer displayOrder;

    private List<ProductImage> images;

    private List<Long> tags;

}
