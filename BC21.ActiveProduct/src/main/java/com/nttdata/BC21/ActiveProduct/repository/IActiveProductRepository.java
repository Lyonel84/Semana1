package com.nttdata.BC21.ActiveProduct.repository;

import com.nttdata.BC21.ActiveProduct.model.ActiveProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActiveProductRepository extends ReactiveMongoRepository<ActiveProduct, String> {
}
