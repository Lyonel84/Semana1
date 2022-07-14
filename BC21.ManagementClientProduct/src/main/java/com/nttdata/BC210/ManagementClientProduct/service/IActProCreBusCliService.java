package com.nttdata.BC210.ManagementClientProduct.service;

import com.nttdata.BC210.ManagementClientProduct.model.ActProCreBusCli;
import com.nttdata.BC210.ManagementClientProduct.request.ActProCreBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActProCreBusCliService {
    Mono<ActProCreBusCli> create(ActProCreBusCliRequest actProCreBusCliRequest);
    Mono<ActProCreBusCli> update(ActProCreBusCli actProCreBusCli);
    Mono<Void>deleteById(String id);
    Mono<ActProCreBusCli> findById(String id);
    Flux<ActProCreBusCli> findAll();
}
