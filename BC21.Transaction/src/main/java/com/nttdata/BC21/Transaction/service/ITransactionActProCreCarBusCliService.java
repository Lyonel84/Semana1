package com.nttdata.BC21.Transaction.service;

import com.nttdata.BC21.Transaction.model.TransactionActProCreCarBusCli;
import com.nttdata.BC21.Transaction.request.TransactionActProCreCarBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionActProCreCarBusCliService {

    Mono<TransactionActProCreCarBusCli> create(TransactionActProCreCarBusCliRequest transactionActProCreCarBusCliRequest);
    Mono<TransactionActProCreCarBusCli> update(TransactionActProCreCarBusCli transactionActProCreCarBusCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionActProCreCarBusCli> findById(String id);
    Flux<TransactionActProCreCarBusCli> findAll();

    Flux<TransactionActProCreCarBusCli> findByIdActProCreCarBusCli(String idActProCreCarBusCli);
}
