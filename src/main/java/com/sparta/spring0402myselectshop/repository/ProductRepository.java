package com.sparta.spring0402myselectshop.repository;

import com.sparta.spring0402myselectshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
