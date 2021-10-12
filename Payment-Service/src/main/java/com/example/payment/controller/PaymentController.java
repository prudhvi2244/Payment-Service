package com.example.payment.controller;

import com.example.payment.entity.Payment;
import com.example.payment.service.IPaymentService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;


    @GetMapping(value = "/testPayment")
    public String paymentTestPage()
    {
        String msg="<h2 style='color:green'>Payment Service Is Working!</h2>";
        return msg;
    }

    @PostMapping(value = "/makePayment")
    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment)
    {
        return new ResponseEntity<Payment>(paymentService.makePayment(payment), HttpStatus.CREATED);
    }
}
