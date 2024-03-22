package com.example.testing_mybatis.repository;

import com.example.testing_mybatis.Dto.UserPostDto;
import com.example.testing_mybatis.model.entity.User;
import com.example.testing_mybatis.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserRepository {

    @InsertProvider(type = UserProvider.class, method = "buildInsertSql")
//    @Options(useGeneratedKeys = true, keyColumn = "useId", keyProperty = "id")
    @Results({
//            @Result(property = "userId", column = "userid"),
            @Result(property = "name", column = "name"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password")
    })
    int insetNewUser(@Param("user_db")User user);
    @Select("SELECT * FROM user_db")
    List<User>findAllUses();

}
