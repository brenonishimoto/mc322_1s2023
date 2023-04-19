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
	
	@Override
	public String getCadastro(){
		return this.cpf;
	}
	
	public static boolean validarCPF(String cpf) {
		boolean valido = true;
		cpf = cpf.replaceAll("[^0-9]", "");
		if (cpf.length() != 11) {
			valido = false;
			return valido;
		}
		int contador = 0;
		for (int i = 0; i < cpf.length() - 1; i++) {
			if (cpf.charAt(i) == cpf.charAt(i+1)) {
				contador ++;
				if (contador == 10){
					valido = false;
					return valido;
				}
			}
		}

		int numero, resto1;
		char digito1;
		int soma1 = 0;
		int peso1 = 10;

		for (int i = 0; i < 9; i++){
			numero = (int)(cpf.charAt(i) - 48);
			soma1 = (soma1) + (numero * peso1);
			peso1 = peso1 - 1 ;
		}
		resto1 = 11 - (soma1 % 11);
		if ((resto1 == 10) || (resto1 == 11)){
			digito1 = '0';
		}else {
			digito1 = (char)(resto1 + 48);
		}

		int resto2;
		char digito2;
		int soma2 = 0;
		int peso2 = 11;

		for (int i = 0; i < 10; i++){
			numero = (int)(cpf.charAt(i) - 48);
			soma2 = (soma2) + (numero * peso2);
			peso2 = peso2 - 1 ;
		}
		resto2 = 11 - (soma2 % 11);
		if ((resto2 == 10) || (resto2 == 11)){
			digito2 = '0';
		}else {
			digito2 = (char)(resto2 + 48);
		}

		if ((digito1 == cpf.charAt(9)) && (digito2 == cpf.charAt(10))){
			return valido;
		}else {
			valido = false;
			return valido;
		}
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