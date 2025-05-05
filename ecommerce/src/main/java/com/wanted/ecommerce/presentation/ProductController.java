package com.wanted.ecommerce.presentation;

import com.wanted.ecommerce.application.ProductService;
import com.wanted.ecommerce.infrastructure.config.CustomUserDetails;
import com.wanted.ecommerce.infrastructure.utils.ApiUtils;
import com.wanted.ecommerce.presentation.dto.request.ProductCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(
        @AuthenticationPrincipal CustomUserDetails userDetails,
        @PathVariable Long productId) {
        Long userId = userDetails != null ? userDetails.getUserId() : null;
        return ResponseEntity.ok(ApiUtils.success(productService.getProduct(userId, productId)));
    }

}
