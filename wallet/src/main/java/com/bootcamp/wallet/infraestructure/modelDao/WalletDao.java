package com.bootcamp.wallet.infraestructure.modelDao;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("wallet")
public class WalletDao implements Serializable {

    @Id
    public String celular;
    public String nroDoc;
    public String Imei;
    public String correo;
    public Double saldo;
    public Boolean asociadoTarjeta;
    public String nroTarjeta;
}
