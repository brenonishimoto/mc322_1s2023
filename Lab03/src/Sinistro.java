
public class Sinistro {
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	public static int contador = 1;
	int id;

	// Construtor
	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.id = Sinistro.contador++;
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
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

	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String toString() {
		return "Id = " + getId() + "\n" +
			"Data = " + getData() + "\n" +
			"Endereço = " + getEndereco() + "\n";
	} 
}
