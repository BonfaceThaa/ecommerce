package com.example.ecom.service;

import com.example.ecom.dto.order.CheckoutItemDTO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Value("$BASE_URL")
    private String baseURL;

    @Value("$SRIPE_SECRET_KEY")
    private String apiKey;

//    public Session createSession(List<CheckoutItemDTO> checkoutItemDTOList) {
//        // pages in the front-end
//        String succesURL = baseURL + "payment/success";
//        String failURL = baseURL + "payment/failed";
//
//        Stripe.apiKey = apiKey;
//
//        List<SessionCreateParams.LineItem> sessionItemList = new ArrayList<>();
//
//        for (CheckoutItemDTO checkoutItemDTO: checkoutItemDTOList) {
//            sessionItemList.add(createSessionLineItem(checkoutItemDTO));
//        }
//
//        SesssionCreateParams params = SessionCreateParams.builder()
//                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
//                .setMode(SesionCreateParams.Mode.PAYMENT)
//                .setCanceUrl(failURL)
//                .setSuccessUrl(succesURL)
//                .addAllLineItem(sessionItemList)
//                .build();
//
//        return Session.create(params);
//    }
//
//    private SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDTO checkoutItemDTO) {
//        return SessionCreateParams.LineItem.builder()
//                .setPriceData(createPriceData(checkoutItemDTO))
//                .setQuantity(Long.parseLong(String.valueOf(checkoutItemDTO.getQuantity())))
//                .build();
//    }
//
//    private SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDTO checkoutItemDTO) {
//        return SessionCreateParams.LineItem.PriceData.builder()
//                .setCurrency("usd")
//                .setUnitAmount((long)checkoutItemDTO.getPrice()*100)
//                .setProductData(
//                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
//                                .setName(checkoutItemDTO.getProductName()
//                                .build())
//                ).build();
//    }
}
