package com.shyloon.myspring;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("ingredients")
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Ingredient {
    @PrimaryKey
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        MEAT, DOUGH, SPICE
    }
}

