package com.nttdata.BC21.Transaction.api;

import com.nttdata.BC21.Transaction.model.TransactionActProCreBusCli;
import com.nttdata.BC21.Transaction.request.TransactionActProCreBusCliRequest;
import com.nttdata.BC21.Transaction.service.ITransactionActProCreBusCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/active/credit/business")
public class TrasactionActProCreBusCliApi {

    @Autowired
    private ITransactionActProCreBusCliService transactionActProCreBusCliService;

    @PostMapping
    public Mono<TransactionActProCreBusCli> create(@RequestBody TransactionActProCreBusCliRequest transactionActProCreBusCliRequest){
        return transactionActProCreBusCliService.create(transactionActProCreBusCliRequest);
    }

    @PutMapping
    public Mono<TransactionActProCreBusCli> update(@RequestBody TransactionActProCreBusCli transactionActProCreBusCli){
        return transactionActProCreBusCliService.update(transactionActProCreBusCli);
    }

    @GetMapping
    public Flux<TransactionActProCreBusCli> findAll(){
        return transactionActProCreBusCliService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionActProCreBusCli> findById(@PathVariable String id){ return transactionActProCreBusCliService.findById(id); }

    @GetMapping("/find/{idActProCreBusCli}")
    public Flux<TransactionActProCreBusCli> findByIdActProCreBusCli(@PathVariable String idActProCreBusCli){
        return transactionActProCreBusCliService.findByIdActProCreBusCli(idActProCreBusCli);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionActProCreBusCliService.deleteById(id);
    }
}
