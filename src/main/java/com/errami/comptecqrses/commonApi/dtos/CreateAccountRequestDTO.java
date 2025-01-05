package com.errami.comptecqrses.commonApi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.errami.comptecqrses.commonApi.enums.AccountStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequestDTO {
    private double iniatialBalance;
    private String currency;
    private AccountStatus status;
}