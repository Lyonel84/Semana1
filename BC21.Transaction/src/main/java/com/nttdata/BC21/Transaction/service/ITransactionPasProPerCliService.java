package com.nttdata.BC21.Transaction.service;

import com.nttdata.BC21.Transaction.model.TransactionPasProPerCli;
import com.nttdata.BC21.Transaction.request.TransactionPasProPerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionPasProPerCliService {

    Mono<TransactionPasProPerCli> create(TransactionPasProPerCliRequest transactionPasProPerCliRequest);
    Mono<TransactionPasProPerCli> update(TransactionPasProPerCli transactionPasProPerCli);
    Mono<Void>deleteById(String id);
    Mono<TransactionPasProPerCli> findById(String id);
    Flux<TransactionPasProPerCli> findAll();

    Flux<TransactionPasProPerCli> findByIdPasProPerCli(String idPasProPerCli);
}
