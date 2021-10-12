package com.example.payment.service;

import com.example.payment.entity.Payment;
import com.example.payment.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements IPaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment makePayment(Payment payment) {
     payment.setPaymentStatus(new Random().nextBoolean()?"Transaction Success":"Transaction Failure");
     payment.setTransactionId(UUID.randomUUID().toString());
     Payment savedPayment=paymentRepository.save(payment);
        return savedPayment;
    }
}
