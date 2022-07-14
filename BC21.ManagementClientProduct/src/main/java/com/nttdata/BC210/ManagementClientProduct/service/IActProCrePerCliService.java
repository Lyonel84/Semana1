package com.nttdata.BC210.ManagementClientProduct.service;

import com.nttdata.BC210.ManagementClientProduct.model.ActProCrePerCli;
import com.nttdata.BC210.ManagementClientProduct.request.ActProCrePerCliRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActProCrePerCliService {
    Mono<ActProCrePerCli> create(ActProCrePerCliRequest actProCrePerCliRequest);
    Mono<ActProCrePerCli> update(ActProCrePerCli actProCrePerCli);
    Mono<Void>deleteById(String id);
    Mono<ActProCrePerCli> findById(String id);
    Flux<ActProCrePerCli> findAll();
}
