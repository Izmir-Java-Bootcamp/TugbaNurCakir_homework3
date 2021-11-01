package com.kodluyoruz.tugbanurhomework3.service.discountService;

import com.kodluyoruz.tugbanurhomework3.model.Cart;
import com.kodluyoruz.tugbanurhomework3.model.CartItem;

public interface Discount {
    double appylyDiscount(CartItem cartItem);
    boolean isOkey(Cart cart);
}