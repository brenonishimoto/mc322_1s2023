import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoClientePF implements I_Arquivo<ClientePF>{
    
    String csvPF = "lab06-seguradora_arquivos_v2/clientesPF.csv";

    @Override
    public Boolean gravarArquivo(ClientePF clientePF) {

        String cliepf =clientePF.getCpf() + ", " + clientePF.getNome() + ", " +
                clientePF.getTelefone() + ", " + clientePF.getEndereco() + ", " +
                clientePF.getEmail() + ", " + clientePF.getGenero() + ", " +
                clientePF.getEducacao() + ", " + clientePF.getDataNascimento() + ", " + 
                clientePF.getListaVeiculos().get(0).getPlaca() + "\n";

        try {
            File file = new File(csvPF);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(cliepf);
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
            File file = new File(csvPF);
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
