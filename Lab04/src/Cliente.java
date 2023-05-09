import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;
	
	// Construtor
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		listaVeiculos = new ArrayList<Veiculo>();
		valorSeguro = 0.0;
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

	public double getValorSeguro() {
		return valorSeguro;
	}
	
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public double calculaScore(){
		return CalcSeguro.VALOR_BASE.getCalcSeguro();
	}

	//Adiciona Veiculo no cliente
	public boolean cadastrarVeiculo(Veiculo veiculo){
			listaVeiculos.add(veiculo);
			return true;
	}
	//Remove veiculo do cliente
	public boolean removerVeiculo(String placa){
		for(int i = 0; i < listaVeiculos.size();i++){
			if(listaVeiculos.get(i).getPlaca().equals(placa)){
				listaVeiculos.remove(i);
				return true;
			}
		}
		System.out.println("O Cliente não está cadastrado.");
		return false;
}

	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}

	//Lista veiculos
	public void listarVeiculos(){
		for (int i = 0; i < listaVeiculos.size();i++) 
		{ 		      
			System.out.println(listaVeiculos.get(i)); 		
		}
	}

	public String getCadastro(){
		return null;
	}

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Lista de Veículos =" + listaVeiculos;
	} 
}
