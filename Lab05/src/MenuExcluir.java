public enum MenuExcluir {
    CLIENTE(1),
    VEICULO(2),
    VOLTAR(3);

    public final int operacao;

    MenuExcluir(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
