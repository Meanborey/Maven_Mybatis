package com.example.testing_mybatis.service.Imlp;
import com.example.testing_mybatis.model.entity.Account;
import com.example.testing_mybatis.model.request.RequestEntities;
import com.example.testing_mybatis.repository.AccountRepository;
import com.example.testing_mybatis.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> findAllAccounts() {

        return accountRepository.findAllAccounts();
    }
    @Override
    public Account getAccountById(long Id) {
        return accountRepository.getAccountById(Id);
    }
    @Override
    public int AddNewAccount(RequestEntities requestEntities) {
            int accountId = accountRepository.addNewAccount(requestEntities);
        return accountId;
    }
    @Override
    public boolean deleteById(long Id) {
        return accountRepository.deleteById(Id);
    }
    @Override
    public int updateAccount(RequestEntities requestEntities, long Id) {

        return accountRepository.updateAccount(requestEntities, Id);
    }
}
