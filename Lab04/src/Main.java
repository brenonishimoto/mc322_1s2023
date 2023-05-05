import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void clear_screen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }
    public static void main(String[] args) throws ParseException {
                 
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        Scanner scanner = new Scanner(System.in);
        while (true){
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
        MenuOperacoes menu_operacoes;
        menu_operacoes = MenuOperacoes.values()[opcao];
        clear_screen();
        switch(menu_operacoes){
            case CADASTRAR:
                Main.cadastro(scanner, listaSeguradoras);
                break;
            case LISTAR:
                Main.listar(scanner,listaSeguradoras);
                break;
            case EXCLUIR:
                Main.excluir(scanner, listaSeguradoras);
                break;
            case GERAR_SINISTRO:
                gerar_sinistro(scanner, listaSeguradoras);
                break;
            case TRANSFERIR_SEGURO:   
                transferir_seguro(scanner, listaSeguradoras);
                break;
            case CALCULAR_RECEITA_SEGURO:
                calcular_receita_seguro(scanner, listaSeguradoras);
                break;
            case SAIR:
                System.out.println("Até mais!");
                scanner.close();
                System.exit(1);
            }
        }
    }
    public static void cadastro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras) throws ParseException{
        System.out.println("1 - Cadastrar Cliente PF/PJ");
        System.out.println("2 - Cadastrar Veículo");
        System.out.println("3 - Cadastrar Seguradora");
        System.out.println("4 - Voltar");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        MenuCadastro menu_cadastro;
        menu_cadastro = MenuCadastro.values()[opcao - 1];
        clear_screen();
        switch(menu_cadastro){
            case CLIENTE:
            cadastrar_cliente(scanner, listaSeguradoras);
            return;
            case VEICULO:
            cadastrar_veiculo(scanner, listaSeguradoras);
            return;
            case SEGURADORA:
            cadastrar_seguradora(scanner, listaSeguradoras);
            return;
            case VOLTAR:
            return;
        }
    }
    public static void listar(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("1 - Listar Cliente (PF/PJ) por Seguradora");
        System.out.println("2 - Listar Sinistro por Seguradora");
        System.out.println("3 - Listar Sinistro por Cliente");
        System.out.println("4 - Listar Veiculo por Cliente");
        System.out.println("5 - Listar Veiculo por Seguradora");
        System.out.println("6 - Voltar");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        MenuListar menu_listar;
        menu_listar = MenuListar.values()[opcao - 1];
        clear_screen();
        switch(menu_listar){
            case CLIENTE_POR_SEGURADORA:
            listar_clientes(scanner, listaSeguradoras);
            return;
            case SINISTRO_POR_SEGURADORA:
            listar_sinistro_seguradora(scanner, listaSeguradoras);
            return;
            case SINISTRO_POR_CLIENTE:
            listar_sinistro(scanner, listaSeguradoras);
            return;
            case VEICULO_POR_CLIENTE:
            listar_veiculos_cliente(scanner, listaSeguradoras);
            return;
            case VEICULO_POR_SEGURADORA:
            listar_veiculos_seguradora(scanner, listaSeguradoras);
            return;
            case VOLTAR:
            return;
        }
    }
    public static void excluir(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("1 - Excluir Cliente");
        System.out.println("2 - Excluir Veiculo");
        System.out.println("3 - Excluir Sinistro");
        System.out.println("4 - Voltar");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        MenuExcluir menu_excluir;
        menu_excluir = MenuExcluir.values()[opcao - 1];
        clear_screen();
        switch(menu_excluir){
            case CLIENTE:
            remover_cliente(scanner, listaSeguradoras);
            return;
            case VEICULO:
            remover_veiculo(scanner, listaSeguradoras);
            return;
            case SINISTRO:
            remover_sinistro(scanner, listaSeguradoras);
            return;
            case VOLTAR:
            return;
        }
    }

    public static void cadastrar_seguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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

    public static void cadastrar_cliente(Scanner scanner, ArrayList<Seguradora> listaSeguradoras) throws ParseException{
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
            if (Validacao.validarCPF(cpf_cnpj) == false){
                System.out.println("Coloque um CPF válido.");
                break;
            }
            System.out.println("Nome:");
            String nome = scanner.nextLine();
            System.out.println("Endereço:");
            String endereco = scanner.nextLine();
            System.out.println("Data da Licença (XX/XX/XXXX):");
            String dataLicencaStr = scanner.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataLicenca = LocalDate.parse(dataLicencaStr, formatador);
            System.out.println("Data de Nascimento (XX/XX/XXXX):");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatador);
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
            if (Validacao.validarCNPJ(cpf_cnpj) == false){
                System.out.println("Coloque um CNPJ válido.");
                break;
            }
            System.out.println("Nome:");
            String nome = scanner.nextLine();
            System.out.println("Endereço:");
            String endereco = scanner.nextLine();
            System.out.println("Número de funcionários:");
            int qtdeFuncionarios = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Data de Fundação (XX/XX/XXXX):");
            String dataFundacaoStr = scanner.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataFundacao = LocalDate.parse(dataFundacaoStr, formatador);
            ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
            Cliente novo_cliente_pj = new ClientePJ(nome, endereco, listaVeiculos, cpf_cnpj, dataFundacao, qtdeFuncionarios);
            listaSeguradoras.get(posicao).cadastrarCliente(novo_cliente_pj);
        }
        else{
            System.out.println("Coloque um CPF/CNPJ válido.");
            break;
        }
    }
    }
    
    public static void cadastrar_veiculo(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
    
    public static void gerar_sinistro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
            return;
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
    
    public static void remover_cliente (Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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

    public static void remover_veiculo (Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
        if (cpf_cnpj.length() == 11){
            Cliente cliente = (ClientePF) listaSeguradoras.get(posicao).encontrarCliente(cpf_cnpj);
            System.out.println("Qual a placa do Carro?");
            String placa = scanner.nextLine();
            cliente.removerVeiculo(placa);
        }
        else if (cpf_cnpj.length() == 14){
            Cliente cliente = (ClientePJ) listaSeguradoras.get(posicao).encontrarCliente(cpf_cnpj);
            System.out.println("Qual a placa do Carro?");
            String placa = scanner.nextLine();
            cliente.removerVeiculo(placa);
        }
    }

    public static void remover_sinistro (Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
        System.out.println("Qual o ID do Sinistro?");
        int id = scanner.nextInt();
        scanner.nextLine();
        listaSeguradoras.get(posicao).removerSinistro(id);
    }

    public static void listar_clientes(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
    
    public static void listar_sinistro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
        Sinistro sinistro = listaSeguradoras.get(posicao).encontrarSinistro(id);
        listaSeguradoras.get(posicao).visualizarSinistro(sinistro);    
    }

    public static void listar_sinistro_seguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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

    public static void listar_veiculos_cliente(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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

    public static void listar_veiculos_seguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
    
        listaSeguradoras.get(posicao).listarVeiculosSeg();    
    }

    public static void calcular_receita_seguro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
    
        listaSeguradoras.get(posicao).calculaReceita();    
    }

    public static void transferir_seguro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
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
        System.out.println("Qual o CPF/CNPJ de origem?");
        String cpf_cnpj_origem = scanner.nextLine();
        cpf_cnpj_origem = cpf_cnpj_origem.replaceAll("[^0-9]", "");
        System.out.println("Qual o CPF/CNPJ de destino?");
        String cpf_cnpj_destino = scanner.nextLine();
        cpf_cnpj_destino = cpf_cnpj_destino.replaceAll("[^0-9]", "");

        listaSeguradoras.get(posicao).transferirSeguro(cpf_cnpj_origem, cpf_cnpj_destino);;    
    }
}