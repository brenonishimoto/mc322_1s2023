public class ClientePF {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Construtor
	public ClientePF(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	//Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public boolean validarCPF() {
		boolean valido = true;
		cpf = this.cpf.replaceAll("[^0-9]", "");
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

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Cpf = " + getCpf() + "\n" +
			"Data de Nascimento = " + getDataNascimento() + "\n" +
			"Idade = " + getIdade() + "\n" +
			"Endereço = " + getEndereco() + "\n";
	} 
}