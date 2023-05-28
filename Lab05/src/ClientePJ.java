import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	private ArrayList<Frota> listaFrota;
	private double qtd_funcionarios;
	private double qtd_veiculos;
	private double qtd_sinistros_cliente;	

	// Construtor
	public ClientePJ(String nome, String telefone, String endereco, String email,
					String cnpj,int qtd_funcionarios, LocalDate dataFundacao) {
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.dataFundacao = (LocalDate) dataFundacao;
		this.qtd_funcionarios = qtd_funcionarios;
		listaFrota = new ArrayList<Frota>();
		qtd_veiculos = 0;
		qtd_sinistros_cliente = 0;
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

	public double getQtd_funcionarios(){
		return qtd_funcionarios;
	}

	public void setQtd_funcionarios(double qtd_funcionarios){
		this.qtd_funcionarios = qtd_funcionarios;
	}

	public double getQtd_veiculos(){
		return qtd_veiculos;
	}

	public void setQtd_veiculos(double qtd_veiculos){
		this.qtd_veiculos = qtd_veiculos;
	}

	public double getQtd_sinistros_cliente(){
		return qtd_sinistros_cliente;
	}

	public void setQtd_sinistros_cliente(double qtd_sinistros_cliente){
		this.qtd_sinistros_cliente = qtd_sinistros_cliente;
	}

	public void aumenta_sinistro(){
		qtd_sinistros_cliente += 1;
	}

	public void diminui_sinistro(){
		qtd_sinistros_cliente -= 1;
	}

	@Override
	public String getCadastro(){
		return cnpj;
	}

	public boolean cadastrarFrota(Frota frota){
		listaFrota.add(frota);
		System.out.println("A frota "+ frota.getCode() +" foi cadastrada.");
		return true;
	}

	public boolean atualizarFrota(Scanner scanner){
		System.out.println("Qual frota deseja atualizar?");
        for (int i = 0; i < listaFrotas().size(); i++){
            System.out.println( (i+1) + "." + listaFrotas().get(i).getCode());
        }
        System.out.println("0.Sair");
        int opcao_1 = scanner.nextInt();
        scanner.nextLine();
        if (opcao_1 == 0){
            return false;
        }
		System.out.println("1. Adicionar Veiculo");
		System.out.println("2. Remover Veiculo");
		System.out.println("3. Remover Frota");
		System.out.println("0.Sair");
        int opcao_2 = scanner.nextInt();
        scanner.nextLine();
        if (opcao_2 == 0){
            return false;
        }
		if (opcao_2 == 1){
            System.out.println("Qual a placa do carro?");
            String placa = scanner.nextLine();
            System.out.println("Qual a marca do carro?");
            String marca = scanner.nextLine();
            System.out.println("Qual o modelo do carro?");
            String modelo = scanner.nextLine();
            System.out.println("Qual o ano de Fabricação do carro?");
            int anoFabricacao = scanner.nextInt();
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
            listaFrotas().get(opcao_1 - 1).addVeiculo(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
			qtd_veiculos += 1;
			return true;
        }
		if (opcao_2 == 2){
            System.out.println("Qual a placa do Carro?");
            String placa = scanner.nextLine();
            Veiculo veiculo = listaFrotas().get(opcao_1).encontra_veiculo(placa);
            listaFrotas().get(opcao_1).removeVeiculo(veiculo);
			qtd_veiculos -= 1;
			return true;
        }
		if (opcao_2 == 3){
            listaFrotas().remove(opcao_1 - 1);
			qtd_veiculos -= listaFrotas().get(opcao_1 - 1).getListaVeiculos().size();
			return true;
        }
		return false;
	}

	public boolean getVeiculosPorFrota(Scanner scanner){
		System.out.println("Qual frota deseja ver os veiculos?");
        for (int i = 0; i < listaFrotas().size(); i++){
            System.out.println( (i+1) + "." + listaFrotas().get(i).getCode());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return false;
        }
		System.out.println(listaFrotas().get(opcao - 1).getListaVeiculos());
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