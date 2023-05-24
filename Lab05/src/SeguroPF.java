import java.time.LocalDate;
import java.time.Period;
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
        LocalDate hoje = LocalDate.now();
		int idade = Period.between(clientePF.getDataNascimento(), hoje).getYears();
		double total_veiculos = clientePF.getListaVeiculos().size();
        double qtd_sinistros_cliente = clientePF.getQtd_sinistros_cliente();
        double qtd_sinistros_condutor = listaSinistros.size();
        double fator = 0.0;
		
        if (idade < 30){
		    fator = CalcSeguro.FATOR_MENOR_30.getCalcSeguro();
		}
		else if (idade >= 30 && idade < 60){
			fator = CalcSeguro.FATOR_30_60.getCalcSeguro();
		}
		else if (idade >= 60 && idade < 90){
			fator =  CalcSeguro.FATOR_MAIOR_60.getCalcSeguro();
		}

		return CalcSeguro.VALOR_BASE.getCalcSeguro() * fator * (1 + 1/(total_veiculos+2)) * 
                (2 + qtd_sinistros_cliente/10) * (5 + qtd_sinistros_condutor/10);
	}

    @Override
    public boolean gerarSinistro() {
        return true;
    }
}