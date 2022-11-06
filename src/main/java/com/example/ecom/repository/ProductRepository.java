package com.example.ecom.repository;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductDto;
import com.example.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("""
    SELECT new com.example.ecom.dto.ProductDTO(p.name, p.description) FROM Product p
    """)
    List<ProductDTO> findProductDto();
    // Objects retrieved in this manner do not go to the JPA context which improves
    // performance however any updates on the objects do not reflect in the DB since the ORM has no control of the objects
}
