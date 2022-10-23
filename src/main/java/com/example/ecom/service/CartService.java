package com.example.ecom.service;

import com.example.ecom.dto.cart.AddToCartDto;
import com.example.ecom.dto.cart.CartDto;
import com.example.ecom.dto.cart.CartItemDto;
import com.example.ecom.exceptions.CustomException;
import com.example.ecom.exceptions.ProductNotExistException;
import com.example.ecom.model.Cart;
import com.example.ecom.model.Product;
import com.example.ecom.model.User;
import com.example.ecom.repository.CartRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    ProductService productService;

    @Autowired
    CartRespository cartRespository;

    public void addToCart(AddToCartDto addToCartDto, User user) throws ProductNotExistException {
        Product product = productService.findById(addToCartDto.getProductId());

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());

        cartRespository.save(cart);
    }

    public CartDto listCartItems(User user) {
        List<Cart> cartList = cartRespository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;

        for (Cart cart: cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            cartItems.add(cartItemDto);
            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
        }

        CartDto cartDto = new CartDto();
        cartDto.setCartItems(cartItems);
        cartDto.setTotalCost(totalCost);

        return cartDto;
    }

    public void deleteCartItem(Integer itemId, User user) {
        Optional<Cart> optionalCart = cartRespository.findById(itemId);

        if (optionalCart.isEmpty()) {
            throw new CustomException("cart item id is invalid " + itemId);
        }

        Cart cart = optionalCart.get();

        if (cart.getUser() != user) {
            throw new CustomException("cart item does not belong to user " + itemId);
        }

        cartRespository.delete(cart);
    }
}
