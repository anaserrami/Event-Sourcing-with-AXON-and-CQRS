package com.errami.comptecqrses.commands.controllers;

import lombok.AllArgsConstructor;
import com.errami.comptecqrses.commonApi.commands.CreateAccountCommand;
import com.errami.comptecqrses.commonApi.commands.CreditAccountCommand;
import com.errami.comptecqrses.commonApi.dtos.CreateAccountRequestDTO;
import com.errami.comptecqrses.commonApi.dtos.CreditAccountRequestDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commands/accounts")
@AllArgsConstructor
public class AccountCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture createAccount(@RequestBody CreateAccountRequestDTO request) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.getIniatialBalance(),
                request.getCurrency(),
                request.getStatus()
        ));
        return commandResponse;
    }

    @PutMapping("/credit")
    public CompletableFuture createAccount(@RequestBody CreditAccountRequestDTO request) {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreditAccountCommand(
                request.getId(),
                request.getAmount(),
                request.getCurrency()
        ));
        return commandResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        ResponseEntity<String> entity = new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return entity;
    }

    @GetMapping("/eventStore/{accountId}")
    public Stream eventStore(@PathVariable String accountId) {
        return eventStore.readEvents(accountId).asStream();
    }
}
