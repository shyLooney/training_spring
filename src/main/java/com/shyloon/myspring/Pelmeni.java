package com.shyloon.myspring;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pelmeni {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min = 5, message="Name must be at least 5 characters long")
    private String name;
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredientList = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
    }

}
