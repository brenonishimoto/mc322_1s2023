import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoCondutor implements I_Arquivo<Condutor>{
    
    String csvCondutores = "lab06-seguradora_arquivos_v2/condutores.csv";


    @Override
    public Boolean gravarArquivo(Condutor condutor) {
        String condut =condutor.getCpf() + ", " + condutor.getNome() + ", " +
                condutor.getTelefone() + ", " + condutor.getEndereco() + ", " +
                condutor.getEmail() + ", " + condutor.getDataNasc() + "\n";

        try {
            File file = new File(csvCondutores);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(condut);
            fileWriter.close();
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<String[]> lerArquivo() {
        ArrayList<String[]> listaCond = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File(csvCondutores);
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaCond.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaCond;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
