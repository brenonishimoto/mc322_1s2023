import java.util.ArrayList;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<Cliente> listaCliente;
	private ArrayList<Seguro> listaSeguros;
	
	// Construtor
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaCliente = new ArrayList<Cliente>();
		listaSeguros = new ArrayList<Seguro>();
	}
	
	// Getters e setters
	public String getCnpj(){
		return cnpj;
	}

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

	public ArrayList<Cliente> getListaCliente(){
		return listaCliente;
	}
	
	public void setListaCliente(ArrayList<Cliente> listaCliente){
		this.listaCliente = listaCliente;
	}
	
	public ArrayList<Seguro> getListaSeguros(){
		return listaSeguros;
	}
	
	public void setListaSeguros(ArrayList<Seguro> listaSeguros){
		this.listaSeguros = listaSeguros;
	}
	
	//Lista os clientes

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
	
	//Gerar Seguro
	
	public boolean gerarSeguro(){
		return true;
	}
	
	//Cancelar Seguro
	
	public boolean cancelarSeguro(){
		return true;
	}
	
	// Cadastrar Cliente
	
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
	
	//Encontra um Cliente
	
	public Cliente encontrarCliente(String cpf_cnpj){
		for(int i = 0; i < listaCliente.size();i++){
			if(listaCliente.get(i).getCadastro().equals(cpf_cnpj)){
				return listaCliente.get(i);
			}
		}
		System.out.println("O Cliente não está cadastrado.");
		return null;
	}

	//Remove cliente dado um cpf/cnpj

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
	
	//Encontra o Sinistro
	
	public Sinistro encontrarSinistro(int id){
		for(int i = 0; i < listaSinistro.size();i++){
			if(listaSinistro.get(i).getId() == id){
				return listaSinistro.get(i);
			}else{
				System.out.println("O Sinistro não foi encontrado.");
			}
		}
		return null;
	}

	// Retornar lista de seguros por Cliente
	public ArrayList<Seguro> getSegurosPorCliente(){
		return null;
	}
	
	//Retorna lista de Sinistros por Cliente
	public ArrayList<Sinistro> getSinistrosPorCliente(){
		return null;
	}
	
	//Calcular a receita da Seguradora somando os seguros

	public double calculaReceita(){
		double receita = 0;
		for(int i = 0; i < listaCliente.size();i++){
			receita += listaCliente.get(i).getValorSeguro();
		}
		return receita;
	}
	
	//Adiciona o Sinistro e devolve o id

 	public boolean gerarSinistro(Sinistro sinistro){
		listaSinistro.add(sinistro);
		System.out.println("O Sinistro foi adicionado, o código de Identificação é: " + sinistro.getId());
		return true;
		}

	//Visualiza o Sinistro

	public boolean visualizarSinistro(Sinistro sinistro){
		System.out.println(sinistro.toString());
		return true;
	}

	// Remove o Sinistro

	public void removerSinistro(int id){
		for(int i = 0; i < listaSinistro.size();i++){
			if(listaSinistro.get(i).getId() == id){
				listaSinistro.remove(i);
			}else{
				System.out.println("O Sinistro não foi encontrado.");
			}
		}
	}
	
	//Lista os sinistros

	public boolean listarSinistros(){
		for (int i = 0; i < listaSinistro.size();i++) 
		{ 		      
			System.out.println(listaSinistro.get(i).toString()); 		
		}
		return true;
	}

	//Lista os veiculos

	public void listarVeiculosSeg(){
		for(int i = 0; i < listaCliente.size();i++){
			listaCliente.get(i).listarVeiculos();
			}
		}
	
	//Calcula o preço do seguro de cada cliente e altera o valor do seguro dentro do objeto.

	public double calcularPrecoSeguroCliente(Cliente cliente){
		int contador = 0;
		for (int i =0; i < listaSinistro.size(); i++){
			if (cliente.getNome().equals(listaSinistro.get(i).getCliente().getNome())){
				contador += 1;
			}
		}
		cliente.setValorSeguro(cliente.calculaScore() * (1 + contador));
		double preco_seguro_cliente = cliente.getValorSeguro();
		return preco_seguro_cliente;
	}


	//Função de transferir seguro, copiando a lista no cliente alvo e depois alterando o cliente do Sinistro.

	public void transferirSeguro(String cpf_cnpj_origem, String cpf_cnpj_destino){
		int indice_origem = 0;
		int indice_destino = 0;
		for(int i = 0; i < listaCliente.size();i++){
			if(listaCliente.get(i).getCadastro().equals(cpf_cnpj_origem)){
				indice_origem = i;
			}
			else if (listaCliente.get(i).getCadastro().equals(cpf_cnpj_destino)){
				indice_destino = i;
			}
		}
		listaCliente.get(indice_destino).getListaVeiculos().addAll(listaCliente.get(indice_origem).getListaVeiculos());
		listaCliente.get(indice_origem).getListaVeiculos().clear();
		for(int i = 0; i < listaSinistro.size();i++){
			if(listaSinistro.get(i).getCliente() == listaCliente.get(indice_origem)){
				listaSinistro.get(i).setCliente(listaCliente.get(indice_destino));
			}
		}
		calcularPrecoSeguroCliente(listaCliente.get(indice_destino));
		calcularPrecoSeguroCliente(listaCliente.get(indice_origem));
	}

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Telefone = " + getTelefone() + "\n" +
			"Email = " + getEmail() + "\n" +
			"Endereço = " + getEndereco() + "\n" ;
	} 
}
