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
	public ClientePJ(String nome, String telefone, String endereco, String email,
					String cnpj, LocalDate dataFundacao) {
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.dataFundacao = (LocalDate) dataFundacao;
		listaFrota = new ArrayList<Frota>();
		qtd_funcionarios = 0;
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

	public boolean cadastrarFrota(Frota frota){
		listaFrota.add(frota);
		return true;
	}

	public boolean atualizarFrota(){
		return true;
	}

	public boolean getVeiculosPorFrota(){
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