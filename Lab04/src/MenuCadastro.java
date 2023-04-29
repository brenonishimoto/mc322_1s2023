public enum MenuCadastro {
    CLIENTE(1),
    VEICULO(2),
    SEGURADORA(3),
    VOLTAR(4);

    public final int operacao;

    MenuCadastro(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
