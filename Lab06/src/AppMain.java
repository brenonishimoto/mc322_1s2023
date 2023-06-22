import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
    public static void clear_screen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }
    public static void main(String[] args) throws ParseException {
                 
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        Scanner scanner = new Scanner(System.in);
    
        teste(scanner, listaSeguradoras);

        //Inicio do menu em loop

        while (true){
        System.out.println("-----------------Menu-----------------");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Gerar Seguro");
        System.out.println("5 - Atualizar Frota");
        System.out.println("6 - Autorizar/Desautorizar Condutor em um Seguro");
        System.out.println("7 - Gerar Sinistro");
        System.out.println("8 - Calcular Valor Mensal Seguro");
        System.out.println("9 - Calcular Receita Seguradora");
        System.out.println("10 - Sair e Deletar Seguro.csv e Sinistro.csv");
        System.out.println("0 - Sair");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        MenuOperacoes menu_operacoes;
        menu_operacoes = MenuOperacoes.values()[opcao];
        clear_screen();
        switch(menu_operacoes){
            case CADASTRAR:
                AppMain.cadastro(scanner, listaSeguradoras);
                break;
            case LISTAR:
                AppMain.listar(scanner,listaSeguradoras);
                break;
            case EXCLUIR:
                AppMain.excluir(scanner, listaSeguradoras);
                break;
            case GERAR_SEGURO:
                gerar_seguro(scanner, listaSeguradoras);
                break;
            case AUTORIZAR_DESAUTORIZAR_CONDUTOR:
                autorizar_desautorizar_condutor(scanner, listaSeguradoras);
                break;    
            case ATUALIZAR_FROTA:
                atualizar_frota(scanner, listaSeguradoras);
                break;
            case GERAR_SINISTRO:
                gerar_sinistro(scanner, listaSeguradoras);
                break;
            case CALCULAR_VALOR_MENSAL_SEGURO:
                calcular_valor_mensal(scanner, listaSeguradoras);
                break;
            case CALCULAR_RECEITA_SEGURADORA:
                calcular_receita_seguro(scanner, listaSeguradoras);
                break;
            case SAIR_DELETAR:
                System.out.println("Até mais!");
                
                File file_1 = new File("lab06-seguradora_arquivos_v2/seguros.csv");
                file_1.delete();
                File file_2 = new File("lab06-seguradora_arquivos_v2/sinistros.csv");
                file_2.delete();
                
                scanner.close();
                System.exit(1);
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
        System.out.println("4 - Cadastrar Condutor");
        System.out.println("5 - Cadastrar Frota");
        System.out.println("6 - Voltar");
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
            case CONDUTOR:
            cadastrar_condutor(scanner, listaSeguradoras);
            return;
            case FROTA:
            cadastrar_frota(scanner, listaSeguradoras);
            return;
            case VOLTAR:
            return;
        }
    }
    public static void listar(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("1 - Listar Cliente (PF/PJ) por Seguradora");
        System.out.println("2 - Listar Sinistro por Cliente");
        System.out.println("3 - Listar Seguro por Cliente");
        System.out.println("4 - Listar Veiculo por Cliente");
        System.out.println("5 - Listar Veiculo por Frota");
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
            case SINISTRO_POR_CLIENTE:
            listar_sinistro_por_cliente(scanner, listaSeguradoras);
            return;
            case SEGURO_POR_CLIENTE:
            listar_seguro_por_cliente(scanner, listaSeguradoras);
            return;
            case VEICULO_POR_CLIENTE:
            listar_veiculos_cliente(scanner, listaSeguradoras);
            return;
            case VEICULO_POR_FROTA:
            listar_veiculos_frota(scanner, listaSeguradoras);
            return;
            case VOLTAR:
            return;
        }
    }
    public static void excluir(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("1 - Excluir Cliente");
        System.out.println("2 - Excluir Veiculo");
        System.out.println("3 - Excluir Seguro");
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
            case SEGURO:
            remover_seguro(scanner, listaSeguradoras);
            return;
            case VOLTAR:
            return;
        }
    }

    //Funções do Menu

    //Cadastra Seguradora e adiciona na lista de Seguradoras.
    public static void cadastrar_seguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual o CNPJ da Seguradora:");
        String cnpj = scanner.nextLine();
        if (Validacao.validarCNPJ(cnpj) == false){
            System.out.println("Coloque um CNPJ válido.");
            return;
        }
        System.out.println("Nome da Seguradora:");
        String nome = scanner.nextLine();
        System.out.println("Telefone da Seguradora:");
        String telefone = scanner.nextLine();
        System.out.println("E-mail da Seguradora:");
        String email = scanner.nextLine();
        System.out.println("Endereço da Seguradora:");
        String endereco = scanner.nextLine();
        Seguradora seguradora = new Seguradora(cnpj,nome, telefone, email, endereco);
        listaSeguradoras.add(seguradora);
        System.out.println("A seguradora " + seguradora.getNome() + " foi cadastrada!");
    }

    //Cadastras Cliente, sendo a separação entre PF e PJ com base no tamanho do cpd/cnpj, e adiciona
    //na lista de clientes da seguradora.
    public static void cadastrar_cliente(Scanner scanner, ArrayList<Seguradora> listaSeguradoras) throws ParseException{
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }    
        System.out.println("CPF/CNPJ?");
        String cpf_cnpj = scanner.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
        if (cpf_cnpj.length() == 11) {
            if (Validacao.validarCPF(cpf_cnpj) == false){
                System.out.println("Coloque um CPF válido.");
                return;
            }
            System.out.println("Nome:");
            String nome = scanner.nextLine();
            if(Validacao.validarNome(nome) == false){
                System.out.println("Coloque um Nome válido.");
                return;
            }
            System.out.println("Endereço:");
            String endereco = scanner.nextLine();
            System.out.println("Telefone:");
            String telefone = scanner.nextLine();
            System.out.println("Email:");
            String email = scanner.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("Data de Nascimento (XX/XX/XXXX):");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatador);
            System.out.println("Nivel de Educação:");
            String educacao = scanner.nextLine();
            System.out.println("Genero:");
            String genero = scanner.nextLine();
            Cliente novo_cliente_pf = new ClientePF(nome, telefone, endereco, email, educacao, genero ,cpf_cnpj, dataNascimento);
            listaSeguradoras.get(opcao - 1).cadastrarCliente(novo_cliente_pf);
            return;
        }
        if (cpf_cnpj.length() == 14) {
            if (Validacao.validarCNPJ(cpf_cnpj) == false){
                System.out.println("Coloque um CNPJ válido.");
                return;
            }
            System.out.println("Nome:");
            String nome = scanner.nextLine();
            System.out.println("Telefone:");
            String telefone = scanner.nextLine();
            System.out.println("Endereço:");
            String endereco = scanner.nextLine();
            System.out.println("Email:");
            String email = scanner.nextLine();
            System.out.println("Número de funcionários:");
            int qtdeFuncionarios = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Data de Fundação (XX/XX/XXXX):");
            String dataFundacaoStr = scanner.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataFundacao = LocalDate.parse(dataFundacaoStr, formatador);
            Cliente novo_cliente_pj = new ClientePJ(nome, telefone, endereco, email, cpf_cnpj, qtdeFuncionarios, dataFundacao);
            listaSeguradoras.get(opcao - 1).cadastrarCliente(novo_cliente_pj);
        }
        else{
            System.out.println("Coloque um CPF/CNPJ válido.");
            return;
        }
    }

    //Cadastra um veiculo, se for PF adiciona na lista de veiculos do cliente, se for PJ,
    //pergunta-se qual a frota e adiciona o veiculo na frota. Para Clientes PJ a função é
    //duplicado pois o atualiza frota também pode adicionar veiculos.
    public static void cadastrar_veiculo(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CPF/CNPJ do Cliente?");
        String cpf_cnpj = scanner.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
        Cliente cliente = listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
        if (cliente != null && cpf_cnpj.length() == 11){
            ClientePF clientePF = (ClientePF) cliente;
            System.out.println("Qual a placa do carro?");
            String placa = scanner.nextLine();
            System.out.println("Qual a marca do carro?");
            String marca = scanner.nextLine();
            System.out.println("Qual o modelo do carro?");
            String modelo = scanner.nextLine();
            System.out.println("Qual o ano de Fabricação do carro?");
            int anoFabricacao = scanner.nextInt();
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
            clientePF.cadastrar_veiculo(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        }
        if (cliente != null && cpf_cnpj.length() == 14){
            ClientePJ clientePJ = (ClientePJ) cliente;
            System.out.println("Qual a frota?");
                for (int i = 0; i < clientePJ.listaFrotas().size(); i++){
                    System.out.println( (i+1) + "." + clientePJ.listaFrotas().get(i).getCode());
                }
                System.out.println("0.Sair");
                int opcao_frota = scanner.nextInt();
                scanner.nextLine();
                if (opcao_frota == 0){
                    return;
                }
            System.out.println("Qual a placa do carro?");
            String placa = scanner.nextLine();
            System.out.println("Qual a marca do carro?");
            String marca = scanner.nextLine();
            System.out.println("Qual o modelo do carro?");
            String modelo = scanner.nextLine();
            System.out.println("Qual o ano de Fabricação do carro?");
            int anoFabricacao = scanner.nextInt();
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
            clientePJ.listaFrotas().get(opcao_frota-1).addVeiculo(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        }
        else{
            System.out.println("Cliente não encontrado!");
        }    
    }
    
    //Cadastra um condutor e adiciona-o na lista de condutores da Seguradora.
    public static void cadastrar_condutor(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }    
        System.out.println("Qual o cpf?");
        String cpf = scanner.nextLine();
        cpf = cpf.replaceAll("[^0-9]", "");
        
        if (Validacao.validarCPF(cpf) == false){
            System.out.println("Coloque um CPF válido.");
            return;
        }
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        if(Validacao.validarNome(nome) == false){
            System.out.println("Coloque um Nome válido.");
            return;
        }
        System.out.println("Endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Data de Nascimento (XX/XX/XXXX):");
        String dataNascimentoStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatador);
        Condutor condutor = new Condutor(cpf, nome, telefone, endereco, email, dataNascimento);
        listaSeguradoras.get(opcao - 1).cadastrarCondutor(condutor);
        return;
    }

    //Cadastra uma frota, pergunta o CNPJ pois frota esta ligado a clientePJ.
    public static void cadastrar_frota(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CNPJ do Cliente?");
        String cnpj = scanner.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]", "");
        ClientePJ clientePJ = (ClientePJ) listaSeguradoras.get(opcao - 1).encontrarCliente(cnpj);
        System.out.println("Qual o nome da Frota?");
        String code = scanner.nextLine();
        Frota frota = new Frota(code);
        clientePJ.cadastrarFrota(frota);
    }

    //Método para gerar seguro, separa-se em PJ e PF pela quantidade de numeros
    //e adiciona-se a lista de Seguros.
    public static void gerar_seguro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CPF/CNPJ do Cliente?");
        String cpf_cnpj = scanner.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
        Cliente cliente = listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
        if (cliente == null){
            return;
        }
        else if(cliente != null && cpf_cnpj.length() == 11){
            ClientePF clientePF = (ClientePF) cliente;
            System.out.println("Quando se inicia o seguro (XX/XX/XXXX)?");
            String inicioStr = scanner.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inicio = LocalDate.parse(inicioStr, formatador);
            System.out.println("Quando se encerra o seguro (XX/XX/XXXX)?");
            String fimStr = scanner.nextLine();
            LocalDate fim = LocalDate.parse(fimStr, formatador);
            System.out.println("Qual a placa do veiculo a ser segurado?");
            String placa = scanner.nextLine();
            listaSeguradoras.get(opcao - 1).gerarSeguroPF(inicio, fim,listaSeguradoras.get(opcao - 1) ,clientePF.encontra_veiculo(placa), clientePF);
        }
        else if(cliente != null && cpf_cnpj.length() == 14){
            ClientePJ clientePJ = (ClientePJ) cliente;
            System.out.println("Quando se inicia o seguro (XX/XX/XXXX)?");
            String inicioStr = scanner.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inicio = LocalDate.parse(inicioStr, formatador);
            System.out.println("Quando se encerra o seguro (XX/XX/XXXX)?");
            String fimStr = scanner.nextLine();
            LocalDate fim = LocalDate.parse(fimStr, formatador);
            System.out.println("Qual o ID da frota?");
            String id = scanner.nextLine();
            listaSeguradoras.get(opcao - 1).gerarSeguroPJ(inicio, fim,listaSeguradoras.get(opcao - 1) ,clientePJ.encontraFrota(id) , clientePJ);
        }
    } 

    //Menu de atualizar frota, com possibilidade de adicionar e remover veiculo e remover frota.  
    public static void atualizar_frota(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CNPJ do Cliente?");
        String cnpj = scanner.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]", "");
        ClientePJ clientePJ = (ClientePJ) listaSeguradoras.get(opcao - 1).encontrarCliente(cnpj);
        if (clientePJ == null){
            return;
        }
        else if (clientePJ != null){
            System.out.println("Qual frota deseja atualizar?");
            for (int i = 0; i < clientePJ.listaFrotas().size(); i++){
                System.out.println( (i+1) + "." + clientePJ.listaFrotas().get(i).getCode());
            }
            System.out.println("0.Sair");
            int opcao_1 = scanner.nextInt();
            scanner.nextLine();
            if (opcao_1 == 0){
                return;
            }
            System.out.println("1. Adicionar Veiculo");
            System.out.println("2. Remover Veiculo");
            System.out.println("3. Remover Frota");
            System.out.println("0. Sair");
            int opcao_2 = scanner.nextInt();
            scanner.nextLine();
            if (opcao_2 == 0){
                return;
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
                clientePJ.atualizarFrota_adicionar_veiculo(opcao_1, veiculo);
            }
            if (opcao_2 == 2){
                System.out.println("Qual a placa do Carro?");
                String placa = scanner.nextLine();
                clientePJ.atualizarFrota_remover_veiculo(opcao_1, placa);
            }
            if (opcao_2 == 3){
                clientePJ.atualizarFrota_remover_frota(opcao_1);
            }
        }
    }

    // Gera um Sinistro, faz-se uma serie de perguntas para identificação do seguro e condutor
    //relacionados ao sinistro. 
    public static void gerar_sinistro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CPF/CNPJ do Cliente?");
        String cpf_cnpj = scanner.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
        Cliente cliente = listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
        if (cliente == null){
            return;
        }
        else if(cliente != null && cpf_cnpj.length() == 11){
            System.out.println("Qual o cpf do condutor?");
            String cpf = scanner.nextLine();
            Condutor condutor = listaSeguradoras.get(opcao - 1).encontrarCondutor(cpf);
            if (condutor == null){
                return;
            }
            System.out.println("Qual o id do seguro?");
            int id = scanner.nextInt();
            scanner.nextLine();
            Seguro seguro = listaSeguradoras.get(opcao - 1).encontrarSeguro(id);
            if (seguro == null){
                return;
            }
            SeguroPF seguroPF = (SeguroPF) seguro;
            System.out.println("Qual a data do acidente?");
            String dataStr = scanner.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataStr, formatador);
            System.out.println("Qual o endereço do acidente?");
            String endereco = scanner.nextLine();
            seguroPF.gerarSinistro(data, endereco, condutor, seguroPF);
        }
        else if(cliente != null && cpf_cnpj.length() == 14){
            System.out.println("Qual o cpf do condutor?");
            String cpf = scanner.nextLine();
            Condutor condutor = listaSeguradoras.get(opcao - 1).encontrarCondutor(cpf);
            if (condutor == null){
                return;
            }
            System.out.println("Qual o id do seguro?");
            int id = scanner.nextInt();
            scanner.nextLine();
            Seguro seguro = listaSeguradoras.get(opcao - 1).encontrarSeguro(id);
            if (seguro == null){
                return;
            }
            SeguroPJ seguroPJ = (SeguroPJ) seguro;
            System.out.println("Qual a data do acidente?");
            String dataStr = scanner.nextLine();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataStr, formatador);
            System.out.println("Qual o endereço do acidente?");
            String endereco = scanner.nextLine();
            seguroPJ.gerarSinistro(data, endereco, condutor, seguroPJ);
        }
    } 
    
    //Remove um cliente da lista de clientes.
    public static void remover_cliente (Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CPF/CNPJ do Cliente?");
        String cpf_cnpj = scanner.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
        listaSeguradoras.get(opcao - 1).removerCliente(cpf_cnpj);    
    }

    //Remove um veiculo. Identifica-se se é PF ou PJ pela quantidade de numeros do registro
    //Se for PF remove direto da lista, se for PJ identifica a frota e remove o veiculo.
    public static void remover_veiculo (Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CPF/CNPJ do Cliente?");
        String cpf_cnpj = scanner.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
        if (cpf_cnpj.length() == 11){
            ClientePF clientePF = (ClientePF) listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
            System.out.println("Qual a placa do Carro?");
            String placa = scanner.nextLine();
            Veiculo veiculo = clientePF.encontra_veiculo(placa);
            ArrayList<Seguro> listaSegCliente = listaSeguradoras.get(opcao - 1).getSegurosPorCliente(clientePF);
            for(int i = 0; i < listaSegCliente.size();i++){
                if (listaSegCliente.get(i) instanceof SeguroPF){
                    for(Seguro seguroPF  : listaSegCliente){
                        if (((SeguroPF)seguroPF).getVeiculo().equals(veiculo)){
                            int id = seguroPF.getId();
                            listaSeguradoras.get(opcao - 1).cancelarSeguro(id);
                        }
                    }
                }
            clientePF.remover_veiculo(veiculo);
            }
        }
        else if (cpf_cnpj.length() == 14){
            ClientePJ clientePJ = (ClientePJ) listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
            System.out.println("Qual a placa do Carro?");
            String placa = scanner.nextLine();
            System.out.println("Qual a Frota do Carro?");
            String frotaStr = scanner.nextLine();
            Frota frota = null;
            for(int i = 0; i < clientePJ.listaFrotas().size();i++){
                if (clientePJ.listaFrotas().get(i).getCode().equals(frotaStr)){
                    frota = clientePJ.listaFrotas().get(i);
                }
            }
            Veiculo veiculo = frota.encontra_veiculo(placa);
            frota.removeVeiculo(veiculo);
            }
        }

    //Remmove um seguro da lista de seguros.
    public static void remover_seguro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o ID do Seguro?");
        int id = scanner.nextInt();
        scanner.nextLine();
        listaSeguradoras.get(opcao - 1).cancelarSeguro(id);    
    }

    //Adiciona e remove um condutor da lista de um seguro.
    public static void autorizar_desautorizar_condutor(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o ID do Seguro?");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual o cpf do Condutor?");
        String cpf = scanner.nextLine();
        System.out.println("1. Autorizar condutor");
        System.out.println("2. Desautorizar condutor");
        System.out.println("0.Sair");
        int opcao_2 = scanner.nextInt();
        scanner.nextLine();
        if (opcao_2 == 0){
            return;
        }
        if (opcao_2 == 1){
            listaSeguradoras.get(opcao - 1).encontrarSeguro(id).autorizarCondutor(listaSeguradoras.get(opcao -1).encontrarCondutor(cpf));
        }
        if (opcao_2 == 2){
            listaSeguradoras.get(opcao - 1).encontrarSeguro(id).desautorizarCondutor(cpf);
        }
    }

    //Lista os clientes de uma seguradora
    public static void listar_clientes(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        listaSeguradoras.get(opcao - 1).listarClientes();    
    }
    
    //Lista os sinistro de um cliente
    public static void listar_sinistro_por_cliente(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o cpf/cnpj do Cliente?");
        String cpf_cnpj = scanner.nextLine();
        Cliente cliente = listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
        System.out.println(listaSeguradoras.get(opcao - 1).getSinistrosPorCliente(cliente));
    }

    //Lista os Seguros de um cliente
    public static void listar_seguro_por_cliente(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o cpf/cnpj do Cliente?");
        String cpf_cnpj = scanner.nextLine();
        Cliente cliente = listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
        System.out.println(listaSeguradoras.get(opcao - 1).getSegurosPorCliente(cliente));
    }

    //Lista os veiculos de um cliente
    public static void listar_veiculos_cliente(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CPF/CNPJ do Cliente?");
        String cpf_cnpj = scanner.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
        if (cpf_cnpj.length() == 11){
            ClientePF clientePF = (ClientePF) listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
            System.out.println(clientePF.getListaVeiculos());
            }
        else if (cpf_cnpj.length() == 14){
            ClientePJ clientePJ = (ClientePJ) listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
            for (int i = 0; i < clientePJ.listaFrotas().size(); i++ ){
                System.out.println(clientePJ.listaFrotas().get(i).getListaVeiculos());
                }
            }   
    }

    //Lista os veiculos de uma frota.
    public static void listar_veiculos_frota(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o CNPJ do Cliente?");
        String cnpj = scanner.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]", "");
        ClientePJ clientePJ = (ClientePJ) listaSeguradoras.get(opcao - 1).encontrarCliente(cnpj);
        System.out.println("Qual frota deseja ver os veiculos?");
        for (int i = 0; i < clientePJ.listaFrotas().size(); i++){
            System.out.println( (i+1) + "." + clientePJ.listaFrotas().get(i).getCode());
        }
        System.out.println("0.Sair");
        int opcao_2 = scanner.nextInt();
        scanner.nextLine();
        if (opcao_2 == 0){
            return;
        }
        clientePJ.getVeiculosPorFrota(opcao_2 - 1);
    }

    //Calcula o valor de um Seguro
    public static void calcular_valor_mensal(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        System.out.println("Qual o ID do Seguro?");
        int id = scanner.nextInt();
        scanner.nextLine();
        listaSeguradoras.get(opcao - 1).encontrarSeguro(id).calcularValor();
        
        System.out.printf( "R$ %.2f \n", listaSeguradoras.get(opcao - 1).encontrarSeguro(id).getValorMensal());
    }

    // Calcula a receita de uma seguradora. Itera-se o valor
    public static void calcular_receita_seguro(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        System.out.println("Qual seguradora o cliente pertence?");
        for (int i = 0; i < listaSeguradoras.size(); i++){
            System.out.println( (i+1) + "." + listaSeguradoras.get(i).getNome());
        }
        System.out.println("0.Sair");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 0){
            return;
        }
        double receita = listaSeguradoras.get(opcao - 1).calculaReceita();
        System.out.printf( "R$ %.2f \n", receita);
    }

    // Instanciação de teste
    public static void teste(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
        // Instanciação e chamada de métodos

        System.out.println("-----------------Instanciamento de Seguradora-----------------");
        Seguradora seguradora_1 = new Seguradora("15.693.842/0001-43", "Seguradora 1", "(19)40028922", "seguradora1@gmail.com", "Rua da Seguradora 1");
        listaSeguradoras.add(seguradora_1);
        System.out.println("A seguradora '" + seguradora_1.getNome() + "' foi adicionada!");
        
        System.out.println("-----------------Instanciamento de Cliente PF-----------------");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataNascimentoStr = "1990-12-12";
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatador);
        String cpf = "645.787.838-55";
        cpf = cpf.replaceAll("[^0-9]", "");
        if (Validacao.validarCPF(cpf) == false){
            System.out.println("Coloque um CPF válido.");
            scanner.close();
            System.exit(1);
        }
        String nome_1 = "Guilherme";
        if(Validacao.validarNome(nome_1) == false){
            System.out.println("Coloque um Nome válido.");
            scanner.close();
            System.exit(1);
        }
        ClientePF cliente_pf_1 = new ClientePF(nome_1, "(71)3244-0891","Rua do Guilherme", "guilherme@gmail.com", "Ensino Superior" , "Masculino", cpf, dataNascimento);
        listaSeguradoras.get(0).cadastrarCliente(cliente_pf_1);
        
        System.out.println("-----------------Instanciamento de Cliente PJ-----------------");
        String dataFundacaoStr = "2012-04-13";
        LocalDate dataFundacao = LocalDate.parse(dataFundacaoStr, formatador);
        String cnpj = "15.409.786/0001-72";
        cnpj = cnpj.replaceAll("[^0-9]", "");
        if (Validacao.validarCNPJ(cnpj) == false){
            System.out.println("Coloque um CPF válido.");
            scanner.close();
            System.exit(1);
        }
        String nome_2 = "Rito Gomes";
        ClientePJ cliente_pj_1 = new ClientePJ(nome_2,"(19)3521-5841", "Rua da Rito Gomes", "ritogomes@gmail.com",cnpj ,1000, dataFundacao);
        listaSeguradoras.get(0).cadastrarCliente(cliente_pj_1);

        System.out.println("-----------------Instanciamento de Frota-----------------");
        Frota frota_1 = new Frota("Frota 1");
        cliente_pj_1.cadastrarFrota(frota_1);
        
        System.out.println("-----------------Instanciamento do Veiculo no ClientePF-----------------");
        Veiculo veiculo_1 = new Veiculo("BRA2E19", "Chevrolet", "Celta", 2015);
        cliente_pf_1.cadastrar_veiculo(veiculo_1);
        
        System.out.println("-----------------Instanciamento do Veiculo na Frota do ClientePJ-----------------");
        Veiculo veiculo_2 = new Veiculo("RIO2A18", "Ford", "Focus", 2019);
        cliente_pj_1.atualizarFrota_adicionar_veiculo(1, veiculo_2);
        
        String dataInicioStr = "2010-01-01";
        LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatador);
        String dataFimStr = "2010-12-31";
        LocalDate dataFim = LocalDate.parse(dataFimStr, formatador);
        
        System.out.println("-----------------Instanciamento do SeguroPJ -----------------");
        listaSeguradoras.get(0).gerarSeguroPJ(dataInicio, dataFim, seguradora_1, frota_1, cliente_pj_1);
        SeguroPJ seguropj_1 = (SeguroPJ) listaSeguradoras.get(0).encontrarSeguro(1);
        
        System.out.println("-----------------Instanciamento do SeguroPF -----------------");
        listaSeguradoras.get(0).gerarSeguroPF(dataInicio, dataFim, seguradora_1, veiculo_1, cliente_pf_1);
        SeguroPF seguropf_1 = (SeguroPF) listaSeguradoras.get(0).encontrarSeguro(2);
        
        
        System.out.println("-----------------Instanciamento do Condutor (SeguroPF)-----------------");
        Condutor condutor_1 = new Condutor("71356301657", "João", "(11)1111-1111","Rua do João", "joao@gmail.com", dataNascimento);
        listaSeguradoras.get(0).cadastrarCondutor(condutor_1);
        seguropf_1.autorizarCondutor(condutor_1);
        
        System.out.println("-----------------Instanciamento do Condutor (SeguroPJ)-----------------");
        Condutor condutor_2 = new Condutor("21892605074", "Maria", "(22)2222-2222","Rua da Maria", "maria@gmail.com", dataNascimento);
        listaSeguradoras.get(0).cadastrarCondutor(condutor_2);
        seguropj_1.autorizarCondutor(condutor_2);
        
        System.out.println("-----------------Instanciamento do Sinistro PF-----------------");
        String dataSinistroStr = "2010-05-05";
        LocalDate dataSinistro = LocalDate.parse(dataSinistroStr, formatador);
        seguropf_1.gerarSinistro(dataSinistro, "Rua do Sinistro 1", condutor_1, seguropf_1);

        System.out.println("-----------------Instanciamento do Sinistro PJ-----------------");
        seguropj_1.gerarSinistro(dataSinistro, "Rua do Sinistro 2", condutor_2, seguropj_1);
        
        System.out.println("-----------------Listar Clientes-----------------");
        listaSeguradoras.get(0).listarClientes();
        
        System.out.println("-----------------Sinistro 1-----------------");
        listaSeguradoras.get(0).visualizarSinistro(listaSeguradoras.get(0).encontrarSinistro(1));
        
        System.out.println("-----------------Sinistro 2-----------------");
        listaSeguradoras.get(0).visualizarSinistro(listaSeguradoras.get(0).encontrarSinistro(2));
        
        System.out.println("-----------------Valor Mensal SeguroPF----------------");
        seguropf_1.calcularValor();
        System.out.printf( "R$ %.2f \n", seguropf_1.getValorMensal());
        
        System.out.println("-----------------Valor Mensal SeguroPJ-----------------");
        seguropj_1.calcularValor();
        System.out.printf( "R$ %.2f \n", seguropj_1.getValorMensal());
        
        System.out.println("-----------------Calculo Receita da Seguradora-----------------");
        System.out.printf( "R$ %.2f \n", listaSeguradoras.get(0).calculaReceita());

        System.out.println("-----------------Listar Seguros por Cliente PF-----------------");
        System.out.println(listaSeguradoras.get(0).getSegurosPorCliente(cliente_pf_1));

        System.out.println("-----------------Listar Seguros por Cliente PJ-----------------");
        System.out.println(listaSeguradoras.get(0).getSegurosPorCliente(cliente_pj_1));

        System.out.println("-----------------Listar Sinistros por ClientePF-----------------");
        System.out.println(listaSeguradoras.get(0).getSinistrosPorCliente(cliente_pf_1));

        System.out.println("-----------------Listar Sinistros por ClientePJ-----------------");
        System.out.println(listaSeguradoras.get(0).getSinistrosPorCliente(cliente_pj_1));
        
        //Gravação de dados em arquivos
        System.out.println("-----------------Gravar Seguro PJ e Seguro PF-----------------");
        ArquivoSeguro arq_seg = new ArquivoSeguro();
        arq_seg.gravarArquivo(seguropj_1);
        arq_seg.gravarArquivo(seguropf_1);
        System.out.println("SeguroPJ 1 e SeguroPF 1 gravados");

        System.out.println("-----------------Gravar Sinistros-----------------");
        ArquivoSinistro arq_sin = new ArquivoSinistro();
        arq_sin.gravarArquivo(seguradora_1.encontrarSinistro(1));
        arq_sin.gravarArquivo(seguradora_1.encontrarSinistro(2));
        System.out.println("Sinistro 1 e Sinistro 2 gravados");

        //Leitura de dados dos arquivos
        
        System.out.println("-----------------Leitura de veiculos.csv-----------------");
        ArquivoVeiculo v = new ArquivoVeiculo();
        ArrayList<String[]> lista_veiculo = v.lerArquivo();
        for (int i = 0; i < lista_veiculo.size(); i++){
            Veiculo veiculo = new Veiculo(lista_veiculo.get(i)[0], lista_veiculo.get(i)[1], lista_veiculo.get(i)[2], Integer.parseInt(lista_veiculo.get(i)[3]));
            seguradora_1.getListaVeiculos().add(veiculo);
            System.out.println("O veiculo " + veiculo.getPlaca() + " foi adicionado");
        } 
        System.out.println("veiculos.csv lido e instanciado");

        System.out.println("-----------------Leitura de condutores.csv-----------------");
        ArquivoCondutor c = new ArquivoCondutor();
        ArrayList<String[]> lista_condutor = c.lerArquivo();
        for (int i = 0; i < lista_condutor.size(); i++){
            Condutor condutor = new Condutor(lista_condutor.get(i)[0], lista_condutor.get(i)[1], lista_condutor.get(i)[2],
                                            lista_condutor.get(i)[3], lista_condutor.get(i)[4], LocalDate.parse(lista_condutor.get(i)[5], formatador));
            seguradora_1.getListaCondutores().add(condutor);
            System.out.println("O condutor " + condutor.getNome() + " foi adicionado");
        }
        System.out.println("condutores.csv lido e instanciado");

        System.out.println("-----------------Leitura de frotas.csv-----------------");
        ArquivoFrota f = new ArquivoFrota();
        ArrayList<String[]> lista_frota = f.lerArquivo();
        for (int i = 0; i < lista_frota.size(); i++){
            Frota frota = new Frota(lista_frota.get(i)[0]);
            for (int j = 1; j < lista_frota.get(i).length ; j++){
                Veiculo veiculo_frota = seguradora_1.encontra_veiculo_seg(lista_frota.get(i)[j]);
                frota.addVeiculo(veiculo_frota);
            }
            seguradora_1.getListaFrota().add(frota);
        }
        System.out.println("frotas.csv lido e instanciado");

        System.out.println("-----------------Leitura de clientesPF.csv-----------------");
        ArquivoClientePF pf = new ArquivoClientePF();
        ArrayList<String[]> lista_pf = pf.lerArquivo();
        for (int i = 0; i < lista_pf.size(); i++){
            if (Validacao.validarCPF(lista_pf.get(i)[0]) == true){
                ClientePF clientePF = new ClientePF(lista_pf.get(i)[1], lista_pf.get(i)[2], lista_pf.get(i)[3],
                                                    lista_pf.get(i)[4], lista_pf.get(i)[6], lista_pf.get(i)[5],
                                                    lista_pf.get(i)[0], LocalDate.parse(lista_pf.get(i)[7], formatador));
                Veiculo veiculo_pf = seguradora_1.encontra_veiculo_seg(lista_pf.get(i)[8]);
                clientePF.cadastrar_veiculo(veiculo_pf);
                seguradora_1.cadastrarCliente(clientePF);
            }
        }
        System.out.println("clientesPF.csv lido e instanciado");

        System.out.println("-----------------Leitura de ClientesPJ.csv-----------------");
        ArquivoClientePJ pj = new ArquivoClientePJ();
        ArrayList<String[]> lista_pj = pj.lerArquivo();
        for (int i = 0; i < lista_pj.size(); i++){
            if (Validacao.validarCNPJ(lista_pj.get(i)[0]) == true){
                ClientePJ clientePJ = new ClientePJ(lista_pj.get(i)[1], lista_pj.get(i)[2], lista_pj.get(i)[3],
                                                    lista_pj.get(i)[4], lista_pj.get(i)[0], 100,
                                                    LocalDate.parse(lista_pj.get(i)[5], formatador));
                Frota frota_pj = seguradora_1.encontra_frota_seg(lista_pj.get(i)[6]);
                clientePJ.cadastrarFrota(frota_pj);
                seguradora_1.cadastrarCliente(clientePJ);
            }
        }
        System.out.println("clientesPJ.csv lido e instanciado");
    }
}