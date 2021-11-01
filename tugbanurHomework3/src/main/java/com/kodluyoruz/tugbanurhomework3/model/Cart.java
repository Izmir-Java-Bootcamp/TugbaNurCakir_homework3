package com.kodluyoruz.tugbanurhomework3.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<CartItem> cartItemList;

    public Cart() {
        this.cartItemList = new ArrayList<>();
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void addItem(CartItem cartItem){
        cartItemList.add(cartItem);
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (CartItem cartItem :
                cartItemList) {
            totalPrice+= cartItem.getQuantity()*cartItem.getProduct().getPrice();
        }
        return totalPrice;
    }
}