package com.nttdata.BC21.Transaction.service.impl;

import com.nttdata.BC21.Transaction.repository.ITransactionPasProPerCliRepository;
import com.nttdata.BC21.Transaction.webclient.impl.ServiceWCImpl;
import com.nttdata.BC21.Transaction.model.TransactionPasProPerCli;
import com.nttdata.BC21.Transaction.request.TransactionPasProPerCliRequest;
import com.nttdata.BC21.Transaction.service.ITransactionPasProPerCliService;
import com.nttdata.BC21.Transaction.util.TransactionTypePasPro;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TransactionPasProPerCliServiceImpl implements ITransactionPasProPerCliService {

    @Autowired
    ITransactionPasProPerCliRepository transactionPasProPerCliRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<TransactionPasProPerCli> create(TransactionPasProPerCliRequest transactionPasProPerCliRequest) {

        return clientServiceWC.findPasProPerCliById(transactionPasProPerCliRequest.getIdPasProPerCli())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(pasProPerCliResponse -> {
                    TransactionPasProPerCli transactionPasProPerCli = new TransactionPasProPerCli();
                    transactionPasProPerCli.setId(new ObjectId().toString());
                    transactionPasProPerCli.setIdPasProPerCli(transactionPasProPerCliRequest.getIdPasProPerCli());
                    transactionPasProPerCli.setTransactionTypePasPro(transactionPasProPerCliRequest.getTransactionTypePasPro());
                    transactionPasProPerCli.setTransactionDate(LocalDateTime.now());
                    transactionPasProPerCli.setCreatedAt(LocalDateTime.now());
                    //transactionPasProPerCli.setPasProPerCli(pasProPerCliResponse);

                    if(transactionPasProPerCliRequest.getTransactionTypePasPro().equals(TransactionTypePasPro.RETIRO.name())){
                        if(pasProPerCliResponse.getAmount() >= transactionPasProPerCliRequest.getAmount()){
                            pasProPerCliResponse.setAmount(pasProPerCliResponse.getAmount() - transactionPasProPerCliRequest.getAmount());
                            //clientServiceWC.updatePasProPerCli(pasProPerCliResponse);
                            //return transactionPasProPerCliRepository.save(transactionPasProPerCli);
                            return clientServiceWC.updatePasProPerCli(pasProPerCliResponse)
                                    .switchIfEmpty(Mono.error(new Exception()))
                                    .flatMap(pasProPerCliResponseUpdate -> {
                                        transactionPasProPerCli.setPasProPerCli(pasProPerCliResponseUpdate);
                                        return transactionPasProPerCliRepository.save(transactionPasProPerCli);
                                    });
                        }
                    }
                    else if(transactionPasProPerCliRequest.getTransactionTypePasPro().equals(TransactionTypePasPro.DEPOSITO.name())){
                        pasProPerCliResponse.setAmount(pasProPerCliResponse.getAmount() + transactionPasProPerCliRequest.getAmount());
                        //clientServiceWC.updatePasProPerCli(pasProPerCliResponse);
                        //return transactionPasProPerCliRepository.save(transactionPasProPerCli);
                        return clientServiceWC.updatePasProPerCli(pasProPerCliResponse)
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(pasProPerCliResponseUpdate -> {
                                    transactionPasProPerCli.setPasProPerCli(pasProPerCliResponseUpdate);
                                    return transactionPasProPerCliRepository.save(transactionPasProPerCli);
                                });
                    }

                    return null;
                });
    }

    @Override
    public Mono<TransactionPasProPerCli> update(TransactionPasProPerCli transactionPasProPerCli) {
        transactionPasProPerCli.setUpdatedAt(LocalDateTime.now());
        return transactionPasProPerCliRepository.save(transactionPasProPerCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionPasProPerCliRepository.deleteById(id);
    }

    @Override
    public Mono<TransactionPasProPerCli> findById(String id) {
        return transactionPasProPerCliRepository.findById(id);
    }

    @Override
    public Flux<TransactionPasProPerCli> findAll() {
        return transactionPasProPerCliRepository.findAll();
    }

    @Override
    public Flux<TransactionPasProPerCli> findByIdPasProPerCli(String idPasProPerCli) {
        return transactionPasProPerCliRepository.findByIdPasProPerCli(idPasProPerCli);
    }
}
