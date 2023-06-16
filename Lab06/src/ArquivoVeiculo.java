import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoVeiculo implements I_Arquivo<Veiculo>{

    String csvVeiculos = "lab06-seguradora_arquivos_v2/veiculos.csv";

    @Override
    public Boolean gravarArquivo(Veiculo veiculo) {
        return false;
    }

    @Override
    public ArrayList<String[]> lerArquivo() {
        ArrayList<String[]> listaPF = new ArrayList<String[]>();
        String splitBy =",";
        try{
            File file = new File(csvVeiculos);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
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
