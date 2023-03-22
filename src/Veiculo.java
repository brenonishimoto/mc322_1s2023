
public class Veiculo {
	private String placa;
	private String carro;
	private String modelo;
	
	// Construtor
	public Veiculo(String placa, String carro, String modelo) {
		this.placa = placa;
		this.carro = carro;
		this.modelo = modelo;
	}

	//Getters e setters
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getCarro() {
		return carro;
	}
	
	public void setCarro(String carro) {
		this.carro = carro;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
