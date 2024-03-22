package com.example.testing_mybatis.provider;

import com.example.testing_mybatis.Dto.UserPostDto;
import com.example.testing_mybatis.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User fromUserPostDto(UserPostDto userPostDto);
}
