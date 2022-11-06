package com.example.ecom.service;

import com.example.ecom.dto.cart.CartDto;
import com.example.ecom.model.Category;
import com.example.ecom.repository.CategoryRepo;
import com.example.ecom.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public void createCategory (Category category) {
        categoryRepo.save(category);
    }

    public List<Category> listCategory(){
        return categoryRepo.findAll();
    }

    public Optional<Category> readCategory(Integer categoryId) {
        return categoryRepo.findById(categoryId);
    }

    public void editCategory(int categoryId, Category updateCategory) {
        Category category = categoryRepo.getById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
//        category.setImgURL(updateCategory.getImgURL());
        categoryRepo.save(category);
    }

    public boolean findById(int categoryId) {
        return categoryRepo.findById(categoryId).isPresent();
    }
}
