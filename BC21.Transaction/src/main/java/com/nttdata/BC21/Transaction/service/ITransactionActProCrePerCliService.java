package com.nttdata.BC21.Transaction.service;

import com.nttdata.BC21.Transaction.model.TransactionActProCrePerCli;
import com.nttdata.BC21.Transaction.request.TransactionActProCrePerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionActProCrePerCliService {

    Mono<TransactionActProCrePerCli> create(TransactionActProCrePerCliRequest transactionActProCrePerCliRequest);
    Mono<TransactionActProCrePerCli> update(TransactionActProCrePerCli transactionActProCrePerCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionActProCrePerCli> findById(String id);
    Flux<TransactionActProCrePerCli> findAll();

    Flux<TransactionActProCrePerCli> findByIdActProCrePerCli(String idActProCrePerCli);
}
