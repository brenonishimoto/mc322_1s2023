import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

public class ClientePF extends Cliente{
	private String cpf;
	private LocalDate dataNascimento;
	private LocalDate dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	
	// Construtor
	public ClientePF(String nome, String endereco, LocalDate dataLicenca2,
					String educacao, String genero, String classeEconomica,
					ArrayList <Veiculo> listaVeiculos, String cpf, LocalDate dataNascimento2) {
		super(nome, endereco);
		this.cpf = cpf;
		this.dataLicenca = (LocalDate) dataLicenca2;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.dataNascimento = (LocalDate) dataNascimento2;
		listaVeiculos = new ArrayList<Veiculo>();
	}
	
	//Getters e setters	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataLicenca() {
		return dataLicenca;
	}
	
	public void setDataLicenca(LocalDate dataLicenca) {
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
		LocalDate hoje = LocalDate.now();
		int idade = Period.between(dataNascimento, hoje).getYears();
		double total_veiculos = getListaVeiculos().size();

		if (idade >= 18 && idade < 30){
			return CalcSeguro.VALOR_BASE.getCalcSeguro() * CalcSeguro.FATOR_18_30.getCalcSeguro() * total_veiculos;
		}
		else if (idade >= 30 && idade < 60){
			return CalcSeguro.VALOR_BASE.getCalcSeguro() * CalcSeguro.FATOR_30_60.getCalcSeguro() * total_veiculos;
		}
		else if (idade >= 60 && idade < 90){
			return CalcSeguro.VALOR_BASE.getCalcSeguro() * CalcSeguro.FATOR_60_90.getCalcSeguro() * total_veiculos;
		}

		return 0;
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