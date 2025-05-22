package com.satya.graphql.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.satya.graphql.dto.UserDto;
import com.satya.graphql.repository.UserRepository;
import com.satya.graphql.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  @Autowired private ObjectMapper objectMapper;

  public Flux<UserDto> allUsers() {
    return userRepository
        .findAll()
        .map(EntityDtoUtil::toDto)
        .doOnError(e -> System.out.println("Error fetching users: {}" + e.getMessage()));
  }

  public Mono<UserDto> userById(Integer id) {
    return userRepository
        .findById(id)
        .map(EntityDtoUtil::toDto)
        .doOnError(e -> System.out.println("Error fetching user based on Id: {}" + e.getMessage()));
  }

  public Mono<UserDto> userByEmail(String email) {
    return userRepository
        .findByEmail(email)
        .map(EntityDtoUtil::toDto)
        .doOnError(e -> System.out.println("Error fetching user by email: {}" + e.getMessage()));
  }

  public Mono<UserDto> createUser(UserDto userDto) {
    return Mono.just(userDto)
        .map(EntityDtoUtil::toEntity)
        .flatMap(this.userRepository::save)
        .map(EntityDtoUtil::toDto);
  }

  public Mono<UserDto> updateUser(Integer id, UserDto userDto) {
    return Mono.just(userDto)
        .map(usr -> EntityDtoUtil.toEntity(id, usr))
        .flatMap(this.userRepository::save)
        .map(EntityDtoUtil::toDto);
  }

  public Flux<Map<String, Object>> getUserAsJson() {
    return this.userRepository.findAll()
            .map(user -> objectMapper.convertValue(user, new TypeReference<Map<String, Object>>() {}));
  }
}
