package com.wanted.ecommerce.application;

import com.wanted.ecommerce.infrastructure.utils.ApiUtils;
import com.wanted.ecommerce.presentation.dto.request.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    public ApiUtils.ApiResult createProduct(ProductCreateRequest productCreateRequest) {
        
    }

}
