public class ArquivoSeguro implements I_Arquivo{
    
    @Override
    public Boolean gravarArquivo() {
        return false;
    }

    @Override
    public String lerArquivo() {
        return null;
    }
    
}
