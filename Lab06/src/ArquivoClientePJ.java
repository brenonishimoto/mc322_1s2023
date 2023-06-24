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
        ArrayList<String[]> listaPJ = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File(csvPJ);
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaPJ.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaPJ;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
