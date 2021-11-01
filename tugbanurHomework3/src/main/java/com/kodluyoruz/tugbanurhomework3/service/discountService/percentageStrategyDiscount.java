package com.kodluyoruz.tugbanurhomework3.service.discountService;

import com.kodluyoruz.tugbanurhomework3.model.Cart;
import com.kodluyoruz.tugbanurhomework3.model.CartItem;
import com.kodluyoruz.tugbanurhomework3.service.discountService.Discount;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class PercentageDiscount implements Discount {

    private final double discountAmount;
    private final DiscountProperties discountProperties;

    public double  getDiscountPercentage() {
        return discountAmount / 100;
    }

    @Override
    public double appylyDiscount(CartItem cartItem) {

        double price = cartItem.getProduct().getPrice() * cartItem.getQuantity();
        double appliedDiscount = price * getDiscountPercentage();
        return price - appliedDiscount;

    }

    @Override
    public boolean isOkey(Cart cart) {
        boolean flag = true;

        if(cart.getTotalPrice()<1000){
            flag = false;
        }
        return flag;
    }
}