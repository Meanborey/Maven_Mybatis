package com.example.testing_mybatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    private long Id;
    private String AccountNumber;
    private String Name;
    private String BillingCity;
    private String BillingCountry;

}
