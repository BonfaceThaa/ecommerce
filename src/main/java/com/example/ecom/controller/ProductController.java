package com.example.ecom.controller;

import com.example.ecom.common.ApiResponse;
import com.example.ecom.dto.ProductDto;
import com.example.ecom.model.Category;
import com.example.ecom.repository.CategoryRepo;
import com.example.ecom.service.CategoryService;
import com.example.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
        }
        Category category = optionalCategory.get();
        productService.createProduct(productDto, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(productDto, productId);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }
}
//}
