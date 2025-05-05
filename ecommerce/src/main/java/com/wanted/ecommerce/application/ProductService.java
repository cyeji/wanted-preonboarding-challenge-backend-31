package com.wanted.ecommerce.application;

import com.wanted.ecommerce.domain.Product;
import com.wanted.ecommerce.infrastructure.config.error.exception.ProductNotFoundException;
import com.wanted.ecommerce.infrastructure.repository.BrandRepository;
import com.wanted.ecommerce.infrastructure.repository.ProductDetailRepository;
import com.wanted.ecommerce.infrastructure.repository.ProductRepository;
import com.wanted.ecommerce.infrastructure.repository.SellerRepository;
import com.wanted.ecommerce.infrastructure.repository.entity.BrandEntity;
import com.wanted.ecommerce.infrastructure.repository.entity.ProductDetailEntity;
import com.wanted.ecommerce.infrastructure.repository.entity.ProductEntity;
import com.wanted.ecommerce.infrastructure.repository.entity.SellerEntity;
import com.wanted.ecommerce.presentation.dto.response.ProductResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final BrandRepository brandRepository;
    private final ProductDetailRepository productDetailRepository;

    /**
     * 상품 등록
     *
     * @param userId
     * @param productRequest
     * @return
     */
    @Transactional
    public Product createProduct(Long userId, Product productRequest) {
        SellerEntity sellerEntity = sellerRepository.findById(productRequest.getSellerId()).orElseThrow(() ->
                                                                                                            new IllegalArgumentException(
                                                                                                                "판매자가 존재하지 않습니다."));
        BrandEntity brandEntity = brandRepository.findById(productRequest.getBrandId()).orElseThrow(() ->
                                                                                                        new IllegalArgumentException(
                                                                                                            "브랜드가 존재하지 않습니다."));

        ProductEntity productEntity = ProductEntity.of(productRequest, sellerEntity, brandEntity);
        productRepository.save(productEntity);

        List<ProductDetailEntity> detailList = productRequest.getDetails().stream()
            .map(dto -> ProductDetailEntity.builder().materials(dto.getMaterials())
                .dimensions(dto.getDimensions().toDto())
                .weight(dto.getWeight())
                .additionalInfo(dto.getAdditionalInfo())
                .countryOfOrigin(dto.getCountryOfOrigin())
                .build())
            .toList();

        productDetailRepository.saveAll(detailList);

        return productRequest;
    }

    /**
     * 상품 조회
     *
     * @param userId
     * @param productId
     * @return
     */
    public ProductResponse getProduct(Long userId, Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(() ->
                                                                                            new ProductNotFoundException("상품이 존재하지 않습니다."));
        Product domain = productEntity.toDomain();

        return ProductResponse.from(domain);
    }

}
