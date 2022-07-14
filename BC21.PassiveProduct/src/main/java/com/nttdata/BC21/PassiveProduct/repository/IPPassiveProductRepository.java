package com.nttdata.BC21.PassiveProduct.repository;

import com.nttdata.BC21.PassiveProduct.model.PassiveProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IPPassiveProductRepository extends ReactiveMongoRepository<PassiveProduct, String> {
}
