package com.kodluyoruz.tugbanurhomework3.model.Category.Checkout;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BillItem {
    private String productName;
    private double price;
    private double discountedPrice;
    private int quantity;
    private String desc;
}