package com.example.testing_mybatis.provider;


import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String buildInsertSql(){
        return new SQL() {{
            INSERT_INTO("user_db");
//            VALUES("userId","#{user_db.userid}");
            VALUES("name","#{user_db.name}");
            VALUES("gender","#{user_db.gender}");
            VALUES("email", "#{user_db.email}");
            VALUES("password","#{user_db.password}");
        }}.toString();
    }

}
