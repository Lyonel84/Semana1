package com.nttdata.BC21.PassiveProduct.api;


import com.nttdata.BC21.PassiveProduct.model.PassiveProduct;
import com.nttdata.BC21.PassiveProduct.service.IPPassiveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product/passive")
public class PassiveProductApi {
    @Autowired
    private IPPassiveProductService passiveProductService;

    @PostMapping
    public Mono<PassiveProduct> create(@RequestBody PassiveProduct passiveProduct){ return passiveProductService.create(passiveProduct); }

    @PutMapping
    public Mono<PassiveProduct> update(@RequestBody PassiveProduct passiveProduct){ return passiveProductService.update(passiveProduct); }

    @GetMapping
    public Flux<PassiveProduct> findAll(){
        return passiveProductService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PassiveProduct> findById(@PathVariable String id){ return passiveProductService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return passiveProductService.deleteById(id);
    }
}
