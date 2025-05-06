package com.wanted.ecommerce.presentation;

import com.wanted.ecommerce.application.ProductService;
import com.wanted.ecommerce.infrastructure.config.CustomUserDetails;
import com.wanted.ecommerce.infrastructure.utils.ApiUtils;
import com.wanted.ecommerce.presentation.dto.request.ProductCreateRequest;
import com.wanted.ecommerce.presentation.dto.request.ProductGetRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity registerProducts(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestBody ProductCreateRequest productCreateRequest) {
        Long userId = userDetails != null ? userDetails.getUserId() : null;
        return ResponseEntity.ok(ApiUtils.success(productService.createProduct(userId, productCreateRequest.convertToDomain())));
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity getProduct(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @PathVariable Long productId) {
        Long userId = userDetails != null ? userDetails.getUserId() : null;
        return ResponseEntity.ok(ApiUtils.success(productService.getProduct(userId, productId)));
    }

    @GetMapping("/products")
    public ResponseEntity getProducts(@RequestBody ProductGetRequest productGetRequest,
                                      @PageableDefault(sort = "price")
                                      Pageable pageable) {

        return ResponseEntity.ok(ApiUtils.success(productService.getProduct(productGetRequest, pageable)));
    }

}
