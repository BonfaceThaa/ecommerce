package com.example.ecom.controller;

import com.example.ecom.common.ApiResponse;
import com.example.ecom.model.Product;
import com.example.ecom.model.User;
import com.example.ecom.model.WishList;
import com.example.ecom.service.AuthenticationService;
import com.example.ecom.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;

    @Autowired
    AuthenticationService authenticationService;

    public ResponseEntity<ApiResponse> addWishList(@RequestBody Product product, @RequestParam("token") String token) {
        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        WishList wishList = new WishList(product, user);

        wishListService.createWishList(wishList);

    }
}
