package com.nttdata.BC210.ManagementClientProduct.service.impl;

import com.nttdata.BC210.ManagementClientProduct.repository.IActProCrePerCliRepository;
import com.nttdata.BC210.ManagementClientProduct.webclient.impl.ServiceWCImpl;
import com.nttdata.BC210.ManagementClientProduct.model.ActProCrePerCli;
import com.nttdata.BC210.ManagementClientProduct.request.ActProCrePerCliRequest;
import com.nttdata.BC210.ManagementClientProduct.service.IActProCrePerCliService;
import com.nttdata.BC210.ManagementClientProduct.util.ActiveProductType;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActProCrePerCliSerImpl implements IActProCrePerCliService {

    @Autowired
    IActProCrePerCliRepository activeProductCreditPersonClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActProCrePerCli> create(ActProCrePerCliRequest actProCrePerCliRequest) {

        return clientServiceWC.findPersonClientById(actProCrePerCliRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                    clientServiceWC.findActiveProductById(actProCrePerCliRequest.getIdActiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(activeProductResponse -> {
                            ActProCrePerCli actProCrePerCli = new ActProCrePerCli();
                            actProCrePerCli.setId(new ObjectId().toString());
                            actProCrePerCli.setCreatedAt(LocalDateTime.now());
                            actProCrePerCli.setAmountGiven(actProCrePerCliRequest.getAmountGiven());
                            actProCrePerCli.setInterestRate(actProCrePerCliRequest.getInterestRate());
                            actProCrePerCli.setIdPersonClient(actProCrePerCliRequest.getIdPersonClient());
                            actProCrePerCli.setIdActiveProduct(actProCrePerCliRequest.getIdActiveProduct());
                            actProCrePerCli.setPersonClient(personClientResponse);
                            actProCrePerCli.setActiveProduct(activeProductResponse);

                            if(activeProductResponse.getName().equals(ActiveProductType.CREDITO.name()))
                                return activeProductCreditPersonClientRepository.save(actProCrePerCli);
                            return null;
                        })
                );
    }

    @Override
    public Mono<ActProCrePerCli> update(ActProCrePerCli actProCrePerCli) {
        actProCrePerCli.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditPersonClientRepository.save(actProCrePerCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActProCrePerCli> findById(String id) {
        return activeProductCreditPersonClientRepository.findById(id);
    }

    @Override
    public Flux<ActProCrePerCli> findAll() {
        return activeProductCreditPersonClientRepository.findAll();
    }
}
