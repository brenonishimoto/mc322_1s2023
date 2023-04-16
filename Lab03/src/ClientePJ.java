import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private String cnpj;
	private Date dataFundacao;
	
	// Construtor
	public ClientePJ(String nome, String endereco, 
					ArrayList <Veiculo> listaVeiculos, String cnpj, java.util.Date dataFundacao2) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = (Date) dataFundacao2;
		listaVeiculos = new ArrayList<Veiculo>();
	}
	
	//Getters e setters	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public static boolean validarCNPJ(String cnpj) {
		boolean valido = true;
		cnpj = cnpj.replaceAll("[^0-9]", "");
		if (cnpj.length() != 14) {
			valido = false;
			return valido;
		}
		int contador = 0;
		for (int i = 0; i < cnpj.length() - 1; i++) {
			if (cnpj.charAt(i) == cnpj.charAt(i+1)) {
				contador ++;
				if (contador == 13){
					valido = false;
					return valido;
				}
			}
		}

		int numero, resto1;
		char digito1;
		int soma1 = 0;
		int peso1 = 5;

		for (int i = 0; i < 12; i++){
			numero = (int)(cnpj.charAt(i) - 48);
			soma1 = (soma1) + (numero * peso1);
			peso1 = peso1 - 1 ;
			if (peso1 == 1){
				peso1 = 9;
			}
		}
		resto1 = soma1 % 11;
		if ((resto1 == 0) || (resto1 == 1)){
			digito1 = '0';
		}else {
			digito1 = (char)((11 - resto1) + 48);
		}

		int resto2;
		char digito2;
		int soma2 = 0;
		int peso2 = 6;

		for (int i = 0; i < 13; i++){
			numero = (int)(cnpj.charAt(i) - 48);
			soma2 = (soma2) + (numero * peso2);
			peso2 = peso2 - 1 ;
			if(peso2 == 1){
				peso2 = 9;
			}
		}
		resto2 = soma2 % 11;
		if ((resto2 == 0) || (resto2 == 1)){
			digito2 = '0';
		}else {
			digito2 = (char)((11 - resto2) + 48);
		}

		if ((digito1 == cnpj.charAt(12)) && (digito2 == cnpj.charAt(13))){
			return valido;
		}else {
			valido = false;
			return valido;
		}
	}

	public String toString() {
		return "------------------Cliente-------------------- " + "\n" +
			"Nome = " + getNome() + "\n" +
			"Cnpj = " + getCnpj() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Data de Fundação = " + getDataFundacao();
	} 
}