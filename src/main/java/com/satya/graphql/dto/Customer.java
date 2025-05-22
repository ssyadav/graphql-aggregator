package com.satya.graphql.dto;
import lombok.Data;

import java.util.List;

@Data
public class Customer {

    private Integer id;
    private String name;
    private Genre favoriteGenre;
    private List<Integer> watchList;

}