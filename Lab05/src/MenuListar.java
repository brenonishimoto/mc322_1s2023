public enum MenuListar {
    CLIENTE_POR_SEGURADORA(1),
    SINISTRO_POR_CLIENTE(2),
    VEICULO_POR_CLIENTE(3),
    VOLTAR(4);
    
    public final int operacao;

    MenuListar(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
