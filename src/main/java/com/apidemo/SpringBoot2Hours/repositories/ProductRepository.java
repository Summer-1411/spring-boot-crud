package com.apidemo.SpringBoot2Hours.repositories;

import com.apidemo.SpringBoot2Hours.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
