package com.kodluyoruz.tugbanurhomework3.service.discountService.paymentService;


public interface Payment {
    Pay getType();
    void payBill(Bill bill);

}