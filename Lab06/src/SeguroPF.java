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
        valorMensal = getValorMensal();
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
				System.out.println("O Condutor '" + listaCondutores.get(i).getNome() + "' foi desautorizado.");
				return true;
			}
		}
		System.out.println("O Condutor não está cadastrado.");
		return false;
    }

    @Override
    public boolean autorizarCondutor(Condutor condutor) {
        listaCondutores.add(condutor);
        setQtd_sinistros_condutor();
        System.out.println("O Condutor '" + condutor.getNome() + "' foi autorizado.");
        return true;
    }

    //Método de calculo do Valor. A idade foi calculada por meio da função Period. O número de veiculos
    //foi obtido pelo tamanho da lista de veiculos. A quantidade de sinistros do cliente e a quantidade
    //de sinistros do condutor foram obtidos por contadores que são atualizados na geração dos sinistros,
    //sendo o do condutor atualizado ao solicitar para calcular valor.
    @Override
    public double calcularValor() {
        LocalDate hoje = LocalDate.now();
		int idade = Period.between(clientePF.getDataNascimento(), hoje).getYears();
		double total_veiculos = clientePF.getListaVeiculos().size();
        setQtd_sinistros_condutor();
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

		valorMensal =  CalcSeguro.VALOR_BASE.getCalcSeguro() * fator * (1 + 1/(total_veiculos+2)) * 
                (2 + qtd_sinistros_cliente/10) * (5 + qtd_sinistros_condutor/10);
        
        return valorMensal;
	}

    //Adiciona o Sinistro e devolve o id
    @Override
    public boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro){
		Sinistro sinistro = new Sinistro(data, endereco, condutor, seguro);
        getListaSinistros().add(sinistro);
        clientePF.aumenta_sinistro();
        condutor.getListaSinistros().add(sinistro);
		System.out.println("O Sinistro foi adicionado, o código de Identificação é: " + sinistro.getId());
		return true;
		}
    
    @Override
    public String toString() {
        return "Id = " + getId() + "\n" +
            "Inicio= " + getDataInicio() + "\n" +
            "Fim= " + getDataFim() + "\n" +
            "Seguradora= " + getSeguradora().getNome() + "\n" +
            "Cliente = " + getClientePF().getNome() + "\n" +
            "Veiculo = " + getVeiculo().getPlaca() + "\n" +
            "ValorMensal= " + getValorMensal() ;
    }
}