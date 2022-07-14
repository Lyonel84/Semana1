package com.nttdata.BC210.ManagementClientProduct.service;

import com.nttdata.BC210.ManagementClientProduct.model.ActProCreCarPerCli;
import com.nttdata.BC210.ManagementClientProduct.request.ActProCreCarPerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActProCreCarPerCliService {
    Mono<ActProCreCarPerCli> create(ActProCreCarPerCliRequest actProCreCarPerCliRequest);
    Mono<ActProCreCarPerCli> update(ActProCreCarPerCli actProCreCarPerCli);
    Mono<Void>deleteById(String id);
    Mono<ActProCreCarPerCli> findById(String id);
    Flux<ActProCreCarPerCli> findAll();
}
