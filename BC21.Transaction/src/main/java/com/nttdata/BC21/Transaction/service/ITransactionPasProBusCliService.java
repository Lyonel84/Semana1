package com.nttdata.BC21.Transaction.service;

import com.nttdata.BC21.Transaction.model.TransactionPasProBusCli;
import com.nttdata.BC21.Transaction.request.TransactionPasProBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionPasProBusCliService {

    Mono<TransactionPasProBusCli> create(TransactionPasProBusCliRequest transactionPasProBusCliRequest);
    Mono<TransactionPasProBusCli> update(TransactionPasProBusCli transactionPasProBusCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionPasProBusCli> findById(String id);
    Flux<TransactionPasProBusCli> findAll();

    Flux<TransactionPasProBusCli> findByIdPasProBusCli(String idPasProBusCli);
}
