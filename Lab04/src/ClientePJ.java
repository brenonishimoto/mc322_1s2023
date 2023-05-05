import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	private int qtdeFuncionarios;
	
	// Construtor
	public ClientePJ(String nome, String endereco, 
					ArrayList <Veiculo> listaVeiculos, String cnpj, 
					LocalDate dataFundacao, int qtdeFuncionarios) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = (LocalDate) dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
		listaVeiculos = new ArrayList<Veiculo>();
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

	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}
	
	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
	
	public double calculaScore(){
		return CalcSeguro.VALOR_BASE.getCalcSeguro() * (1 + (getQtdeFuncionarios()/100)) * getListaVeiculos().size();
	}

	@Override
	public String getCadastro(){
		return this.cnpj;
	}

	@Override
	public String toString() {
		return "------------------Cliente-------------------- " + "\n" +
			"Nome = " + getNome() + "\n" +
			"Cnpj = " + getCnpj() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Data de Fundação = " + getDataFundacao() + "\n" +
			"Quantidade de Funcionários = " + getQtdeFuncionarios();
	}  
}