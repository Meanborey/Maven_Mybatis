package com.example.testing_mybatis.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestEntities{

  private String accountNumber;

  private String name;

  private String billingCity;

  private String billingCountry;

}
