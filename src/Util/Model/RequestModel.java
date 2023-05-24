package Util.Model;

import java.io.Serializable;

import Util.Enum.EParOuImpar;

public class RequestModel implements Serializable {
    private int numero;
    private EParOuImpar parImpar;

    public RequestModel(int numero, EParOuImpar parImpar) {
        this.numero = numero;
        this.parImpar = parImpar;
    }

    public int getNumero() {
        return numero;
    }

    public EParOuImpar getParImpar() {
        return parImpar;
    }
}
