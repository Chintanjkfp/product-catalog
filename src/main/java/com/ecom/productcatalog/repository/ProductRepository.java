package com.ecom.productcatalog.repository;

import com.ecom.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
