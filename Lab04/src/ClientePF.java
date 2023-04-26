import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente{
	private String cpf;
	private Date dataNascimento;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	
	// Construtor
	public ClientePF(String nome, String endereco, java.util.Date dataLicenca2,
					String educacao, String genero, String classeEconomica,
					ArrayList <Veiculo> listaVeiculos, String cpf, java.util.Date dataNascimento2) {
		super(nome, endereco);
		this.cpf = cpf;
		this.dataLicenca = (Date) dataLicenca2;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.dataNascimento = (Date) dataNascimento2;
		listaVeiculos = new ArrayList<Veiculo>();
	}
	
	//Getters e setters	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}
	
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	
	public String getEducacao() {
		return educacao;
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	public double calculaScore(){
		return 1.0;
	}

	@Override
	public String getCadastro(){
		return this.cpf;
	}

	@Override
	public String toString() {
		return "----------------Cliente---------------------- " + "\n" +
			"Nome = " + getNome() + "\n" +
			"Cpf = " + getCpf() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Data Licença = " + getDataLicenca() + "\n" +
			"Data de Nascimento = " + getDataNascimento() + "\n" +
			"Educação = " + getEducacao() + "\n" +
			"Gênero = " + getGenero() + "\n" +
			"Classe = " + getClasseEconomica() + "\n" ;
	} 
}