package com.bootcamp.wallet.infraestructure.repository;

import com.bootcamp.wallet.infraestructure.modelDao.WalletDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IWalletCrudRepository extends ReactiveCrudRepository<WalletDao,String> {
    Mono<WalletDao> findAllByNroDoc(String nroDoc);
}
