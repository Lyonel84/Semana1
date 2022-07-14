package com.nttdata.BC21.Transaction.api;

import com.nttdata.BC21.Transaction.model.TransactionPasProBusCli;
import com.nttdata.BC21.Transaction.request.TransactionPasProBusCliRequest;
import com.nttdata.BC21.Transaction.service.ITransactionPasProBusCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/passive/business")
public class TrasactionPasProBusCliApi {

    @Autowired
    private ITransactionPasProBusCliService transactionPasProBusCliService;

    @PostMapping
    public Mono<TransactionPasProBusCli> create(@RequestBody TransactionPasProBusCliRequest transactionPasProBusCliRequest){
        return transactionPasProBusCliService.create(transactionPasProBusCliRequest);
    }

    @PutMapping
    public Mono<TransactionPasProBusCli> update(@RequestBody TransactionPasProBusCli transactionPasProBusCli){
        return transactionPasProBusCliService.update(transactionPasProBusCli);
    }

    @GetMapping
    public Flux<TransactionPasProBusCli> findAll(){
        return transactionPasProBusCliService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionPasProBusCli> findById(@PathVariable String id){ return transactionPasProBusCliService.findById(id); }

    @GetMapping("/find/{idPasProBusCli}")
    public Flux<TransactionPasProBusCli> findByidPasProBusCli(@PathVariable String idPasProBusCli){
        return transactionPasProBusCliService.findByIdPasProBusCli(idPasProBusCli);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionPasProBusCliService.deleteById(id);
    }
}
