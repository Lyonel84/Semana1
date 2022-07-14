package com.nttdata.BC210.ManagementClientProduct.service.impl;

import com.nttdata.BC210.ManagementClientProduct.repository.IPasProPerCliRepository;
import com.nttdata.BC210.ManagementClientProduct.webclient.impl.ServiceWCImpl;
import com.nttdata.BC210.ManagementClientProduct.model.PasProPerCli;
import com.nttdata.BC210.ManagementClientProduct.request.PasProPerCliRequest;
import com.nttdata.BC210.ManagementClientProduct.service.IPasProPerCliService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PasProPerCliSerImpl implements IPasProPerCliService {

    @Autowired
    IPasProPerCliRepository pasiveProductPersonClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<PasProPerCli> create(PasProPerCliRequest pasProPerCliRequest) {
        return clientServiceWC.findPersonClientById(pasProPerCliRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                    clientServiceWC.findPassiveProductById(pasProPerCliRequest.getIdPasiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(pasiveProductResponse ->
                            pasiveProductPersonClientRepository.countByIdPersonClientAndIdPasiveProduct(pasProPerCliRequest.getIdPersonClient(), pasProPerCliRequest.getIdPasiveProduct())
                                    .switchIfEmpty(Mono.error(new Exception()))
                                    .flatMap(pasiveProductCountResponse ->
                            {
                                PasProPerCli pasProPerCli = new PasProPerCli();
                                pasProPerCli.setId(new ObjectId().toString());
                                pasProPerCli.setCreatedAt(LocalDateTime.now());
                                pasProPerCli.setAmount(pasProPerCliRequest.getAmount());
                                pasProPerCli.setOpeningDate(LocalDateTime.now());
                                pasProPerCli.setIdPersonClient(pasProPerCliRequest.getIdPersonClient());
                                pasProPerCli.setIdPasiveProduct(pasProPerCliRequest.getIdPasiveProduct());
                                pasProPerCli.setPersonClient(personClientResponse);
                                pasProPerCli.setPasiveProduct(pasiveProductResponse);

                                boolean validateClientPersonPasiveProduct = pasiveProductCountResponse > 0 ? false : true;

                                if(pasiveProductResponse.getAllowPersonClient() && validateClientPersonPasiveProduct){
                                    return pasiveProductPersonClientRepository.save(pasProPerCli);
                                }
                                return null;
                            })
                        )
                );
    }

    @Override
    public Mono<PasProPerCli> update(PasProPerCli pasProPerCli) {
        pasProPerCli.setUpdatedAt(LocalDateTime.now());
        return pasiveProductPersonClientRepository.save(pasProPerCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return pasiveProductPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<PasProPerCli> findById(String id) {
        return pasiveProductPersonClientRepository.findById(id);
    }

    @Override
    public Flux<PasProPerCli> findAll() {
        return pasiveProductPersonClientRepository.findAll();
    }
}
