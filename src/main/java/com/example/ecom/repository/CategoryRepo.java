package com.example.ecom.repository;

import com.example.ecom.dto.cart.CartDto;
import com.example.ecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    //Category findByCategoryName(String categoryName);
}
