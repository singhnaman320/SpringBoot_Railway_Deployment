package com.springBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springBoot.entities.Product;

@Repository
public interface ProductJpaDao extends JpaRepository<Product, Integer>{

	public List<Product> findByCategory(String category);
}
