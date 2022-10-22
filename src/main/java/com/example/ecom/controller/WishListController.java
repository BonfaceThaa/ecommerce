package com.example.ecom.controller;

import com.example.ecom.common.ApiResponse;
import com.example.ecom.dto.ProductDto;
import com.example.ecom.model.Product;
import com.example.ecom.model.User;
import com.example.ecom.model.WishList;
import com.example.ecom.service.AuthenticationService;
import com.example.ecom.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addWishList(@RequestBody Product product, @RequestParam("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);

        WishList wishList = new WishList(product, user);
        wishListService.createWishList(wishList);

        ApiResponse apiResponse = new ApiResponse(true, "Added to wishlist");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

    }

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@RequestParam("token") String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);

        List<ProductDto> productDtos = wishListService.getWishList(user);

        return new ResponseEntity<>(productDtos, HttpStatus.OK);

    }

}
