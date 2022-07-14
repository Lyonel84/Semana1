package com.nttdata.BC21.Transaction.service;

import com.nttdata.BC21.Transaction.model.TransactionActProCreBusCli;
import com.nttdata.BC21.Transaction.request.TransactionActProCreBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionActProCreBusCliService {

    Mono<TransactionActProCreBusCli> create(TransactionActProCreBusCliRequest transactionActProCreBusCliRequest);
    Mono<TransactionActProCreBusCli> update(TransactionActProCreBusCli transactionActProCreBusCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionActProCreBusCli> findById(String id);
    Flux<TransactionActProCreBusCli> findAll();

    Flux<TransactionActProCreBusCli> findByIdActProCreBusCli(String idAActProCreBusCli);
}
