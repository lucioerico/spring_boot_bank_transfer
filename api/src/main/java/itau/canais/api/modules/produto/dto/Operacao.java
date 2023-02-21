package itau.canais.api.modules.produto.dto;

public enum Operacao {
    TED(1),
    DOC(2),
    PIX(3);

    private final int codigo;

    private Operacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}

