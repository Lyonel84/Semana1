package com.nttdata.BC21.Transaction.repository;

import com.nttdata.BC21.Transaction.model.TransactionActProCrePerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionActProCrePerCliRepository extends ReactiveMongoRepository<TransactionActProCrePerCli, String> {
    Flux<TransactionActProCrePerCli> findByIdActProCrePerCli(String idActProCrePerCli);
}
