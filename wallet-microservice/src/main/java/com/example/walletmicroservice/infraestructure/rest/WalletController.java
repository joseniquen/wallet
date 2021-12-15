package com.example.walletmicroservice.infraestructure.rest;

import com.example.walletmicroservice.aplication.WalletOperations;
import com.example.walletmicroservice.domain.Wallet;
import com.example.walletmicroservice.utils.Status;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {
 Logger logger = LoggerFactory.getLogger(WalletController.class);
    private final WalletOperations operations;

    @GetMapping
    public Flux<Wallet> listAll() {
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<Wallet> get(@PathVariable("id") String id) {
        return operations.get(id);
    }

    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody Wallet wallet) {
        return operations.create(wallet).flatMap(pR -> {
            if (pR.getStatus() == Status.OK) {
                return Mono.just(new ResponseEntity(pR.getData(), HttpStatus.OK));
            } else {
                return Mono.just(new ResponseEntity(pR.getMessage(), HttpStatus.BAD_REQUEST));
            }
        });
    }

    @PutMapping("/{id}")
    public Mono<Wallet> update(@PathVariable("id") String id, @RequestBody Wallet wallet) {
        return operations.update(id, wallet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        operations.delete(id);
    }
}
