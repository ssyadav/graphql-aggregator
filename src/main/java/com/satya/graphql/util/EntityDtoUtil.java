package com.satya.graphql.util;

import com.satya.graphql.dto.UserDto;
import com.satya.graphql.entity.User;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

  public static UserDto toDto(User user) {
    UserDto dto = new UserDto();
    BeanUtils.copyProperties(user, dto);
    return dto;
  }

  public static User toEntity(UserDto dto) {
    User user = new User();
    BeanUtils.copyProperties(dto, user);
    return user;
  }

  public static User toEntity(Integer id, UserDto dto) {
    User user = new User();
    BeanUtils.copyProperties(dto, user);
    user.setId(id);
    return user;
  }
}
