//Classe Seguradora com getters, setters e métodos
import java.time.LocalDate;
import java.util.ArrayList;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<Cliente> listaCliente;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Condutor> listaCondutores;

	// Construtor
	//Foi-se criado a lista de Condutores pois imagina-se que um condutor pode participar de seguros diferentes.
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaCliente = new ArrayList<Cliente>();
		listaSeguros = new ArrayList<Seguro>();
		listaCondutores = new ArrayList<Condutor>();
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
	
	//Gerar SeguroPJ
	public boolean gerarSeguroPJ(LocalDate inicio, LocalDate fim, Seguradora seguradora,
								Frota frota, ClientePJ clientePJ){
		SeguroPJ seguro = new SeguroPJ(inicio, fim, seguradora, frota, clientePJ);
		listaSeguros.add(seguro);
		System.out.println("O seguro "+ seguro.getId() +" foi criado.");
		return true;
	}

	//Gerar SeguroPF
	public boolean gerarSeguroPF(LocalDate inicio, LocalDate fim, Seguradora seguradora,
								Veiculo veiculo, ClientePF clientePF){
		SeguroPF seguro = new SeguroPF(inicio, fim, seguradora, veiculo, clientePF);
		listaSeguros.add(seguro);
		System.out.println("O seguro "+ seguro.getId() +" foi criado.");
		return true;
	}
	
	//Cancelar Seguro por id
	public boolean cancelarSeguro(int id){
		for (int i = 0; i<listaSeguros.size();i++){
			if(listaSeguros.get(i).getId() == id){
				listaSeguros.remove(i);
				return true;
			}
		}
		return false;
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
		System.out.println("O Cliente "+ cliente.getNome() +" foi cadastrado.");
		return true;
	}
	
	//Encontra um Cliente pelo seu cpf/cnpj
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

	// Cadastrar Condutor	
	public boolean cadastrarCondutor(Condutor condutor) {
		if (listaCondutores.size() == 0){
			listaCondutores.add(condutor);
			System.out.println("O Condutor "+ condutor.getNome() +" foi cadastrado.");
			return true;
		}

		for(int i = 0; i < listaCondutores.size(); i++){
			if(listaCondutores.get(i).getCadastro().equals(condutor.getCadastro())){
				System.out.println("O Condutor já está cadastrado.");
				return false;
			}
		}
		listaCondutores.add(condutor);
		System.out.println("O Condutor "+ condutor.getNome() +" foi cadastrado.");
		return true;
	}

	//Encontra um Condutor pelo seu cpf
	public Condutor encontrarCondutor(String cpf){
		for(int i = 0; i < listaCondutores.size();i++){
			if(listaCondutores.get(i).getCpf() == cpf){
				return listaCondutores.get(i);
			}else{
				System.out.println("O Condutor não foi encontrado.");
			}
		}
		return null;
	}
	
	//Encontra um Seguro pelo seu id.
	public Seguro encontrarSeguro(int id){
		for(int i = 0; i < listaSeguros.size(); i++){
			if(listaSeguros.get(i).getId() == id){
				return listaSeguros.get(i);
			}
		}
		return null;
	}

	//Encontra um Sinistro pelo seu id
	public Sinistro encontrarSinistro(int id){
		for(int i = 0; i < listaSeguros.size();i++){
			for(int j = 0; j <listaSeguros.get(i).getListaSinistros().size();j++){
				if(listaSeguros.get(i).getListaSinistros().get(j).getId() == id){
					return listaSeguros.get(i).getListaSinistros().get(j);
				}
			}
		}
		System.out.println("O Sinistro não foi encontrado.");
		return null;
	}
	
	// 	 Retornar lista de seguros por Cliente, foi feito downcasting para isso, visto que, existem
	// segurospf e segurospj
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		ArrayList<Seguro> listaSegCliente = new ArrayList<Seguro>();
		for (int i = 0; i < listaSeguros.size(); i++){
			if (listaSeguros.get(i) instanceof SeguroPF){
					if (((SeguroPF)listaSeguros.get(i)).getClientePF().equals(cliente)){
						listaSegCliente.add(listaSeguros.get(i));
					}
			}
			if (listaSeguros.get(i) instanceof SeguroPJ){
					if (((SeguroPJ)listaSeguros.get(i)).getClientePJ().equals(cliente)){
						listaSegCliente.add(listaSeguros.get(i));
				}
			}
		}
		return listaSegCliente;
	}
	
	//	Retorna lista de Sinistros por Cliente. Foi-se utilizado um método semelhante para inicialmente
	//fazer uma lista com apenas os seguros de um cliente e depois adicionou-se todos os sinistros de cada
	//seguro em uma lista unica de sinistros.
	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
		ArrayList<Sinistro> listaSinCliente = new ArrayList<Sinistro>();
		ArrayList<Seguro> listaSegCliente = new ArrayList<Seguro>();
		for (int i = 0; i < listaSeguros.size(); i++){
			if (listaSeguros.get(i) instanceof SeguroPF){
					if (((SeguroPF)listaSeguros.get(i)).getClientePF().equals(cliente)){
						listaSegCliente.add(listaSeguros.get(i));
					}
			}
			if (listaSeguros.get(i) instanceof SeguroPJ){
					if (((SeguroPJ)listaSeguros.get(i)).getClientePJ().equals(cliente)){
						listaSegCliente.add(listaSeguros.get(i));
				}
			}
		}

		for (int j = 0; j < listaSegCliente.size(); j++){
			listaSinCliente.addAll(listaSegCliente.get(j).listaSinistros);
		}

		return listaSinCliente;
	}
	
	//Calcular a receita da Seguradora somando os seguros

	public double calculaReceita(){
		double receita = 0.0;
		for(int i = 0; i < listaSeguros.size();i++){
			receita += listaSeguros.get(i).getValorMensal();
		}
		return receita;
	}

	//Visualiza o Sinistro

	public boolean visualizarSinistro(Sinistro sinistro){
		System.out.println(sinistro.toString());
		return true;
	}

	public String toString() {
		return "Nome = " + getNome() + "\n" +
			"Telefone = " + getTelefone() + "\n" +
			"Email = " + getEmail() + "\n" +
			"Endereço = " + getEndereco() + "\n" ;
	} 
}
