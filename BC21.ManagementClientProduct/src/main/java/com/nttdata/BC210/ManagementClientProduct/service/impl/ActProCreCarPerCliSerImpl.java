package com.nttdata.BC210.ManagementClientProduct.service.impl;

import com.nttdata.BC210.ManagementClientProduct.repository.IActProCreCarPerCliRepository;
import com.nttdata.BC210.ManagementClientProduct.webclient.impl.ServiceWCImpl;
import com.nttdata.BC210.ManagementClientProduct.model.ActProCreCarPerCli;
import com.nttdata.BC210.ManagementClientProduct.request.ActProCreCarPerCliRequest;
import com.nttdata.BC210.ManagementClientProduct.service.IActProCreCarPerCliService;
import com.nttdata.BC210.ManagementClientProduct.util.ActiveProductType;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActProCreCarPerCliSerImpl implements IActProCreCarPerCliService {

    @Autowired
    IActProCreCarPerCliRepository activeProductCreditCardPersonClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActProCreCarPerCli> create(ActProCreCarPerCliRequest actProCreCarPerCliRequest) {

        return clientServiceWC.findPersonClientById(actProCreCarPerCliRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                    clientServiceWC.findActiveProductById(actProCreCarPerCliRequest.getIdActiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(activeProductResponse -> {
                            ActProCreCarPerCli actProCreCarPerCli = new ActProCreCarPerCli();
                            actProCreCarPerCli.setId(new ObjectId().toString());
                            actProCreCarPerCli.setCreatedAt(LocalDateTime.now());
                            actProCreCarPerCli.setCreditLine(actProCreCarPerCliRequest.getCreditLine());
                            actProCreCarPerCli.setAnnualCommission(actProCreCarPerCliRequest.getAnnualCommission());
                            actProCreCarPerCli.setCutoffDate(actProCreCarPerCliRequest.getCutoffDate());
                            actProCreCarPerCli.setPayLimitDate(actProCreCarPerCliRequest.getPayLimitDate());
                            actProCreCarPerCli.setIdPersonClient(actProCreCarPerCliRequest.getIdPersonClient());
                            actProCreCarPerCli.setIdActiveProduct(actProCreCarPerCliRequest.getIdActiveProduct());
                            actProCreCarPerCli.setPersonClient(personClientResponse);
                            actProCreCarPerCli.setActiveProduct(activeProductResponse);

                            if(activeProductResponse.getName().equals(ActiveProductType.TARJETACREDITO.name()))
                                return activeProductCreditCardPersonClientRepository.save(actProCreCarPerCli);
                            return null;
                    })
                );
    }

    @Override
    public Mono<ActProCreCarPerCli> update(ActProCreCarPerCli actProCreCarPerCli) {
        actProCreCarPerCli.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditCardPersonClientRepository.save(actProCreCarPerCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditCardPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActProCreCarPerCli> findById(String id) {
        return activeProductCreditCardPersonClientRepository.findById(id);
    }

    @Override
    public Flux<ActProCreCarPerCli> findAll() {
        return activeProductCreditCardPersonClientRepository.findAll();
    }
}
