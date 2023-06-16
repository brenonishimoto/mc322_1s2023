import java.util.ArrayList;

public interface I_Arquivo<T> {
    
    Boolean gravarArquivo(T objeto);

    ArrayList<String[]> lerArquivo();
    
}
