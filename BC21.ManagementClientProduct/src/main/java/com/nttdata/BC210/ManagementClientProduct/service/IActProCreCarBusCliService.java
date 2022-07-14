package com.nttdata.BC210.ManagementClientProduct.service;

import com.nttdata.BC210.ManagementClientProduct.model.ActProCreCarBusCli;
import com.nttdata.BC210.ManagementClientProduct.request.ActProCreCarBusCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActProCreCarBusCliService {
    Mono<ActProCreCarBusCli> create(ActProCreCarBusCliRequest actProCreCarBusCliRequest);
    Mono<ActProCreCarBusCli> update(ActProCreCarBusCli actProCreCarBusCli);
    Mono<Void>deleteById(String id);
    Mono<ActProCreCarBusCli> findById(String id);
    Flux<ActProCreCarBusCli> findAll();
}
