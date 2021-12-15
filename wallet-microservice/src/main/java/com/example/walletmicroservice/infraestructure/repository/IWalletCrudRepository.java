package com.example.walletmicroservice.infraestructure.repository;

import com.example.walletmicroservice.infraestructure.modelDao.WalletDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface IWalletCrudRepository extends ReactiveCrudRepository<WalletDao, String> {
    Flux<WalletDao> findAllByDocument(String document);
}
