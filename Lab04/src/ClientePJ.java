import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private Date dataFundacao;
	private int qtdeFuncionarios;
	
	// Construtor
	public ClientePJ(String nome, String endereco, 
					ArrayList <Veiculo> listaVeiculos, String cnpj, 
					java.util.Date dataFundacao, int qtdeFuncionarios) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = (Date) dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
		listaVeiculos = new ArrayList<Veiculo>();
	}
	
	//Getters e setters	
	public String getCnpj() {
		return cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}
	
	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
	
	public double calculaScore(){
		return 1.0;
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