package com.wanted.ecommerce.infrastructure.repository;

import com.wanted.ecommerce.infrastructure.repository.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

}
