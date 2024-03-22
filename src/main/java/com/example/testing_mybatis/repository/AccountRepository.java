package com.example.testing_mybatis.repository;

import com.example.testing_mybatis.model.entity.Account;
import com.example.testing_mybatis.model.request.RequestEntities;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AccountRepository {

    @Select("SELECT * FROM account")
    List<Account>findAllAccounts();

@Update("UPDATE account " +
        "SET accountNumber = #{requestEntities.accountNumber}," +
        "name = #{requestEntities.name}, " +
        "billingCity = #{requestEntities.billingCity}, " +
        "billingCountry = #{requestEntities.billingCountry} " +
        "WHERE id = #{Id}")
int updateAccount(@Param("requestEntities") RequestEntities requestEntities, @Param("Id") long Id);

    @Select("SELECT * FROM account WHERE id = #{Id}")
    Account getAccountById(long Id);

    @Insert("INSERT INTO account (accountnumber, name, billingcity, billingcountry) " +
            "VALUES (#{accounts.accountNumber}, #{accounts.name}, #{accounts.billingCity}, #{accounts.billingCountry})")
    int addNewAccount(@Param("accounts") RequestEntities requestEntities);

    @Delete("DELETE FROM account WHERE id = #{id}")
    boolean deleteById(@Param("id") long Id);

}
