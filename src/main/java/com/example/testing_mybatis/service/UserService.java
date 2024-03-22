package com.example.testing_mybatis.service;

import com.example.testing_mybatis.Dto.UserPostDto;
import com.example.testing_mybatis.model.entity.User;

import java.util.List;

public interface UserService {

    int insertNewUser(UserPostDto userPostDto);

    List<User>findAllUsers();
}
