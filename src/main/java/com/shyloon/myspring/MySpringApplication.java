package com.shyloon.myspring;

import com.shyloon.myspring.data.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringApplication {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repository) {
        return args -> {
            repository.save(new Ingredient("CHICKEN", "Chicken", Ingredient.Type.MEAT));
            repository.save(new Ingredient("BEEF", "Ground Beef", Ingredient.Type.MEAT));
            repository.save(new Ingredient("PORK", "Pork", Ingredient.Type.MEAT));
            repository.save(new Ingredient("SALT", "Salt", Ingredient.Type.SPICE));
            repository.save(new Ingredient("ONION", "Red onion", Ingredient.Type.SPICE));
            repository.save(new Ingredient("PEPPER", "Black pepper", Ingredient.Type.SPICE));
            repository.save(new Ingredient("DOUGH", "Dough", Ingredient.Type.DOUGH));
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(MySpringApplication.class, args);
        System.out.println("Hello world!");
    }
}
