package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Blood;


public interface StockRepository extends JpaRepository<Blood, Long>{

}
