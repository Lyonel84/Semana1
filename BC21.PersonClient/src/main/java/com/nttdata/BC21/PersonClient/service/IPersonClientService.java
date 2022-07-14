package com.nttdata.BC21.PersonClient.service;

import com.nttdata.BC21.PersonClient.model.PersonClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonClientService {
    Mono<PersonClient> create(PersonClient personClient);
    Mono<PersonClient> update(PersonClient personClient);
    Mono<Void>deleteById(String id);
    Mono<PersonClient> findById(String id);
    Flux<PersonClient> findAll();
}
