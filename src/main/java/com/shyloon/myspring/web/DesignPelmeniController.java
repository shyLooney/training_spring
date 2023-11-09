package com.shyloon.myspring.web;

import com.shyloon.myspring.Ingredient;
import com.shyloon.myspring.Pelmeni;
import com.shyloon.myspring.PelmeniOrder;
import com.shyloon.myspring.data.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pelmeniOrder")
public class DesignPelmeniController {
    private final IngredientRepository ingredientRepos;

    public DesignPelmeniController(IngredientRepository ingredientRepos) {
        this.ingredientRepos = ingredientRepos;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Ingredient.Type[] types = Ingredient.Type.values();
        var ingredientList = ingredientRepos.findAll();
        for (var type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredientList, type));
        }
    }

    @ModelAttribute(name = "pelmeniOrder")
    public PelmeniOrder order() {
        return new PelmeniOrder();
    }

    @ModelAttribute(name = "pelmeni")
    public Pelmeni pelmeni() {
        return new Pelmeni();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processPelmeni(@Valid Pelmeni pelmeni, Errors errors,
                                 @ModelAttribute PelmeniOrder pelmeniOrder) {
        if (errors.hasErrors())
            return "design";

        pelmeniOrder.addPelmeni(pelmeni);
        log.info("Processing pelmeni: {}", pelmeni);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> ingredients, Ingredient.Type type) {
        var in = new ArrayList<Ingredient>();
        for (var item : ingredients) {
            if (item.getType().equals(type))
                in.add(item);
        }
        return in;
    }
}
