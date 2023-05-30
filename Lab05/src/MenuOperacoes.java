//Enum para criação do menu de operações.
public enum MenuOperacoes {
    SAIR(0),
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SEGURO(4),
    AUTORIZAR_DESAUTORIZAR_CONDUTOR(5),
    ATUALIZAR_FROTA(6),
    GERAR_SINISTRO(7),
    CALCULAR_VALOR_MENSAL_SEGURO(8),
    CALCULAR_RECEITA_SEGURADORA(9);

    public final int operacao;

    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}