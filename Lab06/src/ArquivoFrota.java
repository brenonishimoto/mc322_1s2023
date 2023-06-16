import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoFrota implements I_Arquivo<Frota>{
    
    String csvFrotas = "lab06-seguradora_arquivos_v2/frotas.csv";


    @Override
    public Boolean gravarArquivo(Frota frota) {
        return false;
    }

    @Override
    public ArrayList<String[]> lerArquivo() {
        ArrayList<String[]> listaPF = new ArrayList<String[]>();
        String splitBy =",";
        try{
            File file = new File(csvFrotas);
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
