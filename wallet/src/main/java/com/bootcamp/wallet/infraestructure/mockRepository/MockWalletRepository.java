package com.bootcamp.wallet.infraestructure.mockRepository;

import com.bootcamp.wallet.application.model.WalletRepository;
import com.bootcamp.wallet.domain.Wallet;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockWalletRepository implements WalletRepository {

    @Override
    public Mono<Wallet> get(String celular) {
        Wallet w = new Wallet();
        w.setCelular("12312314");
        w.setNroDoc("34984545");
        w.setImei("452412123123");
        w.setCorreo("fweA@gmail.com");
        w.setSaldo(0.0);
        w.setAsociadoTarjeta(false);
        w.setNroTarjeta("");
        return Mono.just(w);
    }

    @Override
    public Flux<Wallet> listAll() {
        List<Wallet> lw = new ArrayList<>();
        Wallet w = new Wallet();
        w.setCelular("CTP");
        w.setNroDoc("34984545");
        w.setImei("CTP");
        w.setCorreo("CTP");
        w.setSaldo(0.0);
        w.setAsociadoTarjeta(false);
        w.setNroTarjeta("");
        lw.add(w);
        return Flux.fromIterable(lw);
    }

    @Override
    public Mono<Wallet> listByNroDoc(String nroDoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mono<Wallet> create(Wallet w) {
        return Mono.just(w);
    }

    @Override
    public Mono<Wallet> update(String nroDoc, Wallet w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }


    @Override
    public void delete(String nroDoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
