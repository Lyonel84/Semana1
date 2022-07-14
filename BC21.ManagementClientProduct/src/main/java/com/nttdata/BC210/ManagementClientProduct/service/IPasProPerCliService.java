package com.nttdata.BC210.ManagementClientProduct.service;

import com.nttdata.BC210.ManagementClientProduct.model.PasProPerCli;
import com.nttdata.BC210.ManagementClientProduct.request.PasProPerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPasProPerCliService {

    Mono<PasProPerCli> create(PasProPerCliRequest pasiveProductPersonClientrequest);
    Mono<PasProPerCli> update(PasProPerCli pasProPerCli);
    Mono<Void>deleteById(String id);
    Mono<PasProPerCli> findById(String id);
    Flux<PasProPerCli> findAll();
}
