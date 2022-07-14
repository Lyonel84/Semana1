package com.nttdata.BC210.ManagementClientProduct.api;

import com.nttdata.BC210.ManagementClientProduct.model.PasProBusCli;
import com.nttdata.BC210.ManagementClientProduct.request.PasProBusCliRequest;
import com.nttdata.BC210.ManagementClientProduct.service.IPasProBusCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/passive/business")
public class PasProBusCliApi {
    @Autowired
    private IPasProBusCliService pasiveProductBusinessClientService;

    @PostMapping
    public Mono<PasProBusCli> create(@RequestBody PasProBusCliRequest pasProBusCliRequest){
        return pasiveProductBusinessClientService.create(pasProBusCliRequest);
    }

    @PutMapping
    public Mono<PasProBusCli> update(@RequestBody PasProBusCli pasProBusCli){
        return pasiveProductBusinessClientService.update(pasProBusCli);
    }

    @GetMapping
    public Flux<PasProBusCli> findAll(){
        return pasiveProductBusinessClientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PasProBusCli> findById(@PathVariable String id){ return pasiveProductBusinessClientService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return pasiveProductBusinessClientService.deleteById(id);
    }
}
