package com.nttdata.BC21.Transaction.service;

import com.nttdata.BC21.Transaction.model.TransactionActProCreCarPerCli;
import com.nttdata.BC21.Transaction.request.TransactionActProCreCarPerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionActProCreCarPerCliService {

    Mono<TransactionActProCreCarPerCli> create(TransactionActProCreCarPerCliRequest transactionActProCreCarPerCliRequest);
    Mono<TransactionActProCreCarPerCli> update(TransactionActProCreCarPerCli transactionActProCreCarPerCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionActProCreCarPerCli> findById(String id);
    Flux<TransactionActProCreCarPerCli> findAll();

    Flux<TransactionActProCreCarPerCli> findByIdActProCreCarPerCli(String idActProCreCarPerCli);
}
