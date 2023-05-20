import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	private ArrayList<Frota> listaFrota;
	
	// Construtor
	public ClientePJ(String nome, String telefone, String endereco, String email,
					ArrayList <Veiculo> listaVeiculos, String cnpj, 
					LocalDate dataFundacao) {
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.dataFundacao = (LocalDate) dataFundacao;
		listaFrota = new ArrayList<Frota>();
	}
	
	//Getters e setters	
	public String getCnpj() {
		return cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public boolean cadastrarFrota(){
		return true;
	}

	public boolean atualizarFrota(){
		return true;
	}

	public boolean getVeiculosPorFrota(){
		return true;
	}

	public ArrayList<Frota> listaFrotas(){
		return listaFrota;
	}

	@Override
	public String toString() {
		return "------------------Cliente-------------------- " + "\n" +
			"Nome = " + getNome() + "\n" +
			"Cnpj = " + getCnpj() + "\n" +
			"Endereço = " + getEndereco() + "\n" +
			"Data de Fundação = " + getDataFundacao();
	}

}