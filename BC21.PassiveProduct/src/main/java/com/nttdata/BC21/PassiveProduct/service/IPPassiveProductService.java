package com.nttdata.BC21.PassiveProduct.service;

import com.nttdata.BC21.PassiveProduct.model.PassiveProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPPassiveProductService   {
    Mono<PassiveProduct> create(PassiveProduct passiveProduct);
    Mono<PassiveProduct> update(PassiveProduct passiveProduct);
    Mono<Void>deleteById(String id);
    Mono<PassiveProduct> findById(String id);
    Flux<PassiveProduct> findAll();
}
