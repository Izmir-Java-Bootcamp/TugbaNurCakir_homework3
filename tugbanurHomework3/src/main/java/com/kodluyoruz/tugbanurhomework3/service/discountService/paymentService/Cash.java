package com.kodluyoruz.tugbanurhomework3.service.discountService.paymentService;

import com.kodluyoruz.tugbanurhomework3.model.Category.Checkout.Bill;
import com.kodluyoruz.tugbanurhomework3.model.Category.Enums.Pay;
import org.springframework.stereotype.Component;

@Component
public class Cash implements Payment{
    @Override
    public Pay getType() {
        return Pay.CASH;
    }

    @Override
    public void payBill(Bill bill) {
        System.out.println("Payment amount is: " + bill.getTotalPrice());
    }
}