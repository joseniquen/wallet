package com.bootcamp.wallet.application.impl;

import com.bootcamp.wallet.application.WalletOperations;
import com.bootcamp.wallet.application.model.WalletRepository;
import com.bootcamp.wallet.domain.Wallet;
import com.bootcamp.wallet.spring.config.CacheConfig;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WalletOperationsImpl implements WalletOperations {

    Logger logger = LoggerFactory.getLogger(WalletOperationsImpl.class);
    private final WalletRepository walletRepository;


    @Override
    public Mono<Wallet> get(String celular) {
        return walletRepository.get(celular);
    }

    @Override
    public Flux<Wallet> listAll() {
        return walletRepository.listAll();
    }

   @Override
    public Mono<Wallet> listByNroDoc(String nroDoc) {
        return walletRepository.listByNroDoc(nroDoc);
    }

    @Override
    public Mono<Wallet> create(Wallet w) {
        return walletRepository.create(w);
    }

    @Override
    public Mono<Wallet> update(String celular, Wallet w) {
        return walletRepository.update(celular,w);
    }


    @Override
    public void delete(String celular) {
        walletRepository.delete(celular);
    }
}
