package com.satya.graphql.controller;

import com.satya.graphql.client.ReviewClient;
import com.satya.graphql.dto.Movie;
import com.satya.graphql.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class ReviewController {

    @Autowired private ReviewClient client;

    @SchemaMapping(typeName = "MovieDetails")
    public Flux<Review> reviews(Movie movie){
        return this.client.reviews(movie.getId());
    }
}
