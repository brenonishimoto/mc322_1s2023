
public class Sinistro {
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	public static int contador = 1;
	int id;

	// Construtor
	public Sinistro(String data, String endereco) {
		this.id = Sinistro.contador++;
		this.data = data;
		this.endereco = endereco;
	}
	
	//Getters e setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String toString() {
		return "Id = " + getId() + "\n" +
			"Data = " + getData() + "\n" +
			"Endereço = " + getEndereco() + "\n";
	} 
}
