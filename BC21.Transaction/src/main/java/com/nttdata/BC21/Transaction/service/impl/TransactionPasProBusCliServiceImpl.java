package com.nttdata.BC21.Transaction.service.impl;

import com.nttdata.BC21.Transaction.repository.ITransactionPasProBusCliRepository;
import com.nttdata.BC21.Transaction.webclient.impl.ServiceWCImpl;
import com.nttdata.BC21.Transaction.model.TransactionPasProBusCli;
import com.nttdata.BC21.Transaction.request.TransactionPasProBusCliRequest;
import com.nttdata.BC21.Transaction.service.ITransactionPasProBusCliService;
import com.nttdata.BC21.Transaction.util.TransactionTypePasPro;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionPasProBusCliServiceImpl implements ITransactionPasProBusCliService {

    @Autowired
    ITransactionPasProBusCliRepository transactionPasProBusCliRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionPasProBusCli> create(TransactionPasProBusCliRequest transactionPasProBusCliRequest) {
        return clientServiceWC.findPasProBusCliById(transactionPasProBusCliRequest.getIdPasProBusCli())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(pasProBusCliResponse -> {
                    TransactionPasProBusCli transactionPasProBusCli = new TransactionPasProBusCli();
                    transactionPasProBusCli.setId(new ObjectId().toString());
                    transactionPasProBusCli.setIdPasProBusCli(transactionPasProBusCliRequest.getIdPasProBusCli());
                    transactionPasProBusCli.setTransactionTypePasPro(transactionPasProBusCliRequest.getTransactionTypePasPro());
                    transactionPasProBusCli.setTransactionDate(LocalDateTime.now());
                    transactionPasProBusCli.setCreatedAt(LocalDateTime.now());
                    //transactionPasProBusCli.setPasProBusCli(pasProBusCliResponse);

                    if(transactionPasProBusCliRequest.getTransactionTypePasPro().equals(TransactionTypePasPro.RETIRO.name())){
                        if(pasProBusCliResponse.getAmount() >= transactionPasProBusCliRequest.getAmount()){
                            pasProBusCliResponse.setAmount(pasProBusCliResponse.getAmount() - transactionPasProBusCliRequest.getAmount());
                            //clientServiceWC.updatePasProBusCli(PasProBusCliResponse);
                            //return transactionPasProBusCliRepository.save(transactionPasProBusCli);
                            return clientServiceWC.updatePasProBusCli(pasProBusCliResponse)
                                    .switchIfEmpty(Mono.error(new Exception()))
                                    .flatMap(pasProBusCliResponseUpdate -> {
                                        transactionPasProBusCli.setPasProBusCli(pasProBusCliResponseUpdate);
                                        return transactionPasProBusCliRepository.save(transactionPasProBusCli);
                                    });
                        }
                    }
                    else if(transactionPasProBusCliRequest.getTransactionTypePasPro().equals(TransactionTypePasPro.DEPOSITO.name())){
                        pasProBusCliResponse.setAmount(pasProBusCliResponse.getAmount() + transactionPasProBusCliRequest.getAmount());
                        //clientServiceWC.updatePasProBusCli(pasProBusCliResponse);
                        //return transactionPasProBusCliRepository.save(transactionPasProBusCli);
                        return clientServiceWC.updatePasProBusCli(pasProBusCliResponse)
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(pasProBusCliResponseUpdate -> {
                                    transactionPasProBusCli.setPasProBusCli(pasProBusCliResponseUpdate);
                                    return transactionPasProBusCliRepository.save(transactionPasProBusCli);
                                });
                    }

                    return null;
                });
    }

    @Override
    public Mono<TransactionPasProBusCli> update(TransactionPasProBusCli transactionPasProBusCli) {
        transactionPasProBusCli.setUpdatedAt(LocalDateTime.now());
        return transactionPasProBusCliRepository.save(transactionPasProBusCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionPasProBusCliRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionPasProBusCli> findById(String id) {
        return transactionPasProBusCliRepository.findById(id);
    }

    @Override
    public Flux<TransactionPasProBusCli> findAll() {
        return transactionPasProBusCliRepository.findAll();
    }

    @Override
    public Flux<TransactionPasProBusCli> findByIdPasProBusCli(String idPasProBusCli) {
        return null;
    }
}
