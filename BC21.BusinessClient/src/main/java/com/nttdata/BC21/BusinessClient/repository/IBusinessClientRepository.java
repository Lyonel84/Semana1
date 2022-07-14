package com.nttdata.BC21.BusinessClient.repository;

import com.nttdata.BC21.BusinessClient.model.BusinessClient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusinessClientRepository extends ReactiveMongoRepository<BusinessClient, String> {
}
