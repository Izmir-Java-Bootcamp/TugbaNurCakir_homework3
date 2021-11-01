package com.kodluyoruz.tugbanurhomework3;

import com.kodluyoruz.tugbanurhomework3.menu.pageMenu;
import com.kodluyoruz.tugbanurhomework3.menu.page_Searching;
import com.kodluyoruz.tugbanurhomework3.model.Category.Enums.Page;
import com.kodluyoruz.tugbanurhomework3.model.Category.MainCategory;
import com.kodluyoruz.tugbanurhomework3.model.Category.Products;
import com.kodluyoruz.tugbanurhomework3.model.Category.SubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class RunProjectTest implements CommandLineRunner {
    private final Scanner scanner;
    private final pageMenu pageMenu;
    private final page_Searching pageSearch;



    @Override
    public void run(String... args) throws Exception {

        System.out.println("Welcome to KODLUYORUZ SHOP!");

        Products item = Products.builder()
                .name("Apple")
                .price(3)
                .desc("description")
                .build();
        Products item2 = Products.builder()
                .name("Pear")
                .price(4)
                .desc("description")
                .build();
        Products item3 = Products.builder()
                .name("Grape")
                .price(5)
                .desc("description")
                .build();

        SubCategory sub = new SubCategory("Fruit and Veggies","Fruit");
        sub.addProduct(item);
        sub.addProduct(item2);
        sub.addProduct(item3);

        Products item4 = Products.builder()
                .name("Tomato")
                .price(10)
                .desc("description")
                .build();
        Products item5 = Products.builder()
                .name("Pepper")
                .price(12)
                .desc("description")
                .build();
        Products item6 = Products.builder()
                .name("Eggplant")
                .price(14)
                .desc("description")
                .build();

        SubCategory sub2 = new SubCategory("Fruit and Veggies","Vegetables");
        sub2.addProduct(item4);
        sub2.addProduct(item5);
        sub2.addProduct(item6);

        MainCategory mc = new MainCategory("Fruit and Veggies");
        mc.addSubCategory(sub);
        mc.addSubCategory(sub2);

        Products item7 = Products.builder()
                .name("Lays")
                .price(5)
                .desc("description")
                .build();
        Products item8 = Products.builder()
                .name("Doritos")
                .price(7)
                .desc("description")
                .build();
        Products item9 = Products.builder()
                .name("Ruffles")
                .price(9)
                .desc("description")
                .build();

        SubCategory sub3 = new SubCategory("Snack","Chips");
        sub3.addProduct(item7);
        sub3.addProduct(item8);
        sub3.addProduct(item9);


        Products item10 = Products.builder()
                .name("Tadelle")
                .price(15)
                .desc("description")
                .build();
        Products item11 = Products.builder()
                .name("Albeni")
                .price(18)
                .desc("description")
                .build();
        Products item12 = Products.builder()
                .name("Metro")
                .price(21)
                .desc("description")
                .build();
        Products item13 = Products.builder()
                .name("Hobby")
                .price(33)
                .desc("description")
                .build();

        SubCategory sub4 = new SubCategory("Snack","Chocolate");
        sub4.addProduct(item10);
        sub4.addProduct(item11);
        sub4.addProduct(item12);
        sub4.addProduct(item13);

        MainCategory mc2 = new MainCategory("Snack");
        mc2.addSubCategory(sub3);
        mc2.addSubCategory(sub4);

        Products item14 = Products.builder()
                .name("Full-Fat")
                .price(50)
                .desc("description")
                .build();
        Products item15 = Products.builder()
                .name("Low-Fat")
                .price(45)
                .desc("description")
                .build();
        Products item16 = Products.builder()
                .name("Lacto-Free")
                .price(60)
                .desc("description")
                .build();

        SubCategory sub5 = new SubCategory("Breakfast","Milk");
        sub5.addProduct(item14);
        sub5.addProduct(item15);
        sub5.addProduct(item16);


        Products item17 = Products.builder()
                .name("Cheddar")
                .price(25)
                .desc("description")
                .build();
        Products item18 = Products.builder()
                .name("Cheese")
                .price(62)
                .desc("description")
                .build();
        Products item19 = Products.builder()
                .name("Salami")
                .price(88)
                .desc("description")
                .build();
        Products item20 = Products.builder()
                .name("Susage")
                .price(90)
                .desc("description")
                .build();
        Products item21 = Products.builder()
                .name("Olive")
                .price(100)
                .desc("description")
                .build();

        SubCategory sub6 = new SubCategory("Breakfast","Delicatessen");
        sub6.addProduct(item17);
        sub6.addProduct(item18);
        sub6.addProduct(item19);
        sub6.addProduct(item20);
        sub6.addProduct(item21);

        MainCategory mc3 = new MainCategory("Breakfast");
        mc2.addSubCategory(sub5);
        mc2.addSubCategory(sub6);

        Locale.Category category = new Locale.Category();
        category.addMainCategory(mc);
        category.addMainCategory(mc2);
        category.addMainCategory(mc3);


        System.out.print("Please select page  "+ Arrays.toString(Page.values())+" : ");
        String pageType= scanner.nextLine();

        if(pageType.equals("MENU")){
            pageMenu.mainRun(category);
        }else{
            pageSearch.search(category);
        }

    }
}
