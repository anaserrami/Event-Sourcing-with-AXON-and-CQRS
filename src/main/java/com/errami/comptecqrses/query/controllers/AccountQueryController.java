package com.errami.comptecqrses.query.controllers;

import lombok.AllArgsConstructor;
import com.errami.comptecqrses.commonApi.queries.GetAllAccountsQuery;
import com.errami.comptecqrses.query.entities.Account;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/query/accounts")
public class AccountQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return queryGateway.query(new GetAllAccountsQuery(), ResponseTypes.multipleInstancesOf(Account.class)).join();
    }
}