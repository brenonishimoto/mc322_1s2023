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
        String separador =",";
        try{
            File file = new File(csvPF);
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaPF.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaPF;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
