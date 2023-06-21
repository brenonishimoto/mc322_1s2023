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
        ArrayList<String[]> listaPF = new ArrayList<String[]>();
        String splitBy =",";
        try{
            File file = new File(csvCondutores);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            br.readLine();
            while ((line = br.readLine()) != null) {
                tempArr = line.split(splitBy);
                listaPF.add(tempArr);
            }
            br.close();
            return listaPF;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
