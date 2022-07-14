package com.nttdata.BC210.ManagementClientProduct.api;

import com.nttdata.BC210.ManagementClientProduct.model.ActProCreBusCli;
import com.nttdata.BC210.ManagementClientProduct.request.ActProCreBusCliRequest;
import com.nttdata.BC210.ManagementClientProduct.service.IActProCreBusCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/active/credit/business")
public class ActProCreBusCliApi {
    @Autowired
    private IActProCreBusCliService activeProductCreditBusinessClientService;

    @PostMapping
    public Mono<ActProCreBusCli> create(@RequestBody ActProCreBusCliRequest actProCreBusCliRequest){
        return activeProductCreditBusinessClientService.create(actProCreBusCliRequest);
    }

    @PutMapping
    public Mono<ActProCreBusCli> update(@RequestBody ActProCreBusCli activeProductCreditPersonClient){
        return activeProductCreditBusinessClientService.update(activeProductCreditPersonClient);
    }

    @GetMapping
    public Flux<ActProCreBusCli> findAll(){
        return activeProductCreditBusinessClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ActProCreBusCli> findById(@PathVariable String id){ return activeProductCreditBusinessClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return activeProductCreditBusinessClientService.deleteById(id);
    }
}
