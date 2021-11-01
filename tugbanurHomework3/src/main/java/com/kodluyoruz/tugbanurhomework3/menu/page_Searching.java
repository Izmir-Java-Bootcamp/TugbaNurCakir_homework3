package com.kodluyoruz.tugbanurhomework3.menu;

import com.kodluyoruz.tugbanurhomework3.model.Cart;
import com.kodluyoruz.tugbanurhomework3.model.Category.Checkout.Bill;
import com.kodluyoruz.tugbanurhomework3.model.Category.MainCategory;
import com.kodluyoruz.tugbanurhomework3.model.Category.Products;
import com.kodluyoruz.tugbanurhomework3.model.Category.SubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class page_Searching {
    private Products products = null;
    private Bill bill;
    private final Cart cart;
    private final pageMenu pageMenu;
    private final page_checkout pageCheckout;
    private final Scanner scanner;

    public void search(Locale.Category category){
        int count = 0;
        while (count == 0){
            System.out.println("What do you want to search: ");
            String search = scanner.nextLine();

            List<Products> productsList = new ArrayList<>();
            List<MainCategory> mainCategories = category.getListOfMainCat().stream()
                    .filter(mainCategory -> mainCategory.toString().contains(search))
                    .collect(Collectors.toList());

            for (MainCategory mainCategory : mainCategories){
                for (SubCategory subCategory : mainCategory.getListOfSubcat()){
                    for (Products products : subCategory.getListOfProducts()){
                        if(products.getName().contains(search)){
                            count++;
                            productsList.add(products);
                        }
                    }
                }
            }

            if(count > 0){
                System.out.println("Product: ");
                String product = scanner.nextLine();

                for (int i = 0; i < productsList.size(); i++){
                    if (product.equals(productsList.get(i))){
                        System.out.println("Product Description: " + productsList.get(i).getDesc());
                        products = productsList.get(i);
                    }
                }
                if (products != null){
                    System.out.println("How many products do you want to buy?");
                    int quantity = scanner.nextInt();

                    CartItem cartItem = CartItem.builder()
                            .product(products)
                            .quantity(quantity)
                            .build();
                    cart.addItem(cartItem);

                    System.out.println("If you want to go Main Menu enter 1, if you want to go Payment Page enter 2: ");
                    int select = scanner.nextInt();

                    if(select == 1){
                        pageMenu.mainRun(category);

                    }else{
                        pageCheckout.checkout(category, cart);
                    }
                }
            }
        }
    }

}
