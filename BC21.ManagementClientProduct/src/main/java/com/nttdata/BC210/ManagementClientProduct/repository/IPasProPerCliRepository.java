package com.nttdata.BC210.ManagementClientProduct.repository;

import com.nttdata.BC210.ManagementClientProduct.model.PasProPerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IPasProPerCliRepository extends ReactiveMongoRepository<PasProPerCli, String> {
    Flux<PasProPerCli> findByIdPersonClient(String id);

    Mono<Long> countByIdPersonClient(String id);
    Flux<PasProPerCli> findByIdPersonClientAndIdPasiveProduct(String idPersonClient, String idPasiveProduct);

    Mono<Long> countByIdPersonClientAndIdPasiveProduct(String idPersonClient, String idPasiveProduct);
}
