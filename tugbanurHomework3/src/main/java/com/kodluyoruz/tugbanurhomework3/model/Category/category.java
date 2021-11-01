package com.kodluyoruz.tugbanurhomework3.model.Category;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
class Category {
    private List<MainCategory> listOfMainCat = new ArrayList<>();

    public void addMainCategory(MainCategory mc){

        listOfMainCat.add(mc);

    }
}