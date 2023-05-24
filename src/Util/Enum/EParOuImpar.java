package Util.Enum;

public enum EParOuImpar {
    PAR("Par"),
    IMPAR("Impar");

    private final String opcao;

    private EParOuImpar(String opcao) {
        this.opcao = opcao;
    }

    public String getOpcao() {
        return opcao;
    }

}
