package com.nttdata.BC21.Transaction.repository;

import com.nttdata.BC21.Transaction.model.TransactionActProCreCarBusCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionActProCreCarBusCliRepository extends ReactiveMongoRepository<TransactionActProCreCarBusCli, String> {
    Flux<TransactionActProCreCarBusCli> findByIdActProCreCarBusCli(String idActProCreCarBusCli);
}
