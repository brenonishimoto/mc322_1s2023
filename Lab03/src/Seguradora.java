import java.util.ArrayList;

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

	public Cliente encontrarCliente(String cpf_cnpj){
		for(int i = 0; i < listaCliente.size();i++){
			if(listaCliente.get(i).getCadastro().equals(cpf_cnpj)){
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
		for(int i = 0; i < listaCliente.size(); i++){
			if(listaCliente.get(i).getCadastro().equals(cliente.getCadastro())){
				System.out.println("O Cliente já está cadastrado.");
				return false;
			}
		}
		listaCliente.add(cliente);
		System.out.println("O Cliente foi cadastrado.");
		return true;
	}

	public boolean removerCliente(String cpf_cnpj){
		for(int i = 0; i < listaCliente.size();i++){
			if(listaCliente.get(i).getNome().equals(cpf_cnpj)){
				listaCliente.remove(i);
				System.out.println("O Cliente foi removido.");
				return true;
			}
		}
		System.out.println("O Cliente não está cadastrado.");
		return false;
	}
 
	public boolean listarClientes(){
		if (listaCliente.size() == 0){
			System.out.println("A lista de clientes está vazia"); 
			return false;
		}
		for (int i = 0; i < listaCliente.size();i++) 
		{ 		      
			System.out.println(listaCliente.get(i).toString()); 		
		}
		return true;
	}

 	public boolean gerarSinistro(Sinistro sinistro){
		listaSinistro.add(sinistro);
		System.out.println("O Sinistro foi adicionado, o código de Identificação é: " + sinistro.getId());
		return true;
		}
 
	public boolean visualizarSinistro(Sinistro sinistro){
		System.out.println(sinistro.toString());
		return true;
	}
 
	public boolean listarSinistros(){
		for (int i = 0; i < listaSinistro.size();i++) 
		{ 		      
			System.out.println(listaSinistro.get(i).toString()); 		
		}
		return true;
	}

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Telefone = " + getTelefone() + "\n" +
			"Email = " + getEmail() + "\n" +
			"Endereço = " + getEndereco() + "\n" ;
	} 
}
