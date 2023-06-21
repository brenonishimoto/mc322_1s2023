import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoVeiculo implements I_Arquivo<Veiculo>{

    String csvVeiculos = "lab06-seguradora_arquivos_v2/veiculos.csv";

    @Override
    public Boolean gravarArquivo(Veiculo veiculo) {
        String veic = veiculo.getPlaca() + ", " + veiculo.getMarca() + ", " +
                veiculo.getModelo() + ", " + veiculo.getAnoFabricacao() + "\n";

        try {
            File file = new File(csvVeiculos);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(veic);
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
            File file = new File(csvVeiculos);
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
