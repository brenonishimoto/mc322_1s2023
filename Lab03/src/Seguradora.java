import java.util.ArrayList;
import java.util.Scanner;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistro;
	private ArrayList<Cliente> listaCliente;
	
	// Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaSinistro = new ArrayList<Sinistro>();
		listaCliente = new ArrayList<Cliente>();
	}
	
	// Getters e setters
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cliente encontrarCliente(String cliente){
		for(int i = 0; i < listaCliente.size();i++){
			if(listaCliente.get(i).getNome() == cliente){
				return listaCliente.get(i);
			}else{
				System.out.println("O Cliente não está cadastrado.");
			}
		}
		return null;
	}

	public Sinistro encontrarSinitro(int id){
		for(int i = 0; i < listaSinistro.size();i++){
			if(listaSinistro.get(i).getId() == id){
				return listaSinistro.get(i);
			}else{
				System.out.println("O Sinistro não foi encontrado.");
			}
		}
		return null;
	}

	public boolean cadastrarCliente(Cliente cliente) {
		for(int i = 0; i < listaCliente.size();i++){
			if(listaCliente.get(i).getNome() == cliente.getNome()){
				System.out.println("O Cliente já está cadastrado.");
				return false;
			}else{
				listaCliente.add(cliente);
			}
		}
		return true;
	}

	public boolean removerCliente(String cliente){
		for(int i = 0; i < listaCliente.size();i++){
			if(listaCliente.get(i).getNome() == cliente){
				listaCliente.remove(i);
				System.out.println("O Cliente foi removido.");
				return true;
			}else{
				System.out.println("O Cliente não está cadastrado.");
			}
		}
		return false;
	}
 
	public void listarClientes(){
		for (int i = 0; i < listaCliente.size();i++) 
		{ 		      
			System.out.println(listaCliente.get(i)); 		
		}
	}
 
 	public boolean gerarSinistro(Seguradora seguradora){
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Qual o nome do Cliente?");
			String cliente = scanner.next();
			int posicao = 0;
			for(int i = 0; i < listaCliente.size();i++){
				if(listaCliente.get(i).getNome() == cliente){
					posicao = i;
				}else{
					System.out.println("O Cliente não está cadastrado.");
					break;
				}
			}
			int posicao_placa = 0;
			System.out.println("Qual a placa do carro?");
			String placa = scanner.next();
			for(int j = 0; j < listaCliente.get(posicao).getListaVeiculos().size();j++){
				if(listaCliente.get(posicao).getListaVeiculos().get(j).getPlaca() == placa){
					posicao_placa = j;
				}else{
					System.out.println("O Carro não está cadastrado.");
					break;
				}
			}
			System.out.println("Qual a data do acidente?");
			String data = scanner.next();
			System.out.println("Qual o endereço do acidente?");
			String endereco = scanner.next();
			Sinistro sinistro = new Sinistro(data, endereco, seguradora,
											 listaCliente.get(posicao).getListaVeiculos().get(posicao_placa),
											 listaCliente.get(posicao));
			listaSinistro.add(sinistro);
			return true;
		}
	}
 
	public boolean visualizarSinistro(Sinistro sinistro){
		sinistro.toString();
		return true;
	}
 
	public void listarSinistros(){
		for (int i = 0; i < listaSinistro.size();i++) 
		{ 		      
			System.out.println(listaCliente.get(i)); 		
		}
	}

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Telefone = " + getTelefone() + "\n" +
			"Email = " + getEmail() + "\n" +
			"Endereço = " + getEndereco() + "\n";
	} 
}
