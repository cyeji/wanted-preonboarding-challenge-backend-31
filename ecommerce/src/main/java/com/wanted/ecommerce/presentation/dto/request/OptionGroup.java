package com.wanted.ecommerce.presentation.dto.request;

import com.wanted.ecommerce.infrastructure.repository.entity.ProductOptionGroupEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OptionGroup {

    private String name;

    private Double additionalPrice;

    //    private String sku;

    //    private Long stock;

    private Integer displayOrder;
    //
    //    private List<ProductImage> images;
    //
    //    private List<Long> tags;

    public static OptionGroup from(ProductOptionGroupEntity productOptionGroupEntity) {
        return OptionGroup.builder()
            .name(productOptionGroupEntity.getName())
            .displayOrder(productOptionGroupEntity.getDisplayOrder())
            .build();
    }

}
