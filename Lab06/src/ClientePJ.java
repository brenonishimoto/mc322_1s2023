//Classe filha de Cliente com getters, setters e métodos.
import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	private ArrayList<Frota> listaFrota;
	private double qtd_funcionarios;
	private double qtd_veiculos;
	private double qtd_sinistros_cliente;	

	// Construtor
	//	Foi-se adicionado a quantidade de veiculos e a quantidade de sinistros como forma de
	//facilitar o calculo do valor do seguro.
	public ClientePJ(String nome, String telefone, String endereco, String email,
					String cnpj,int qtd_funcionarios, LocalDate dataFundacao) {
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.dataFundacao = (LocalDate) dataFundacao;
		this.qtd_funcionarios = qtd_funcionarios;
		listaFrota = new ArrayList<Frota>();
		qtd_veiculos = 0;
		qtd_sinistros_cliente = 0;
	}
	
	//Getters e setters	
	public String getCnpj() {
		return cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public double getQtd_funcionarios(){
		return qtd_funcionarios;
	}

	public void setQtd_funcionarios(double qtd_funcionarios){
		this.qtd_funcionarios = qtd_funcionarios;
	}

	public double getQtd_veiculos(){
		return qtd_veiculos;
	}

	public void setQtd_veiculos(double qtd_veiculos){
		this.qtd_veiculos = qtd_veiculos;
	}

	public double getQtd_sinistros_cliente(){
		return qtd_sinistros_cliente;
	}

	public void setQtd_sinistros_cliente(double qtd_sinistros_cliente){
		this.qtd_sinistros_cliente = qtd_sinistros_cliente;
	}

	public void aumenta_sinistro(){
		qtd_sinistros_cliente += 1;
	}

	public void diminui_sinistro(){
		qtd_sinistros_cliente -= 1;
	}

	@Override
	public String getCadastro(){
		return cnpj;
	}

	//Método para encontrar frota utilizando o "nome".
	public Frota encontraFrota(String code){
		for (int i = 0; i < listaFrotas().size(); i++){
			if (listaFrotas().get(i).getCode().equals(code)){
				return listaFrotas().get(i);
			}
		}
		return null;
	}

	//Cadastrar uma frota adicionando uma frota a lista de frotas.
	public boolean cadastrarFrota(Frota frota){
		listaFrota.add(frota);
		System.out.println("A frota "+ frota.getCode() +" foi cadastrada no cliente.");
		return true;
	}

	// A função atualizar frota foi dividida em outras 3 com base em suas funções.

	//Adicionar um veiculo a frota e aumenta o contador de veiculos do cliente
	public boolean atualizarFrota_adicionar_veiculo(int id_frota, Veiculo veiculo){
        listaFrotas().get(id_frota - 1).addVeiculo(veiculo);
		qtd_veiculos += 1;
		return true;
	}

	//Remove um veiculo da frota, encontrando-o por meio de um método e diminui o contador de veiculos do cliente.
	public boolean atualizarFrota_remover_veiculo(int id_frota, String placa){
		Veiculo veiculo = listaFrotas().get(id_frota).encontra_veiculo(placa);
		listaFrotas().get(id_frota).removeVeiculo(veiculo);
		qtd_veiculos -= 1;
		return true;
	}
	
	//Remove um frota inteira e remove a quantidade de veiculos do contador.
	public boolean atualizarFrota_remover_frota(int id_frota){
		qtd_veiculos -= listaFrotas().get(id_frota - 1).getListaVeiculos().size();
		listaFrotas().remove(id_frota - 1);
		return true;

	}

	//Imprime todos os veiculos de uma frota específica
	public boolean getVeiculosPorFrota(int indice_frota){
		System.out.println(listaFrotas().get(indice_frota).getListaVeiculos());
		return true;
	}

	public ArrayList<Frota> listaFrotas(){
		return listaFrota;
	}

	@Override
	public String toString() {
		return "------------------Cliente-------------------- " + "\n" +
			"Nome = " + getNome() + "\n" +
			"Cnpj = " + getCnpj() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Data de Fundação = " + getDataFundacao();
	}

}