package com.satya.graphql.dto;

import lombok.Data;

@Data
public class WatchListInput {

    private Integer customerId;
    private Integer movieId;

}