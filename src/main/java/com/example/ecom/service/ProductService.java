package com.example.ecom.service;

import com.example.ecom.common.ApiResponse;
import com.example.ecom.dto.ProductDto;
import com.example.ecom.model.Category;
import com.example.ecom.model.Product;
import com.example.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setCategory(category);
        productRepository.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageURL(product.getImageURL());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setId(product.getId());
        return productDto;
    }

    public List<ProductDto> getProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product: allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not found");
        }
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        productRepository.save(product);

    }
}
