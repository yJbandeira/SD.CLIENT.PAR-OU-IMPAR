package Util.Model;

import java.io.Serializable;

import Util.Enum.EParOuImpar;

public class RequestModel implements Serializable {
    private int tipoJogo, numero;
    private EParOuImpar parImpar;

    public RequestModel(int tipoJogo, int numero, EParOuImpar parImpar) {
        this.tipoJogo = tipoJogo;
        this.numero = numero;
        this.parImpar = parImpar;
    }

    public int getTipoJogo() {
        return tipoJogo;
    }

    public int getNumero() {
        return numero;
    }

    public EParOuImpar getParImpar() {
        return parImpar;
    }
}
