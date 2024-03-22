package com.example.testing_mybatis.controller;

import com.example.testing_mybatis.model.entity.Account;
import com.example.testing_mybatis.model.request.RequestEntities;
import com.example.testing_mybatis.model.response.ResponseEntites;
import com.example.testing_mybatis.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountRestController {
    private final AccountService accountService;
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("all")
    public ResponseEntity<ResponseEntites< List<Account>>>getAllAccounts(){
        ResponseEntites<List<Account>>responseEntites = ResponseEntites.<List<Account>>builder()
                .message("Process successfully!!!!!!")
                .payload(accountService.findAllAccounts())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    return ResponseEntity.ok(responseEntites) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntites<Account>>getAccountById(@PathVariable("id") long Id){
        ResponseEntites<Account> responseEntites= null;
        if(accountService.getAccountById(Id) !=null){
            responseEntites = ResponseEntites.<Account>builder()
                    .message("Process successfully!!!!!!")
                    .payload(accountService.getAccountById(Id))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responseEntites);
        }else{
            responseEntites = ResponseEntites.<Account>builder()
                    .message("NOT FOND!!!!")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.badRequest().body(responseEntites);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseEntites<String>>deleteById(@PathVariable ("id") long Id){
        ResponseEntites<String> responseEntites= null;

        if (accountService.deleteById(Id)==true){
            responseEntites = ResponseEntites.<String>builder()
                    .message("Delete Success........")
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
        }
        return ResponseEntity.ok(responseEntites);
    }
    @PostMapping // Ensure you have a specific mapping for your endpoint
    public ResponseEntity<ResponseEntites<Account>> addNewAccount(@RequestBody RequestEntities requestEntities) {
        int storeId = accountService.AddNewAccount(requestEntities);
        if (storeId > 0) {
            ResponseEntites<Account> responseEntities = ResponseEntites.<Account>builder()
                    .message("Post successfully!")
                    .payload(accountService.getAccountById(storeId))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responseEntities);
        } else {
            // Consider using a more specific status code for different error scenarios
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseEntites<Account>> updateAccount(@RequestBody RequestEntities requestEntities, @PathVariable("id") long Id) {
        int rowsUpdated = accountService.updateAccount(requestEntities, Id);
        if (rowsUpdated > 0) {
            ResponseEntites<Account>responseEntites = ResponseEntites.<Account>builder()
                    .message("Update Successful👌👌👌👌👌👌👌👌")
                    .payload(accountService.getAccountById(rowsUpdated))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responseEntites);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
