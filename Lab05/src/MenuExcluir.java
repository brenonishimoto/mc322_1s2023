//Enum para criação do menu excluir.
public enum MenuExcluir {
    CLIENTE(1),
    VEICULO(2),
    SEGURO(3),
    VOLTAR(4);

    public final int operacao;

    MenuExcluir(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
