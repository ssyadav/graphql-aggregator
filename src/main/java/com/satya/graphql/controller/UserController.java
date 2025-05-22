package com.satya.graphql.controller;

import com.satya.graphql.dto.UserDto;
import com.satya.graphql.facade.UserFacade;
import com.satya.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired private UserService userService;
    @Autowired private UserFacade userFacade;

    @QueryMapping
    public Flux<Map<String, Object>> getUsers(@Argument List<String> fields) {
        return this.userFacade.getUser(fields);
    }

    @QueryMapping
    private Flux<UserDto> users() {
        return this.userService.allUsers();
    }

  /*  1. graphql controller will return json
    2. controller will recieve the json form facade layer
    3. facade layer will intract with service which will get the data form database or external service
*/
    public UserService getUserService() {
        return userService;
    }

    @QueryMapping
    private Mono<UserDto> userById(@Argument Integer id) {
        return this.userService.userById(id);
    }

    @QueryMapping
    private Mono<UserDto> userByEmail(@Argument String email) {
        return this.userService.userByEmail(email);
    }

    @MutationMapping
    private Mono<UserDto> createUser(@Argument UserDto user) {
        return this.userService.createUser(user);
    }

    @MutationMapping
    private Mono<UserDto> updateUser(
            @Argument Integer id, @Argument("user") UserDto dto) {
        return this.userService.updateUser(id, dto);
    }
}
