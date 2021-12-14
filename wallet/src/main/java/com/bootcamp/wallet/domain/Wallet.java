package com.bootcamp.wallet.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Wallet implements Serializable {
    public String celular;
    public String nroDoc;
    public String Imei;
    public String correo;
    public Double saldo;
    public Boolean asociadoTarjeta;
    public String nroTarjeta;
}
