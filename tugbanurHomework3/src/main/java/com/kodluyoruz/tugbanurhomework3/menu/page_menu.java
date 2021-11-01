package com.kodluyoruz.tugbanurhomework3.menu;

import com.kodluyoruz.tugbanurhomework3.model.Cart;
import com.kodluyoruz.tugbanurhomework3.model.CartItem;
import com.kodluyoruz.tugbanurhomework3.model.Category.Category;
import com.kodluyoruz.tugbanurhomework3.model.Category.MainCategory;
import com.kodluyoruz.tugbanurhomework3.model.Category.Products;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Data
@Component
@RequiredArgsConstructor
public class pageMenu {

    private Products product;
    private final Cart cart;
    private final Scanner scanner;
    private final page_checkout pageCheckout;
    private final page_payment pagePayment;
    private page_Searching pageSearch;

    public void mainRun(Category category){

        int loop = 1;

        while(loop == 1){

            List<MainCategory> mainCategoryList = category.getListOfMainCat();
            for (int i = 0; i < mainCategoryList.size(); i++){
                System.out.println("Main Categories: " + mainCategoryList.get(i).getMainCatName());
            }

            System.out.println("What category do you want to choose: ");
            String select = scanner.nextLine();

            for (int j = 0; j < mainCategoryList.size(); j++){
                if (mainCategoryList.get(j).getMainCatName().equals(select)){
                    for (int k = 0; k < mainCategoryList.get(k).getListOfSubcat().size(); k++){
                        System.out.println("Subcategory name: " + mainCategoryList.get(k).getListOfSubcat().get(k).getSubCatName());
                    }
                }
            }

            System.out.println("What subcategory do you want to choose: ");
            String select2 = scanner.nextLine();

            for (int i = 0; i < mainCategoryList.size(); i++){
                //int count = 0;
                if (mainCategoryList.get(i).getMainCatName().equals(category)){
                    for (int k = 0; k < mainCategoryList.get(k).getListOfSubcat().size(); k++){
                        String subCatName = mainCategoryList.get(k).getListOfSubcat().get(k).getSubCatName();
                        if (subCatName.equals(select2)){
                            for (int j = 0; j < mainCategoryList.get(j).getListOfSubcat().get(j).getListOfProducts().size(); j++){
                                System.out.println("Products name: " + mainCategoryList.get(j).getListOfSubcat().get(j).getListOfProducts().get(j).getName());
                            }
                        }
                    }
                }
            }


            System.out.println("What product do you want to choose: ");
            String select3 = scanner.nextLine();

            for (int i = 0; i < mainCategoryList.size(); i++){
                if (mainCategoryList.get(i).getMainCatName().equals(category)){
                    for (int k = 0; k < mainCategoryList.get(k).getListOfSubcat().size(); k++){
                        String subCatName = mainCategoryList.get(k).getListOfSubcat().get(k).getSubCatName();
                        if (subCatName.equals(select3)){
                            System.out.println("Description: " + mainCategoryList.get(k).getListOfSubcat().get(k).getListOfProducts().get(k).getDesc());
                        }
                    }
                }
            }

            System.out.print("How many products do you want to buy? ");
            int quantity = scanner.nextInt();

            CartItem cartItem=CartItem.builder()
                    .product(product)
                    .quantity(quantity)
                    .build();
            cart.addItem(cartItem);


        }
        if(loop == 0){
            pageCheckout.checkout(category,cart);
        }
    }



}