import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPJ extends Seguro{
    private Frota frota;
    private ClientePJ clientePJ;

    //Construtor
    public SeguroPJ(int id, LocalDate dataInicio, LocalDate dataFim, 
                    Seguradora seguradora, ArrayList<Sinistro> listaSinistros,
                    ArrayList<Condutor> listaCondutores, int valorMensal, 
                    Frota frota, ClientePJ clientePJ) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.frota = frota;
        this.clientePJ = clientePJ;
    }

    //Getters e Setters
    public Frota getFrota(){
        return frota;
    }

    public void setFrota(Frota frota){
        this.frota = frota;
    }
   
    public ClientePJ getClientePJ(){
        return clientePJ;
    }

    public void setClientePJ(ClientePJ clientePJ){
        this.clientePJ = clientePJ;
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