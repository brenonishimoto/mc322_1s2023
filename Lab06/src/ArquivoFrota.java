import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoFrota implements I_Arquivo<Frota>{
    
    String csvFrotas = "lab06-seguradora_arquivos_v2/frotas.csv";


    @Override
    public Boolean gravarArquivo(Frota frota) {
        
        String lista_placas = "";
        for (int i = 0; i < frota.getListaVeiculos().size(); i++) {
            lista_placas += frota.getListaVeiculos().get(i).getPlaca() + ",";
        }

        String frot = frota.getCode() + ", " + lista_placas + "\n";

        try {
            File file = new File(csvFrotas);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(frot);
            fileWriter.close();
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<String[]> lerArquivo() {
        ArrayList<String[]> listaFrota = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File(csvFrotas);
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaFrota.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaFrota;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
