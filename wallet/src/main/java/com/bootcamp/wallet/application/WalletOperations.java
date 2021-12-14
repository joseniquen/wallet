package com.bootcamp.wallet.application;

import com.bootcamp.wallet.domain.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletOperations {
    public Mono<Wallet> get(String celular);

    public Flux<Wallet> listAll();

    public Mono<Wallet> listByNroDoc(String nroDoc);

    public Mono<Wallet> create(Wallet w);

    public Mono<Wallet> update(String celular, Wallet w);

    public void delete(String celular);
}
