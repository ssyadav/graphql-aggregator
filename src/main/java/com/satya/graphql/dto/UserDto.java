package com.satya.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class UserDto {
  private Integer id;
  private String firstname;
  private String lastname;
  private String email;
  private String phone;
  private String status;
  private Integer age;
  private String city;
}
