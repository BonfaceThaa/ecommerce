package com.example.ecom.repository;

import com.example.ecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    //Category findByCategoryName(String categoryName);
}
