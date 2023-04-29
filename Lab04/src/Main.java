import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------Menu-----------------");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Gerar Sinistro");
        System.out.println("5 - Transferir Seguro");
        System.out.println("6 - Calcular Receita Seguradora");
        System.out.println("0 - Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        switch(opcao){
            case MenuOperacoes.CADASTRAR.getOperacao():
                System.out.println("1 - Cadastrar Cliente PF/PJ");
                System.out.println("2 - Cadastrar Veículo");
                System.out.println("3 - Cadastrar Seguradora");
                System.out.println("4 - Voltar");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao){
                    case MenuCadastro.CLIENTE.getOperacao():
                    //ALGO
                    case MenuCadastro.VEICULO.getOperacao():
                    //ALGO
                    case MenuCadastro.SEGURADORA.getOperacao():
                    //ALGO
                    case MenuCadastro.VOLTAR.getOperacao():
                    //ALGO
                }
            case MenuOperacoes.LISTAR.getOperacao():
                System.out.println("1 - Listar Cliente (PF/PJ) por Seguradora");
                System.out.println("2 - Listar Sinistro por Seguradora");
                System.out.println("3 - Listar Sinistro por Cliente");
                System.out.println("4 - Listar Veiculo por Cliente");
                System.out.println("5 - Listar Veiculo por Seguradora");
                System.out.println("6 - Voltar");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao){
                    case MenuListar.CLIENTE_POR_SEGURADORA.getOperacao():
                    //ALGO
                    case MenuListar.SINISTRO_POR_SEGURADORA.getOperacao():
                    //ALGO
                    case MenuListar.SINISTRO_POR_CLIENTE.getOperacao():
                    //ALGO
                    case MenuListar.VEICULO_POR_CLIENTE.getOperacao():
                    //ALGO
                    case MenuListar.VEICULO_POR_SEGURADORA.getOperacao():
                    //ALGO
                    case MenuListar.VOLTAR.getOperacao():
                    //ALGO
                }
            case MenuOperacoes.EXCLUIR.getOperacao():
                System.out.println("1 - Excluir Cliente");
                System.out.println("2 - Excluir Veiculo");
                System.out.println("3 - Excluir Sinistro");
                System.out.println("4 - Voltar");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao){
                    case MenuExcluir.CLIENTE.getOperacao():
                    //ALGO
                    case MenuExcluir.VEICULO.getOperacao():
                    //ALGO
                    case MenuExcluir.SINISTRO.getOperacao():
                    //ALGO
                    case MenuExcluir.VOLTAR.getOperacao():
                    //ALGO
                }
            case MenuOperacoes.GERAR_SINISTRO.getOperacao():
                //ALGO
            case MenuOperacoes.TRANSFERIR_SEGURO.getOperacao():   
                //Algo
            case MenuOperacoes.CALCULAR_RECEITA_SEGURO.getOperacao():
                //ALGO
            case MenuOperacoes.SAIR.getOperacao():
                System.exit(0);
            }
    }


    public static void main(String[] args) {
                  
        Scanner scanner = new Scanner(System.in);
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        while (true){
            System.out.println("-----------------Menu-----------------");
            System.out.println("Selecione uma opção:");
            System.out.println("(1) Cadastrar Seguradora");
            System.out.println("(2) Cadastrar Cliente");
            System.out.println("(3) Cadastrar Veiculo");
            System.out.println("(4) Gerar Sinistro");
            System.out.println("(5) Remover Cliente");
            System.out.println("(6) Listar Clientes");
            System.out.println("(7) Visualizar Sinistro");
            System.out.println("(8) Listar Sinistros");
            System.out.println("(9) Listar Veiculos");
            System.out.println("(0) Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao == MenuOperacoes.SAIR){
                System.out.println("Até mais!");
                scanner.close();
                return;
            }

            else if(opcao == 1){
                System.out.println("Nome da Seguradora:");
                String nome = scanner.nextLine();
                System.out.println("Telefone da Seguradora:");
                String telefone = scanner.nextLine();
                System.out.println("E-mail da Seguradora:");
                String email = scanner.nextLine();
                System.out.println("Endereço da Seguradora:");
                String endereco = scanner.nextLine();
                Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
                listaSeguradoras.add(seguradora);
                System.out.println("A seguradora " + seguradora.getNome() + " foi cadastrada!");
            }

            else if(opcao == 2){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.nextLine();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome().equals(nome_seguradora)){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                    
                System.out.println("CPF/CNPJ?");
                String cpf_cnpj = scanner.nextLine();
                cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
                if (cpf_cnpj.length() == 11) {
                    if (ClientePF.validarCPF(cpf_cnpj) == false){
                        System.out.println("Coloque um CPF válido.");
                        break;
                    }
                    System.out.println("Nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Endereço:");
                    String endereco = scanner.nextLine();
                    System.out.println("Data da Licença (XX/XX/XXXX):");
                    String dataLicencaStr = scanner.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataLicenca = formatter.parse(dataLicencaStr);
                    System.out.println("Data de Nascimento (XX/XX/XXXX):");
                    String dataNascimentoStr = scanner.nextLine();
                    Date dataNascimento = formatter.parse(dataNascimentoStr);
                    System.out.println("Nivel de Educação:");
                    String educacao = scanner.nextLine();
                    System.out.println("Genero:");
                    String genero = scanner.nextLine();
                    System.out.println("Classe Econômica:");
                    String classeEconomica = scanner.nextLine();
                    ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
                    Cliente novo_cliente_pf = new ClientePF(nome, endereco, dataLicenca , educacao, genero , classeEconomica, listaVeiculos, cpf_cnpj, dataNascimento);
                    listaSeguradoras.get(posicao).cadastrarCliente(novo_cliente_pf);
                    break;
                }
                if (cpf_cnpj.length() == 14) {
                    if (ClientePJ.validarCNPJ(cpf_cnpj) == false){
                        System.out.println("Coloque um CNPJ válido.");
                        break;
                    }
                    System.out.println("Nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Endereço:");
                    String endereco = scanner.nextLine();
                    System.out.println("Data de Fundação (XX/XX/XXXX):");
                    String dataFundacaoStr = scanner.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataFundacao = formatter.parse(dataFundacaoStr);
                    ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
                    Cliente novo_cliente_pj = new ClientePJ(nome, endereco, listaVeiculos, cpf_cnpj, dataFundacao);
                    listaSeguradoras.get(posicao).cadastrarCliente(novo_cliente_pj);
                }
                else{
                    System.out.println("Coloque um CPF/CNPJ válido.");
                    break;
                }
            }
            }

            else if(opcao == 3){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.nextLine();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome().equals(nome_seguradora)){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                System.out.println("Qual o CPF/CNPJ do Cliente?");
                String cpf_cnpj = scanner.nextLine();
                cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
                Cliente cliente = listaSeguradoras.get(posicao).encontrarCliente(cpf_cnpj);
                if (cliente != null){
                    System.out.println("Qual a placa do carro?");
                    String placa = scanner.nextLine();
                    System.out.println("Qual a marca do carro?");
                    String marca = scanner.nextLine();
                    System.out.println("Qual o modelo do carro?");
                    String modelo = scanner.nextLine();
                    System.out.println("Qual o ano de Fabricação do carro?");
                    int anoFabricacao = scanner.nextInt();
                    Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
                    cliente.cadastrarVeiculo(veiculo);
                    System.out.println("Veículo cadastrado com sucesso!");
                }
                else{
                    System.out.println("Cliente não encontrado!");
                }
            }
            

            else if(opcao == 4){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.nextLine();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome().equals(nome_seguradora)){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                System.out.println("Qual o CPF/CNPJ do Cliente?");
                String cpf_cnpj = scanner.nextLine();
                cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
                Cliente cliente = listaSeguradoras.get(posicao).encontrarCliente(cpf_cnpj);
                if (cliente == null){
                    continue;
                }
                int posicao_placa = 0;
                System.out.println("Qual a placa do carro?");
                String placa = scanner.nextLine();
                for(int j = 0; j < cliente.getListaVeiculos().size();j++){
                    if(cliente.getListaVeiculos().get(j).getPlaca().equals(placa)){
                        posicao_placa = j;
                    }else{
                        System.out.println("O Carro não está cadastrado.");
                        break;
                    }
                }
                System.out.println("Qual a data do acidente?");
                String data = scanner.nextLine();
                System.out.println("Qual o endereço do acidente?");
                String endereco = scanner.nextLine();
                Sinistro sinistro = new Sinistro(data, endereco, listaSeguradoras.get(posicao),
											cliente.getListaVeiculos().get(posicao_placa),
											cliente);
                listaSeguradoras.get(posicao).gerarSinistro(sinistro);
            }

            else if(opcao == 5){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.nextLine();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome().equals(nome_seguradora)){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                System.out.println("Qual o CPF/CNPJ do Cliente?");
                String cpf_cnpj = scanner.nextLine();
                cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
                listaSeguradoras.get(posicao).removerCliente(cpf_cnpj);
            }

            else if(opcao == 6){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.nextLine();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome().equals(nome_seguradora)){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                listaSeguradoras.get(posicao).listarClientes();
            }

            else if(opcao == 7){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.nextLine();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome().equals(nome_seguradora)){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                System.out.println("Qual o id do Sinistro?");
                int id = scanner.nextInt();
                Sinistro sinistro = listaSeguradoras.get(posicao).encontrarSinitro(id);
                listaSeguradoras.get(posicao).visualizarSinistro(sinistro);
            }

            else if(opcao == 8){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.nextLine();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome().equals(nome_seguradora)){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                listaSeguradoras.get(posicao).listarSinistros();
            }

            else if(opcao == 9){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.nextLine();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome().equals(nome_seguradora)){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                System.out.println("Qual o CPF/CNPJ do Cliente?");
                String cpf_cnpj = scanner.nextLine();
                cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
                listaSeguradoras.get(posicao).encontrarCliente(cpf_cnpj).listarVeiculos();
            }
        }
    }
}