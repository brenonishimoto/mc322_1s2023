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
        valorMensal = calcularValor();
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

    //Método de calculo do Valor. A idade foi calculada por meio da função Period. O número de funcionários
    //foi fornecido na instanciação, o total de veiculos é um contador que é modificado na instanciação de
    //veiculos, a quantidade de sinistros do cliente é atualizada na instanciação de sinistros e a quantidade
    //de sinistros dos condutores é atualizada para calculo do Valor.
    @Override
    public double calcularValor() {
		LocalDate hoje = LocalDate.now();
		int anos_pos_fundacao = Period.between(clientePJ.getDataFundacao(), hoje).getYears();
		double total_veiculos = clientePJ.getQtd_veiculos();
        double qtd_sinistros_cliente = clientePJ.getQtd_sinistros_cliente();
        setQtd_sinistros_condutor();
        double qtd_sinistros_condutor = getQtd_sinistros_condutor();

		valorMensal = (CalcSeguro.VALOR_BASE.getCalcSeguro() * (10 + (clientePJ.getQtd_funcionarios())/10) * 
                (1 + 1 / (total_veiculos + 2)) * (1 + 1/(anos_pos_fundacao + 2)) *
                (2 + qtd_sinistros_cliente/10) * (5 + qtd_sinistros_condutor/10));
        
        return valorMensal;
    }

    //Adiciona o Sinistro e devolve o id
    @Override
 	public boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro){
		Sinistro sinistro = new Sinistro(data, endereco, condutor, seguro);
        getListaSinistros().add(sinistro);
		clientePJ.aumenta_sinistro();
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
            "Cliente = " + getClientePJ().getNome() + "\n" +
            "Frota = " + getFrota().getCode() + "\n" +
            "ValorMensal= " + getValorMensal() ;
    }
}