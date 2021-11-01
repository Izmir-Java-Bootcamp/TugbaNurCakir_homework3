package com.kodluyoruz.tugbanurhomework3.configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
@Configuration
public class appConfiguration {
    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
