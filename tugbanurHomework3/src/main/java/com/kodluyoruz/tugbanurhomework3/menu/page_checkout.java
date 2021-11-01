package com.kodluyoruz.tugbanurhomework3.menu;

import com.kodluyoruz.tugbanurhomework3.model.Category.Checkout.Bill;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@Component
@Data
public class page_checkout {
    private Bill bill;
    private final Scanner scanner;
    private final CheckoutService checkoutService;

    private final pagePayment pagePayment;
    private pageMenu pageMenu;

    public void checkout(Locale.Category category, Cart cart){

        bill = checkoutService.checkoutService(cart);

        System.out.println("If you want to go Main Menu enter 1, if you want to go Payment Page enter 2: ");
        int select = scanner.nextInt();

        if(select == 1){

            pageMenu.mainRun(category);

        }else{
            pagePayment.doPayment(bill);
        }




    }
}
