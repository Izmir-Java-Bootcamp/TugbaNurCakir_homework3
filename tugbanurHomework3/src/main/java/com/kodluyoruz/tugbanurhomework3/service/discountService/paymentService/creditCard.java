package com.kodluyoruz.tugbanurhomework3.service.discountService.paymentService;

import com.kodluyoruz.tugbanurhomework3.model.Category.Checkout.Bill;
import com.kodluyoruz.tugbanurhomework3.model.Category.Enums.Pay;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "discount")
@Component
@Data
public class CreditCard implements Payment{
    private double creditCartCommission;
    @Override
    public Pay getType() {
        return Pay.CREDİT_CARD;
    }

    @Override
    public void payBill(Bill bill) {
        double commission = bill.getTotalPrice() * (creditCartCommission / 100);
        double totalAmount = bill.getTotalPrice() + commission;
        System.out.println("Payment amount is: " + totalAmount);
    }
}