package com.kodluyoruz.tugbanurhomework3.model;


import com.kodluyoruz.tugbanurhomework3.model.Category.Products;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
class CartItem {
    private Products product;
    private int quantity;

    public double getPrice(){
        return product.getPrice() * quantity;
    }

}