//Classe filha de Cliente com getters, setters e métodos.

import java.util.ArrayList;
import java.time.LocalDate;

public class ClientePF extends Cliente{
	private String cpf;
	private String genero;
	private String educacao;
	private LocalDate dataNascimento;
	private double qtd_sinistros_cliente;
	private ArrayList<Veiculo> listaVeiculos;
	
	// Construtor
	// Foi-se adicionado a variável qtd_sinistros_cliente para calculo do valor do seguro. 
	public ClientePF(String nome, String telefone, String endereco, String email,
					String educacao, String genero, String cpf,
					LocalDate dataNascimento) {
		super(nome, telefone, endereco, email);
		this.cpf = cpf;
		this.genero = genero;
		this.educacao = educacao;
		this.dataNascimento = (LocalDate) dataNascimento;
		qtd_sinistros_cliente = 0;
		listaVeiculos = new ArrayList<Veiculo>();
	}
	
	//Getters e setters	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEducacao() {
		return educacao;
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getQtd_sinistros_cliente() {
		return qtd_sinistros_cliente;
	}
	
	public void setQtd_sinistros_cliente(double qtd_sinistros_cliente) {
		this.qtd_sinistros_cliente = qtd_sinistros_cliente;
	}

	//Método a ser chamado quando se é adicionado um sinistro ao Cliente (normalmente por meio dos condutores)
	public void aumenta_sinistro(){
		qtd_sinistros_cliente += 1;
	}

	//Método a ser chamado quando se é removido um sinistro ao Cliente (normalmente por meio dos condutores)
	public void diminui_sinistro(){
		qtd_sinistros_cliente -= 1;
	}

	//Método para obtenção do cpf 
	@Override
	public String getCadastro(){
		return cpf;
	}

	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}

	//Cadastramento do Veículo no cliente.
	public boolean cadastrar_veiculo(Veiculo veiculo){
		listaVeiculos.add(veiculo);
		System.out.println("O Veiculo "+ veiculo.getPlaca() +" foi cadastrado.");
		return true;
	}

	//Remoção do veiculo do cliente
	public boolean remover_veiculo(Veiculo veiculo){
		for (int i =0; i<listaVeiculos.size();i++){
			if(listaVeiculos.get(i).equals(veiculo)){
				listaVeiculos.remove(i);
				return true;
			}
		}
		return false;
	}

	//Encontrar um veículo da Array list por meio da placa
	public Veiculo encontra_veiculo(String placa){
		for (int i =0; i<listaVeiculos.size();i++){
			if(listaVeiculos.get(i).getPlaca().equals(placa)){
				return listaVeiculos.get(i);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "----------------Cliente---------------------- " + "\n" +
			"Nome = " + getNome() + "\n" +
			"Cpf = " + getCpf() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Data de Nascimento = " + getDataNascimento() + "\n" +
			"Educação = " + getEducacao() + "\n" +
			"Gênero = " + getGenero() + "\n";
	} 
}