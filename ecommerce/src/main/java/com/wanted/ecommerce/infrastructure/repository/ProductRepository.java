package com.wanted.ecommerce.infrastructure.repository;

import com.wanted.ecommerce.infrastructure.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
