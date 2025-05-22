package com.satya.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
@Table("GX_USER")
public class User {
    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String status;
    private Integer age;
    private String city;
}
