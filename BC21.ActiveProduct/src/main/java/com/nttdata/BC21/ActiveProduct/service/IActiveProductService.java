package com.nttdata.BC21.ActiveProduct.service;

import com.nttdata.BC21.ActiveProduct.model.ActiveProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IActiveProductService {
    Mono<ActiveProduct> create(ActiveProduct activeProduct);
    Mono<ActiveProduct> update(ActiveProduct activeProduct);
    Mono<Void>deleteById(String id);
    Mono<ActiveProduct> findById(String id);
    Flux<ActiveProduct> findAll();
}
