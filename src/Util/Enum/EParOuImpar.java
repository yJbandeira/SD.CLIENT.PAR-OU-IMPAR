package Util.Enum;

public enum EParOuImpar {
    PAR(1),
    IMPAR(2);

    private final int opcao;

    private EParOuImpar(int opcao) {
        this.opcao = opcao;
    }

    public int getOpcao() {
        return opcao;
    } 

}
