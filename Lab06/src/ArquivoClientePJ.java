import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoClientePJ implements I_Arquivo<ClientePJ>{
    
    String csvPJ = "lab06-seguradora_arquivos_v2/clientesPJ.csv";

    @Override
    public Boolean gravarArquivo(ClientePJ clientePJ) {
        String cliepj =clientePJ.getCnpj() + ", " + clientePJ.getNome() + ", " +
                clientePJ.getTelefone() + ", " + clientePJ.getEndereco() + ", " +
                clientePJ.getEmail() + ", " +  clientePJ.getDataFundacao() + ", " + 
                clientePJ.listaFrotas().get(0).getCode() + "\n";

        try {
            File file = new File(csvPJ);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(cliepj);
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
            File file = new File(csvPJ);
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
