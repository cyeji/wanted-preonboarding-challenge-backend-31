package com.wanted.ecommerce.infrastructure.repository;

import com.wanted.ecommerce.infrastructure.repository.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, Long> {

}
