package com.kodluyoruz.tugbanurhomework3.service.discountService;

import com.kodluyoruz.tugbanurhomework3.model.Cart;
import com.kodluyoruz.tugbanurhomework3.model.CartItem;
import com.kodluyoruz.tugbanurhomework3.service.discountService.Discount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@RequiredArgsConstructor
public class DiscountStrategy {

    private final List<Discount> discountList;
    private double totalprice = 0;

    public double executeDiscount(Cart cart){
        for(CartItem cartItem : cart.getCartItemList()){
            discountList.stream()
                    .filter(discount -> discount.isOkey(cart))
                    .findFirst()
                    .ifPresent(discount -> totalprice = discount.appylyDiscount(cartItem));

        }
        return totalprice;
    }
}