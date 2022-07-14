package com.nttdata.BC21.Transaction.repository;

import com.nttdata.BC21.Transaction.model.TransactionActProCreBusCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionActProCreBusCliRepository extends ReactiveMongoRepository<TransactionActProCreBusCli, String> {
    Flux<TransactionActProCreBusCli> findByIdActProCreBusCli(String idActProCreBusCli);
}
