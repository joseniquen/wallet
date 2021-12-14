package com.bootcamp.wallet.infraestructure.repository;

import com.bootcamp.wallet.application.model.WalletRepository;
import com.bootcamp.wallet.domain.Wallet;
import com.bootcamp.wallet.infraestructure.modelDao.WalletDao;
import com.bootcamp.wallet.spring.config.CacheConfig;
import org.bouncycastle.cms.PasswordRecipientId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class WalletCrudRepository implements WalletRepository {
    @Autowired
    IWalletCrudRepository WalletCrudRepository;

    @Override
    public Mono<Wallet> get(String celular) {
        return WalletCrudRepository.findById(celular).map(this::WalletDaoToWallet);
    }

    @Override
    public Flux<Wallet> listAll() {
        return WalletCrudRepository.findAll().map(this::WalletDaoToWallet);
    }

    @Override
    public Mono<Wallet> listByNroDoc(String nroDoc) {
        return WalletCrudRepository.findAllByNroDoc(nroDoc).map(this::WalletDaoToWallet);

    }

    @Override
    public Mono<Wallet> create(Wallet w) {
        return WalletCrudRepository.save(WalletToWalletDao(w)).map(this::WalletDaoToWallet);
    }

    @Override
    public Mono<Wallet> update(String celular, Wallet w) {
        w.setCelular(celular);;
        return WalletCrudRepository.save(WalletToWalletDao(w)).map(this::WalletDaoToWallet);
    }

    @Override
    public void delete(String celular) {
        WalletCrudRepository.deleteById(celular).subscribe();
    }

    public Wallet WalletDaoToWallet(WalletDao ad) {
        Wallet wallet = new Wallet();
        wallet.setNroDoc(ad.getNroDoc());
        wallet.setCelular(ad.getCelular());
        wallet.setImei(ad.getImei());
        wallet.setCorreo(ad.getCorreo());
        wallet.setSaldo(ad.getSaldo());
        wallet.setAsociadoTarjeta(ad.getAsociadoTarjeta());
        wallet.setNroTarjeta(ad.getNroTarjeta());
        return wallet;

    }
    public WalletDao WalletToWalletDao(Wallet w) {
        WalletDao walletDao = new WalletDao();
        walletDao.setNroDoc(w.getNroDoc());
        walletDao.setCelular(w.getCelular());
        walletDao.setImei(w.getImei());
        walletDao.setCorreo(w.getCorreo());
        walletDao.setSaldo(w.getSaldo());
        walletDao.setAsociadoTarjeta(w.getAsociadoTarjeta());
        walletDao.setNroTarjeta(w.getNroTarjeta());
        return walletDao;
    }
}
