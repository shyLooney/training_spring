package com.shyloon.myspring;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@UserDefinedType("pelmeni")
public class PelmeniUDT {
    private final String name;
    private final List<IngredientUDT> ingredients;
}
