import java.util.ArrayList;

public interface I_Arquivo<T> {
    
    Boolean gravarArquivo(T objeto);

    ArrayList<String[]> lerArquivo();
    
}

//A função de leitura de arquivo foi baseada no modelo proposto no site "https://www.tutorialspoint.com/how-to-read-the-data-from-a-csv-file-in-java"