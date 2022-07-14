package com.nttdata.BC21.PassiveProduct.service.impl;

import com.nttdata.BC21.PassiveProduct.model.PassiveProduct;
import com.nttdata.BC21.PassiveProduct.repository.IPPassiveProductRepository;
import com.nttdata.BC21.PassiveProduct.service.IPPassiveProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PassiveProductServiceImpl implements IPPassiveProductService {
    @Autowired
    IPPassiveProductRepository passiveProductRepository;

    @Override
    public Mono<PassiveProduct> create(PassiveProduct passiveProduct) {

        passiveProduct.setId(new ObjectId().toString());
        passiveProduct.setCreatedAt(LocalDateTime.now());
        return passiveProductRepository.save(passiveProduct);
    }

    @Override
    public Mono<PassiveProduct> update(PassiveProduct passiveProduct) {

        passiveProduct.setUpdatedAt(LocalDateTime.now());
        return passiveProductRepository.save(passiveProduct);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return passiveProductRepository.deleteById(id);
    }

    @Override
    public Mono<PassiveProduct> findById(String id) {
        return passiveProductRepository.findById(id);
    }

    @Override
    public Flux<PassiveProduct> findAll() {
        return passiveProductRepository.findAll();
    }
}
