package com.nttdata.BC21.Transaction.repository;

import com.nttdata.BC21.Transaction.model.TransactionPasProBusCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ITransactionPasProBusCliRepository extends ReactiveMongoRepository<TransactionPasProBusCli, String> {
    Flux<TransactionPasProBusCli> findByIdPasProBusCli(String idPasProBusCli);
}
