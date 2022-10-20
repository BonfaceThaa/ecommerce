package com.example.ecom.service;

import com.example.ecom.model.WishList;
import com.example.ecom.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
    @Autowired
    WishListRepository wishListRepository;

    public void createWishList(WishList wishList) {
    }
}
