package com.nttdata.BC210.ManagementClientProduct.service.impl;

import com.nttdata.BC210.ManagementClientProduct.repository.IPasProBusCliRepository;
import com.nttdata.BC210.ManagementClientProduct.webclient.impl.ServiceWCImpl;
import com.nttdata.BC210.ManagementClientProduct.model.PasProBusCli;
import com.nttdata.BC210.ManagementClientProduct.request.PasProBusCliRequest;
import com.nttdata.BC210.ManagementClientProduct.service.IPasProBusCliService;
import com.nttdata.BC210.ManagementClientProduct.util.PasiveProductType;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PasProBusCliSerImpl implements IPasProBusCliService {

    @Autowired
    IPasProBusCliRepository pasiveProductBusinessClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;
    
    @Override
    public Mono<PasProBusCli> create(PasProBusCliRequest pasiveProductBusinessClientrequest) {
        return clientServiceWC.findBusinessClientById(pasiveProductBusinessClientrequest.getIdBusinessClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(businessClientResponse ->
                        clientServiceWC.findPassiveProductById(pasiveProductBusinessClientrequest.getIdPasiveProduct())
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(pasiveProductResponse -> {
                                    PasProBusCli pasProBusCli = new PasProBusCli();
                                    pasProBusCli.setId(new ObjectId().toString());
                                    pasProBusCli.setCreatedAt(LocalDateTime.now());
                                    pasProBusCli.setAmount(pasiveProductBusinessClientrequest.getAmount());
                                    pasProBusCli.setOpeningDate(LocalDateTime.now());
                                    pasProBusCli.setIdBusinessClient(pasiveProductBusinessClientrequest.getIdBusinessClient());
                                    pasProBusCli.setIdPasiveProduct(pasiveProductBusinessClientrequest.getIdPasiveProduct());
                                    pasProBusCli.setBusinessClient(businessClientResponse);
                                    pasProBusCli.setPasiveProduct(pasiveProductResponse);
                                    pasProBusCli.setHolders(pasiveProductBusinessClientrequest.getHolders());
                                    pasProBusCli.setSigners(pasiveProductBusinessClientrequest.getSigners());

                                    if(pasiveProductResponse.getAllowBusinessClient() && pasiveProductResponse.getName().equals(PasiveProductType.CORRIENTE.name()) && !pasProBusCli.getHolders().isEmpty()){
                                        return pasiveProductBusinessClientRepository.save(pasProBusCli);
                                    }
                                    return null;
                                })
                );
    }

    @Override
    public Mono<PasProBusCli> update(PasProBusCli pasProBusCli) {
        pasProBusCli.setUpdatedAt(LocalDateTime.now());
        return pasiveProductBusinessClientRepository.save(pasProBusCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return pasiveProductBusinessClientRepository.deleteById(id);
    }

    @Override
    public Mono<PasProBusCli> findById(String id) {
        return pasiveProductBusinessClientRepository.findById(id);
    }

    @Override
    public Flux<PasProBusCli> findAll() {
        return pasiveProductBusinessClientRepository.findAll();
    }
}
