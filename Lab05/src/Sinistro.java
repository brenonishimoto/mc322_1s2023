import java.time.LocalDate;

public class Sinistro {
	public static int contador = 1;
	private final int id;
	private LocalDate data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;

	// Construtor
	public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) {
		this.id = Sinistro.contador++;
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}
	
	//Getters e setters
	
	public int getId() {
		return id;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Condutor getCondutor() {
		return condutor;
	}
	
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public Seguro getSeguro() {
		return seguro;
	}
	
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public String toString() {
		return "Id do Sinistro = " + getId() + "\n" +
			"Id do Seguro = " + getSeguro().getId() + "\n" +
			"Data = " + getData() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Condutor : " + "\n" +
			getCondutor().toString() ;
	} 
}
