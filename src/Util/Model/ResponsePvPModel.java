package Util.Model;

import java.io.Serializable;

import Util.Enum.EParOuImpar;

public class ResponsePvPModel implements Serializable {
    private int numeroAdversario;
    private String parImparAdversario, mensagem;
    private boolean vitoria;

    public ResponsePvPModel(int numeroAdversario, String parImparAdversario, String mensagem, boolean vitoria) {
        this.numeroAdversario = numeroAdversario;
        this.parImparAdversario = parImparAdversario;
        this.mensagem = mensagem;
        this.vitoria = vitoria;
    }

    public int getNumeroAdversario() {
        return numeroAdversario;
    }

    public String getParImparAdversario() {
        return parImparAdversario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean getVitoria() {
        return vitoria;
    }
}
