package com.example.testing_mybatis.controller;

import com.example.testing_mybatis.Dto.UserPostDto;
import com.example.testing_mybatis.base.BaseRest;
import com.example.testing_mybatis.model.entity.User;
import com.example.testing_mybatis.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public BaseRest<?> insetNewUser(@Validated @RequestBody UserPostDto userPostDto){
        var user = userService.insertNewUser(userPostDto);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User Post complete>>>>>>")
                .timestamp(LocalDateTime.now())
                .data(user)
                .build();
    }

    @GetMapping("/all")
    public BaseRest<List<User>>findAllUsers(){
        var user = userService.findAllUsers();
        return BaseRest.<List<User>>builder()
                .message("Get All User Success ???????")
                .status(true)
                .code(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .data(user)
                .build();
    }
}
