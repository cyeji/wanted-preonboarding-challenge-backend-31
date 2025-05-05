package com.wanted.ecommerce.infrastructure.repository;

import com.wanted.ecommerce.infrastructure.repository.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {

}
