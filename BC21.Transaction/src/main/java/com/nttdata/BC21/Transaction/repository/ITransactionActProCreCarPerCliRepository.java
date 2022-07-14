package com.nttdata.BC21.Transaction.repository;

import com.nttdata.BC21.Transaction.model.TransactionActProCreCarPerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionActProCreCarPerCliRepository extends ReactiveMongoRepository<TransactionActProCreCarPerCli, String> {
    Flux<TransactionActProCreCarPerCli> findByIdActProCreCarPerCli(String idActProCreCarPerCli);
}
