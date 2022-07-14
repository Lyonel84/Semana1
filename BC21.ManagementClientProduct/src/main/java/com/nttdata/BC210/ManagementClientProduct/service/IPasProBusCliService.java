package com.nttdata.BC210.ManagementClientProduct.service;

import com.nttdata.BC210.ManagementClientProduct.model.PasProBusCli;
import com.nttdata.BC210.ManagementClientProduct.request.PasProBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPasProBusCliService {
    Mono<PasProBusCli> create(PasProBusCliRequest pasiveProductBusinessClientrequest);
    Mono<PasProBusCli> update(PasProBusCli pasProBusCli);
    Mono<Void>deleteById(String id);
    Mono<PasProBusCli> findById(String id);
    Flux<PasProBusCli> findAll();
}
