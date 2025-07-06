package com.paymentservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.client.BookingClient;
import com.paymentservice.dto.ProductRequest;
import com.paymentservice.dto.StripeResponse;
import com.paymentservice.service.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;


@RestController
@RequestMapping("/product/v1")
public class ProductCheckoutController {


    private StripeService stripeService;
    
    @Autowired
    private BookingClient bookingClient;

    public ProductCheckoutController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/checkout")
    public StripeResponse checkoutProducts(@RequestBody ProductRequest productRequest) {
        StripeResponse stripeResponse = stripeService.checkoutProducts(productRequest);
        return stripeResponse;
   
    }
    
    @GetMapping("/success")
    public String handleSuccess(@RequestParam("session_id") String sessionId, @RequestParam("booking_id") long id) {
        Stripe.apiKey = "sk_test_51RaEMrGasCNI73MIVMZgt9e6OfRP5iORI3H6RLFi8BRSbqbRTN0cIC7f5gvfT34Zc2eLuwrOqFRXXnMIQlmoCgUu009WdISAko"; // Replace with your actual secret key

        try {
            Session session = Session.retrieve(sessionId);
            String paymentStatus = session.getPaymentStatus();
            System.out.println(sessionId);

            if ("paid".equalsIgnoreCase(paymentStatus)) {
                System.out.println("✅ Payment successful: true");
                
                //DataBase Operation - To Updated Booking.
                boolean result = bookingClient.updateBooking(id);
                if(result) {
                	//send Email
                	
                }
                
                
                return "Payment successful";
            } else {
                System.out.println("❌ Payment not completed: false");
                return "Payment not completed";
            }

        } catch (StripeException e) {
            e.printStackTrace();
            return "Stripe error occurred";
        }
    }


    @GetMapping("/cancel")
    public String handleCancel() {
        System.out.println("❌ Payment cancelled: false");
        return "Payment cancelled";
    }
}