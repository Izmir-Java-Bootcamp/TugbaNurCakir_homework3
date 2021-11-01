package com.kodluyoruz.tugbanurhomework3.model.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Data

public class Products {
    private final String name;
    private final String desc;
    private double price;

}