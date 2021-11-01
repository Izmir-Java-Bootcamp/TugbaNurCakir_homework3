package com.kodluyoruz.tugbanurhomework3.model.Category.Checkout;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bill {
    private double totalPrice;
    private List<BillItem> billItems;
}