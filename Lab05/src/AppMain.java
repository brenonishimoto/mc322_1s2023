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
        System.out.println("4 - Atualizar Frota");
        System.out.println("5 - Autorizar/Desautorizar Condutor em um Seguro");
        System.out.println("6 - Gerar Sinistro");
        System.out.println("7 - Calcular Valor Mensal Seguro");
        System.out.println("8 - Calcular Receita Seguradora");
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
            clientePJ.atualizarFrota(scanner);
            return;
        }
    }

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
            Sinistro sinistro = new Sinistro(data, endereco, condutor, seguroPF);
            seguroPF.listaSinistros.add(sinistro);
            condutor.getListaSinistros().add(sinistro);
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
            Sinistro sinistro = new Sinistro(data, endereco, condutor, seguroPJ);
            seguroPJ.listaSinistros.add(sinistro);
            condutor.getListaSinistros().add(sinistro);
        }
    } 
    
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
            clientePF.getListaVeiculos();
            }
        else if (cpf_cnpj.length() == 14){
            ClientePJ clientePJ = (ClientePJ) listaSeguradoras.get(opcao - 1).encontrarCliente(cpf_cnpj);
            for (int i = 0; i < clientePJ.listaFrotas().size(); i++ ){
                clientePJ.listaFrotas().get(i).getListaVeiculos();
            }
            }   
    }

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
        clientePJ.getVeiculosPorFrota(scanner);
    }

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
        System.out.println("R$" + listaSeguradoras.get(opcao - 1).encontrarSeguro(id).getValorMensal());
    }

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
        System.out.println(receita);
    }

    public static void teste(Scanner scanner, ArrayList<Seguradora> listaSeguradoras){
    // Instanciação e chamada de métodos

        System.out.println("-----------------Instanciamento de Seguradora-----------------");
        Seguradora seguradora_1 = new Seguradora("15.693.842/0001-43", "Seguradora 1", "(19)40028922", "seguradora1@gmail.com", "Rua da Seguradora 1");
        listaSeguradoras.add(seguradora_1);
        System.out.println("A seguradora '" + seguradora_1.getNome() + "' foi adicionada!");

        System.out.println("-----------------Instanciamento de Cliente PF-----------------");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimentoStr = "12/12/1990";
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
        String dataFundacaoStr = "13/04/2012";
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
        frota_1.addVeiculo(veiculo_2);

        System.out.println("-----------------Instanciamento do SeguroPF -----------------");
        String dataInicioStr = "01/01/2010";
        LocalDate dataInicio = LocalDate.parse(dataInicioStr, formatador);
        String dataFimStr = "31/12/2010";
        LocalDate dataFim = LocalDate.parse(dataFimStr, formatador);
        SeguroPF seguropf_1 = new SeguroPF(dataInicio,dataFim, seguradora_1,veiculo_1, cliente_pf_1);
        listaSeguradoras.get(0).gerarSeguro(seguropf_1);

        System.out.println("-----------------Instanciamento do SeguroPJ -----------------");
        SeguroPJ seguropj_1 = new SeguroPJ(dataInicio, dataFim, seguradora_1, frota_1, cliente_pj_1);
        listaSeguradoras.get(0).gerarSeguro(seguropj_1);

        System.out.println("-----------------Instanciamento do Condutor (SeguroPF)-----------------");
        Condutor condutor_1 = new Condutor("71356301657", "João", "(11)1111-1111","Rua do João", "joao@gmail.com", dataNascimento);
        listaSeguradoras.get(0).cadastrarCondutor(condutor_1);

        System.out.println("-----------------Instanciamento do Condutor (SeguroPJ)-----------------");
        Condutor condutor_2 = new Condutor("21892605074", "Maria", "(22)2222-2222","Rua da Maria", "maria@gmail.com", dataNascimento);
        listaSeguradoras.get(0).cadastrarCondutor(condutor_2);
        
        System.out.println("-----------------Instanciamento do Sinistro PF-----------------");
        String dataSinistroStr = "05/05/2010";
        LocalDate dataSinistro = LocalDate.parse(dataSinistroStr, formatador);
        Sinistro sinistro_1 = new Sinistro(dataSinistro,"Rua do Sinistro 1", condutor_1,seguropf_1);
        seguropf_1.gerarSinistro(sinistro_1);
        condutor_1.adicionarSinistro(sinistro_1);
        
        System.out.println("-----------------Instanciamento do Sinistro PJ-----------------");
        Sinistro sinistro_2 = new Sinistro(dataSinistro, "Rua do Sinistro 2", condutor_2, seguropj_1);
        seguropj_1.gerarSinistro(sinistro_2);
        condutor_2.adicionarSinistro(sinistro_2);
        
        System.out.println("-----------------Listar Clientes-----------------");
        listaSeguradoras.get(0).listarClientes();
        
        System.out.println("-----------------Sinistro 1-----------------");
        listaSeguradoras.get(0).visualizarSinistro(sinistro_1);
        
        System.out.println("-----------------Sinistro 2-----------------");
        listaSeguradoras.get(0).visualizarSinistro(sinistro_2);
        
        System.out.println("-----------------Valor Mensal SeguroPF----------------");
        seguropf_1.calcularValor();
        System.out.println("R$" + seguropf_1.getValorMensal());
        
        System.out.println("-----------------Valor Mensal SeguroPJ-----------------");
        seguropj_1.calcularValor();
        System.out.println("R$" + seguropj_1.getValorMensal());
        
        System.out.println("-----------------Calculo Receita da Seguradora-----------------");
        System.out.println("R$" + listaSeguradoras.get(0).calculaReceita());

        System.out.println("-----------------Listar Seguros por Cliente PF-----------------");
        System.out.println(listaSeguradoras.get(0).getSegurosPorCliente(cliente_pf_1));

        System.out.println("-----------------Listar Seguros por Cliente PJ-----------------");
        System.out.println(listaSeguradoras.get(0).getSegurosPorCliente(cliente_pj_1));

        System.out.println("-----------------Listar Sinistros por ClientePF-----------------");
        System.out.println(listaSeguradoras.get(0).getSinistrosPorCliente(cliente_pf_1));

        System.out.println("-----------------Listar Sinistros por ClientePJ-----------------");
        System.out.println(listaSeguradoras.get(0).getSinistrosPorCliente(cliente_pj_1));
        
        
    }
}