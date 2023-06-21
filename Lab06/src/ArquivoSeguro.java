import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoSeguro implements I_Arquivo<Seguro> {

    String csvSeguros = null;

    @Override
    public Boolean gravarArquivo(Seguro seguro) {

        String lista_sinistros = "";
        for (int i = 0; i < seguro.getListaSinistros().size(); i++) {
            lista_sinistros += Integer.toString(seguro.getListaSinistros().get(i).getId()) + ",";
        }

        String lista_condutores = "";
        for (int i = 0; i < seguro.getListaCondutores().size(); i++) {
            lista_condutores += seguro.getListaCondutores().get(i).getCpf();
        }

        String segg = Integer.toString(seguro.getId()) + ", " + seguro.getDataInicio().toString() + ", " +
                seguro.getDataFim().toString() + ", " +
                seguro.getSeguradora().getNome() + ", \"" + lista_sinistros + "\", \"" + lista_condutores + "\", " +
                Double.toString(seguro.getValorMensal()) + "\n";

        try {
            File file = new File("lab06-seguradora_arquivos_v2/seguros.csv");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(segg);
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
        String splitBy = ",";
        try {
            File file = new File(csvSeguros);
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
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

}
