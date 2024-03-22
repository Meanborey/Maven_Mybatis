package com.example.testing_mybatis.service;

import com.example.testing_mybatis.model.entity.Account;
import com.example.testing_mybatis.model.request.RequestEntities;

import java.util.List;

public interface AccountService {

    List<Account>findAllAccounts();

    Account getAccountById(long id);

    int AddNewAccount(RequestEntities requestEntities);

    boolean deleteById(long Id);

    int updateAccount(RequestEntities requestEntities, long Id);

}
