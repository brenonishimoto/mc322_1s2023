public enum MenuListar {
    CLIENTE_POR_SEGURADORA(1),
    SINISTRO_POR_SEGURADORA(2),
    SINISTRO_POR_CLIENTE(3),
    VEICULO_POR_CLIENTE(4),
    VEICULO_POR_SEGURADORA(5),
    VOLTAR(6);
    
    public final int operacao;

    MenuListar(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
