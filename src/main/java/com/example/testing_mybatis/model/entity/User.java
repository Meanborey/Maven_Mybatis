package com.example.testing_mybatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private long userId;
    private String name;
    private String gender;
    private String email;
    private int password;
}
