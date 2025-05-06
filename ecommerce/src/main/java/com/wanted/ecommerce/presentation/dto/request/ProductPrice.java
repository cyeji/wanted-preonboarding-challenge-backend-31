package com.wanted.ecommerce.presentation.dto.request;

import com.wanted.ecommerce.infrastructure.repository.entity.ProductPriceEntity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductPrice {

    private Double basePrice;

    private Double salePrice;

    private Double costPrice;

    private String currency;

    private Integer taxRate;

    public ProductPriceEntity toEntity() {
        return ProductPriceEntity.builder()
            .basePrice(basePrice)
            .salePrice(salePrice)
            .costPrice(costPrice)
            .currency(currency)
            .taxRate(taxRate)
            .build();
    }

}
