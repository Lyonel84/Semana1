package com.nttdata.BC21.BusinessClient.service;

import com.nttdata.BC21.BusinessClient.model.BusinessClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusinessClientService {
    Mono<BusinessClient> create(BusinessClient businessClient);
    Mono<BusinessClient> update(BusinessClient businessClient);
    Mono<Void>deleteById(String id);
    Mono<BusinessClient> findById(String id);
    Flux<BusinessClient> findAll();
}
