import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	
	// Construtor
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		listaVeiculos = new ArrayList<Veiculo>();
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

	public boolean cadastrarVeiculo(Veiculo veiculo){
		return true;
	}

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Lista de Veículos =" + listaVeiculos;
	} 
}
