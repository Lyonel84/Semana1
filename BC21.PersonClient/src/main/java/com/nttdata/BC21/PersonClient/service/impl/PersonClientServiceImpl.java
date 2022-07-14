package com.nttdata.BC21.PersonClient.service.impl;


import com.nttdata.BC21.PersonClient.model.PersonClient;
import com.nttdata.BC21.PersonClient.repository.IPersonClientRepository;
import com.nttdata.BC21.PersonClient.service.IPersonClientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PersonClientServiceImpl implements IPersonClientService {
    @Autowired
    IPersonClientRepository iPersonClientRepository;

    @Override
    public Mono<PersonClient> create(PersonClient personClient) {

        personClient.setId(new ObjectId().toString());
        personClient.setCreatedAt(LocalDateTime.now());
        return iPersonClientRepository.save(personClient);
    }

    @Override
    public Mono<PersonClient> update(PersonClient personClient) {

        personClient.setUpdatedAt(LocalDateTime.now());
        return iPersonClientRepository.save(personClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<PersonClient> findById(String id) {
        return iPersonClientRepository.findById(id);
    }

    @Override
    public Flux<PersonClient> findAll() {
        return iPersonClientRepository.findAll();
    }
}
