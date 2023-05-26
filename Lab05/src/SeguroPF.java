import java.time.LocalDate;
import java.time.Period;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF clientePF;

    //Construtor
    public SeguroPF( LocalDate dataInicio, LocalDate dataFim, 
                    Seguradora seguradora, Veiculo veiculo, 
                    ClientePF clientePF) {
        super(dataInicio, dataFim, seguradora);
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
    public boolean desautorizarCondutor(String cpf) {
        for(int i = 0; i < listaCondutores.size();i++){
			if(listaCondutores.get(i).getCpf().equals(cpf)){
				listaCondutores.remove(i);
				System.out.println("O Condutor foi removido.");
				return true;
			}
		}
		System.out.println("O Condutor não está cadastrado.");
		return false;
    }

    @Override
    public boolean autorizarCondutor(Condutor condutor) {
        listaCondutores.add(condutor);
        return true;
    }

    @Override
    public double calcularValor() {
        LocalDate hoje = LocalDate.now();
		int idade = Period.between(clientePF.getDataNascimento(), hoje).getYears();
		double total_veiculos = clientePF.getListaVeiculos().size();
        double qtd_sinistros_cliente = clientePF.getQtd_sinistros_cliente();
        double qtd_sinistros_condutor = Seguro.getQtd_sinistros_condutor();
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

    //Adiciona o Sinistro e devolve o id
    @Override
 	public boolean gerarSinistro(Sinistro sinistro){
		getListaSinistros().add(sinistro);
		System.out.println("O Sinistro foi adicionado, o código de Identificação é: " + sinistro.getId());
		return true;
		}
}