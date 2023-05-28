public enum MenuOperacoes {
    SAIR(0),
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    AUTORIZAR_DESAUTORIZAR_CONDUTOR(4),
    ATUALIZAR_FROTA(5),
    GERAR_SINISTRO(6),
    CALCULAR_VALOR_MENSAL_SEGURO(7),
    CALCULAR_RECEITA_SEGURADORA(8);

    public final int operacao;

    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}