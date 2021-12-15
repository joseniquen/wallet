package com.example.walletmicroservice.aplication;

import com.example.walletmicroservice.aplication.impl.ResponseService;
import com.example.walletmicroservice.domain.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletOperations {
    public Flux<Wallet> list();

    public Flux<Wallet> listByDocument(String document);

    public Mono<Wallet> get(String person);

    public Mono<ResponseService> create(Wallet person);

    public Mono<Wallet> update(String id, Wallet person);

    public void delete(String id);
}
