package Util.Model;

import java.io.Serializable;

import Util.Enum.EParOuImpar;

public class ResponseModel implements Serializable {
    private int numero;
    private String parImpar;
    private boolean vitoria;

    public ResponseModel(int numero, String parImpar, boolean vitoria) {
        this.numero = numero;
        this.parImpar = parImpar;
        this.vitoria = vitoria;
    }

    public int getNumero() {
        return numero;
    }

    public String getParImpar() {
        return parImpar;
    }

    public boolean getVitoria() {
        return vitoria;
    }
}
