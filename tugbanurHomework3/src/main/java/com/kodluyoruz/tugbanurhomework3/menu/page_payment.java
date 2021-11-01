package com.kodluyoruz.tugbanurhomework3.menu;

import com.kodluyoruz.tugbanurhomework3.model.Category.Checkout.Bill;
import com.kodluyoruz.tugbanurhomework3.model.Category.Enums.Pay;
import com.kodluyoruz.tugbanurhomework3.service.discountService.paymentService.Payment;
import com.kodluyoruz.tugbanurhomework3.service.discountService.paymentService.PaymentFactory;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Data
@Component
public class page_payment {
    private final Scanner scanner;
    private final PaymentFactory paymentFactory;

    public void doPayment(Bill bill){
        System.out.println("What is your payment type if it is cash enter 1 - if it is credit cart enter 2 : ");
        int select = scanner.nextInt();

        if(select == 1){
            Payment payment = paymentFactory.getPaymentMethod(Pay.CASH);
            payment.payBill(bill);
        }else{
            Payment payment = paymentFactory.getPaymentMethod(Pay.CREDİT_CARD);
            payment.payBill(bill);
        }


    }
}
