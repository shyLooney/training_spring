package com.shyloon.myspring.data;

import com.shyloon.myspring.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
