package com.nttdata.BC210.ManagementClientProduct.api;

import com.nttdata.BC210.ManagementClientProduct.model.PasProPerCli;
import com.nttdata.BC210.ManagementClientProduct.request.PasProPerCliRequest;
import com.nttdata.BC210.ManagementClientProduct.service.IPasProPerCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/passive/person")
public class PasProPerCliApi {

    @Autowired
    private IPasProPerCliService pasiveProductPersonClientService;

    @PostMapping
    public Mono<PasProPerCli> create(@RequestBody PasProPerCliRequest pasProPerCliRequest){
        return pasiveProductPersonClientService.create(pasProPerCliRequest);
    }

    @PutMapping
    public Mono<PasProPerCli> update(@RequestBody PasProPerCli pasProPerCli){
        return pasiveProductPersonClientService.update(pasProPerCli);
    }

    @GetMapping
    public Flux<PasProPerCli> findAll(){
        return pasiveProductPersonClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PasProPerCli> findById(@PathVariable String id){ return pasiveProductPersonClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return pasiveProductPersonClientService.deleteById(id);
    }
}
