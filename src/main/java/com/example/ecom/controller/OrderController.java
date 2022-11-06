package com.example.ecom.controller;

import com.example.ecom.dto.order.CheckoutItemDTO;
import com.example.ecom.dto.order.StripeResponse;
import com.example.ecom.service.AuthenticationService;
import com.example.ecom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/add")
public class OrderController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private OrderService orderService;

//    @PostMapping("/create-checkout-session")
//    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDTO> checkoutItemDTOList) throws
//            StripeException {
//        Session session = orderService.createSession(checkoutItemDTOList);
//        StripeResponse stripeResponse = new StripeResponse(session.getId());
//        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);
//    }
}
