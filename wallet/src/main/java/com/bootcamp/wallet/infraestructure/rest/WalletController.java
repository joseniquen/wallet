package com.bootcamp.wallet.infraestructure.rest;

import com.bootcamp.wallet.application.WalletOperations;
import com.bootcamp.wallet.domain.Wallet;
import com.bootcamp.wallet.spring.config.CacheConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletOperations operations;

    @GetMapping
    public Flux<Wallet> listAll() {
        return operations.listAll();
    }

    @GetMapping("/{celular}")
    public Mono<Wallet> get(@PathVariable("celular") String celular) {
        return operations.get(celular);
    }

    @GetMapping("/{nroDoc}/list")
    public Mono<Wallet> listByNroDoc(@PathVariable("nroDoc") String nroDoc) {
        return operations.listByNroDoc(nroDoc);
    }

    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody Wallet c) {
        c.setCelular(c.getCelular());
        return Mono.just(c).flatMap(m -> {
            return operations.listAll().filter(p -> p.getCelular().equals(m.getCelular())).count().flatMap(fm -> {
               if (fm.intValue() == 0) {
                    return operations.create(c).flatMap(rp -> {
                        return Mono.just(ResponseEntity.ok(rp));
                   });
                } else {
                    return Mono.just(ResponseEntity.ok("El cliente ya tiene numero asociado a tunki."));
                }
            });
        });
    }

    @PutMapping("/{celular}")
    public Mono<Wallet> update(@PathVariable("celular") String celular, @RequestBody Wallet c) {
        return operations.update(celular, c);
    }
    @DeleteMapping("/{celular}")
    public void delete(@PathVariable("celular") String celular) {
        operations.delete(celular);
    }

}
