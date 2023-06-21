import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoSinistro implements I_Arquivo<Sinistro>{

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
        ArrayList<String[]> listaPF = new ArrayList<String[]>();
        String splitBy =",";
        try{
            File file = new File("lab06-seguradora_arquivos_v2/sinistros.csv");
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
