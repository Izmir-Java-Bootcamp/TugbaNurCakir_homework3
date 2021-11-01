package com.kodluyoruz.tugbanurhomework3.model.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class MainCategory extends Category{
    private List<SubCategory> listOfSubcat = new ArrayList<>();
    private String mainCatName;

    public MainCategory(String mainCatName) {
        this.mainCatName = mainCatName;
    }

    public void addSubCategory(SubCategory sc){
        listOfSubcat.add(sc);
    }

}