package com.nttdata.BC21.Transaction.api;

import com.nttdata.BC21.Transaction.model.TransactionActProCrePerCli;
import com.nttdata.BC21.Transaction.request.TransactionActProCrePerCliRequest;
import com.nttdata.BC21.Transaction.service.ITransactionActProCrePerCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction/active/credit/person")
public class TrasactionActProCrePerCliApi {

    @Autowired
    private ITransactionActProCrePerCliService transactionActProCrePerCliService;

    @PostMapping
    public Mono<TransactionActProCrePerCli> create(@RequestBody TransactionActProCrePerCliRequest transactionActProCrePerCliRequest){
        return transactionActProCrePerCliService.create(transactionActProCrePerCliRequest);
    }

    @PutMapping
    public Mono<TransactionActProCrePerCli> update(@RequestBody TransactionActProCrePerCli transactionActProCrePerCli){
        return transactionActProCrePerCliService.update(transactionActProCrePerCli);
    }

    @GetMapping
    public Flux<TransactionActProCrePerCli> findAll(){
        return transactionActProCrePerCliService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TransactionActProCrePerCli> findById(@PathVariable String id){ return transactionActProCrePerCliService.findById(id); }

    @GetMapping("/find/{idActProCrePerCli}")
    public Flux<TransactionActProCrePerCli> findByIdPasProPerCli(@PathVariable String idActProCrePerCli){
        return transactionActProCrePerCliService.findByIdActProCrePerCli(idActProCrePerCli);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return transactionActProCrePerCliService.deleteById(id);
    }
}
