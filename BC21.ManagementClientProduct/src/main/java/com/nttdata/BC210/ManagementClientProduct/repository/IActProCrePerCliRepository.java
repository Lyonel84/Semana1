package com.nttdata.BC210.ManagementClientProduct.repository;

import com.nttdata.BC210.ManagementClientProduct.model.ActProCrePerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActProCrePerCliRepository extends ReactiveMongoRepository<ActProCrePerCli, String> {
}
