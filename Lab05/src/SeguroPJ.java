import java.time.LocalDate;
import java.time.Period;

public class SeguroPJ extends Seguro{
    private Frota frota;
    private ClientePJ clientePJ;
    

    //Construtor
    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, 
                    Seguradora seguradora, Frota frota,
                    ClientePJ clientePJ) {
        super(dataInicio, dataFim, seguradora);
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
		int anos_pos_fundacao = Period.between(clientePJ.getDataFundacao(), hoje).getYears();
		double total_veiculos = clientePJ.getQtd_veiculos();
        double qtd_sinistros_cliente = clientePJ.getQtd_sinistros_cliente();
        double qtd_sinistros_condutor = Seguro.getQtd_sinistros_condutor();

		return (CalcSeguro.VALOR_BASE.getCalcSeguro() * (10 + (clientePJ.getQtd_funcionarios())/10) * 
                (1 + 1 / (total_veiculos + 2)) * (1 + 1/(anos_pos_fundacao + 2)) *
                (2 + qtd_sinistros_cliente/10) * (5 + qtd_sinistros_condutor/10));
    }

    //Adiciona o Sinistro e devolve o id
    @Override
 	public boolean gerarSinistro(Sinistro sinistro){
		getListaSinistros().add(sinistro);
		System.out.println("O Sinistro foi adicionado, o código de Identificação é: " + sinistro.getId());
		return true;
		}
}