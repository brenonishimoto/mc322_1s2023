import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF clientePF;

    //Construtor
    public SeguroPF(int id, LocalDate dataInicio, LocalDate dataFim, 
                    Seguradora seguradora, ArrayList<Sinistro> listaSinistros,
                    ArrayList<Condutor> listaCondutores, int valorMensal, 
                    Veiculo veiculo, ClientePF clientePF) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.veiculo = veiculo;
        this.clientePF = clientePF;
    }

    //Getters e Setters
    public Veiculo getVeiculo(){
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
   
    public ClientePF getClientePF(){
        return clientePF;
    }

    public void setClientePF(ClientePF clientePF){
        this.clientePF = clientePF;
    }

    @Override
    public boolean desautorizarCondutor() {
        return true;
    }

    @Override
    public boolean autorizarCondutor() {
        return true;
    }

    @Override
    public double calcularValor() {
        return 0.0;
    }

    @Override
    public boolean gerarSinistro() {
        return true;
    }
}