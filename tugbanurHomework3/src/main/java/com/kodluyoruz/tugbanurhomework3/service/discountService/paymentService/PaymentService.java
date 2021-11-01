package com.kodluyoruz.tugbanurhomework3.service.discountService.paymentService;

import com.kodluyoruz.tugbanurhomework3.model.Category.Enums.Pay;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentFactory {
    private final Map<Pay, Payment> paymentMap;

    public PaymentFactory(List<Payment> payments) {
        this.paymentMap = payments.stream()
                .collect(Collectors.toMap(Payment::getType, payment -> payment));
    }

    public Payment getPaymentMethod(Pay type) {
        return paymentMap.get(type);
    }
}