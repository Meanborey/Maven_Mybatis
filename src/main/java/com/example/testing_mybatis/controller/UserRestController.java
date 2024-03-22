package com.example.testing_mybatis.controller;

import com.example.testing_mybatis.Dto.UserPostDto;
import com.example.testing_mybatis.base.BaseRest;
import com.example.testing_mybatis.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
}
