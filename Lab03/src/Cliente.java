import java.sql.Date;
import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private ArrayList<Veiculo> listaVeiculos[];
	
	// Construtor
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		listaVeiculos = listaVeiculos();
	}
	
	//Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Data da Licença = " + getDataLicenca() + "\n" +
			"Educação = " + getEducacao() + "\n" +
			"Gênero = " + getGenero() + "\n" +
			"Classe Econômica = " + getClasseEconomica() + "\n";
	} 
}
