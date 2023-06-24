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
        ArrayList<String[]> listaVeiculos = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File(csvVeiculos);
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaVeiculos.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaVeiculos;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
    
}
