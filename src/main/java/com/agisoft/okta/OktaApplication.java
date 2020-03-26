package com.agisoft.okta;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@SpringBootApplication
@Configuration
public class OktaApplication {

    @Bean
    public ApplicationRunner init(FoodService foodService) {
        return args -> {
            Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
                Food food = new Food();
                food.setName(name);
                foodService.saveFood(food);
            });
            foodService.getFoods().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(OktaApplication.class, args);
    }

}
