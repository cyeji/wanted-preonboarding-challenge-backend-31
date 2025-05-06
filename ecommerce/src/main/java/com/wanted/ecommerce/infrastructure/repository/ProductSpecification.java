package com.wanted.ecommerce.infrastructure.repository;

import com.wanted.ecommerce.infrastructure.repository.entity.ProductEntity;
import com.wanted.ecommerce.presentation.enums.ProductStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class ProductEntitySpecification {


    public static Specification<ProductEntity> hasName(String name) {
        if (name == null) return null;
        return (root, query, cb) -> cb.equal(root.get("name"), name);
    }

    public static Specification<ProductEntity> minPrice(Double minPrice) {
        if (minPrice == 0) return null;
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<ProductEntity> maxPrice(Double maxPrice) {
        if (maxPrice == 0) return null;
        return (root, query, cb) -> cb.lessThan(root.get("price"), maxPrice);
    }

    public static Specification<ProductEntity> search(String search) {
        if (search == null || search.isEmpty()) return null;
        return (root, query, cb) -> cb.like(root.get("search"), search);
    }

    public static Specification<ProductEntity> inStock() {
        return (root, query, cb) -> cb.equal(root.get("inStock"), true);
    }

    public static Specification<ProductEntity> inNotStock() {
        return (root, query, cb) -> cb.equal(root.get("inStock"), false);
    }

    public static Specification<ProductEntity> seller(Long sellerId) {
        if (sellerId == null) return null;
        return (root, query, cb) -> cb.equal(root.get("seller").get("id"), sellerId);
    }


    public static Specification<ProductEntity> brand(Long brandId) {
        if (brandId == null) return null;
        return (root, query, cb) -> cb.equal(root.get("brand").get("id"), brandId);
    }

    public static Specification<ProductEntity> status(ProductStatus status) {
        if (status == null) return null;
        return (root, query, cb) -> cb.equal(root.get("status"), status);
    }

}
