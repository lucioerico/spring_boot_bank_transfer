package itau.canais.api.modules.produto.dto;

public enum Operacao {
    TED(0),
    DOC(1),
    PIX(2);

    private final int codigo;

    private Operacao(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Operacao fromCodigo(int codigo) {
        for (Operacao operacao : values()) {
            if (operacao.getCodigo() == codigo) {
                return operacao;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
