import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class SeguroPJ extends Seguro{
    private Frota frota;
    private ClientePJ clientePJ;
    

    //Construtor
    public SeguroPJ(int id, LocalDate dataInicio, LocalDate dataFim, 
                    Seguradora seguradora, int valorMensal, 
                    Frota frota, ClientePJ clientePJ) {
        super(dataInicio, dataFim, seguradora, valorMensal);
        this.frota = frota;
        this.clientePJ = clientePJ;
        listaSinistros = new ArrayList<Sinistro>();
        listaCondutores = new ArrayList<Condutor>();
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
		LocalDate hoje = LocalDate.now();
		int anos_pos_fundacao = Period.between(clientePJ.getDataFundacao(), hoje).getYears();
		double total_veiculos = clientePJ.getQtd_veiculos();
        double qtd_sinistros_cliente = clientePJ.getQtd_sinistros_cliente();
        double qtd_sinistros_condutor = Seguro.getQtd_sinistros_condutor();

		return (CalcSeguro.VALOR_BASE.getCalcSeguro() * (10 + (clientePJ.getQtd_funcionarios())/10) * 
                (1 + 1 / (total_veiculos + 2)) * (1 + 1/(anos_pos_fundacao + 2)) *
                (2 + qtd_sinistros_cliente/10) * (5 + qtd_sinistros_condutor/10));
    }

    @Override
    public boolean gerarSinistro() {
        return true;
    }
}