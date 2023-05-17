import java.util.ArrayList;

public abstract class Cliente {
	protected String nome;
	protected String telefone;
	protected String endereco;
	protected String email;
	
	// Construtor
	public Cliente(String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	
	//Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public abstract ArrayList<Sinistro> getSinistros();

	public abstract ArrayList<Seguro> getSeguro();

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Endereço = " + getEndereco();
	} 
}
