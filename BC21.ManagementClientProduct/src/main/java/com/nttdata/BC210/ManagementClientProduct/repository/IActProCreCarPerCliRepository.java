package com.nttdata.BC210.ManagementClientProduct.repository;

import com.nttdata.BC210.ManagementClientProduct.model.ActProCreCarPerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActProCreCarPerCliRepository extends ReactiveMongoRepository<ActProCreCarPerCli, String> {
}
