import java.util.ArrayList;
import java.util.Scanner;

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

	public boolean cadastrarVeiculo(){
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Qual a placa do carro?");
			String placa = scanner.next();
			System.out.println("Qual a marca do carro?");
			String marca = scanner.next();
			System.out.println("Qual o modelo do carro?");
			String modelo = scanner.next();
			System.out.println("Qual o ano de Fabricação do carro?");
			int anoFabricacao = scanner.nextInt();
			Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
			listaVeiculos.add(veiculo);
			return true;
		}
	}

	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}

	public void listarVeiculos(){
		for (int i = 0; i < listaVeiculos.size();i++) 
		{ 		      
			System.out.println(listaVeiculos.get(i)); 		
		}
	}

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Lista de Veículos =" + listaVeiculos;
	} 
}
