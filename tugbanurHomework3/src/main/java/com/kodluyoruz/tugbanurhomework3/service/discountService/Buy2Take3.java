package com.kodluyoruz.tugbanurhomework3.service.discountService;

import com.kodluyoruz.tugbanurhomework3.model.Cart;
import com.kodluyoruz.tugbanurhomework3.model.CartItem;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@RequiredArgsConstructor
public class Buy2Take3Discount implements Discount {

    private final DiscountProperties discountProperties;
    List<Double> buy2take3list = new ArrayList<>();
    @Override
    public double appylyDiscount(CartItem cartItem) {
        int discountQuantity = cartItem.getQuantity()/3;
        double paidQuantity = cartItem.getQuantity() - discountQuantity;
        return paidQuantity * cartItem.getProduct().getPrice();
    }

    @Override
    public boolean isOkey(Cart cart) {
        boolean flag = true;
        if(cart.getCartItemList().get(0).getQuantity()<5){
            flag = false;
        }
        return flag;
    }
}