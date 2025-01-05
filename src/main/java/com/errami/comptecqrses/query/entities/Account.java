package com.errami.comptecqrses.query.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.errami.comptecqrses.commonApi.enums.AccountStatus;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Entity @Builder
public class Account {
    @Id
    private String id;
    private double balance;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @OneToMany(mappedBy = "account")
    private Collection<Operation> operations;
}