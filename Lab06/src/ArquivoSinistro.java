import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoSinistro implements I_Arquivo<Sinistro>{

    public ArquivoSinistro(){
            criarCabecalho();
    }

    String csvSeguros = null;

    public Boolean criarCabecalho(){
            try {
            File file = new File("lab06-seguradora_arquivos_v2/sinistros.csv");
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write("id, data, endereço, condutor, seguro" + "\n");
            fileWriter.close();
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    String csvSinistros = null;

    @Override
    public Boolean gravarArquivo(Sinistro sinistro) {
        
        String sinn = Integer.toString(sinistro.getId()) + ", " + sinistro.getData() + ", " +
                sinistro.getEndereco() + ", " + sinistro.getCondutor().getCpf() + ", " +
                sinistro.getSeguro().getId() + "\n";

        try {
            File file = new File("lab06-seguradora_arquivos_v2/sinistros.csv");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(sinn);
            fileWriter.close();
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<String[]> lerArquivo() {
        ArrayList<String[]> listaSin = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File("lab06-seguradora_arquivos_v2/sinistros.csv");
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaSin.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaSin;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
