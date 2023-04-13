import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        while (true){
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

            if(opcao == 0){
                System.out.println("Até mais!");
                scanner.close();
                break;
            }

            if(opcao == 1){
                System.out.println("Nome da Seguradora:");
                String nome = scanner.next();
                System.out.println("Telefone da Seguradora:");
                String telefone = scanner.next();
                System.out.println("E-mail da Seguradora:");
                String email = scanner.next();
                System.out.println("Endereço da Seguradora:");
                String endereco = scanner.next();
                Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
                listaSeguradoras.add(seguradora);
                System.out.println("A seguradora " + seguradora.getNome() + " foi cadastrada!");
                for (int i = 0; i < listaSeguradoras.size();i++) { 		      
                        System.out.println(listaSeguradoras.get(i)); 		
                    }
                }

            if(opcao == 2){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.next();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome() == nome_seguradora){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                    
                System.out.println("CPF/CNPJ?");
                String cpf_cnpj = scanner.next();
                cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]", "");
                if (cpf_cnpj.length() == 11) {
                    if (ClientePF.validarCPF(cpf_cnpj) == false){
                        System.out.println("Coloque um CPF válido.");
                        break;
                    }
                    System.out.println("Nome:");
                    String nome = scanner.next();
                    System.out.println("Endereço:");
                    String endereco = scanner.next();
                    System.out.println("Data da Licença (XX/XX/XXXX):");
                    String dataLicencaStr = scanner.next();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataLicenca = formatter.parse(dataLicencaStr);
                    System.out.println("Data de Nascimento (XX/XX/XXXX):");
                    String dataNascimentoStr = scanner.next();
                    Date dataNascimento = formatter.parse(dataNascimentoStr);
                    System.out.println("Nivel de Educação:");
                    String educacao = scanner.next();
                    System.out.println("Genero:");
                    String genero = scanner.next();
                    System.out.println("Classe Econômica:");
                    String classeEconomica = scanner.next();
                    ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
                    Cliente novo_cliente_pf = new ClientePF(nome, endereco, dataLicenca , educacao, genero , classeEconomica, listaVeiculos, cpf_cnpj, dataNascimento);
                    listaSeguradoras.get(posicao).cadastrarCliente(novo_cliente_pf);
                }
                if (cpf_cnpj.length() == 14) {
                    if (ClientePJ.validarCNPJ(cpf_cnpj) == false){
                        System.out.println("Coloque um CNPJ válido.");
                        break;
                    }
                    System.out.println("Nome:");
                    String nome = scanner.next();
                    System.out.println("Endereço:");
                    String endereco = scanner.next();
                    System.out.println("Data de Fundação (XX/XX/XXXX):");
                    String dataFundacaoStr = scanner.next();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataFundacao = formatter.parse(dataFundacaoStr);
                    ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
                    Cliente novo_cliente_pj = new ClientePJ(nome, endereco, listaVeiculos, cpf_cnpj, dataFundacao);
                    listaSeguradoras.get(posicao).cadastrarCliente(novo_cliente_pj);
                }
                else{
                    System.out.println("Coloque um CPF/CNPJ válido.");
                }
            }
            }

            if(opcao == 3){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.next();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome() == nome_seguradora){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                System.out.println("Qual o nome do Cliente?");
                String nome_cliente = scanner.next();
                listaSeguradoras.get(posicao).encontrarCliente(nome_cliente).cadastrarVeiculo();
            }

            if(opcao == 4){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.next();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome() == nome_seguradora){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                listaSeguradoras.get(posicao).gerarSinistro(listaSeguradoras.get(posicao));
            }

            if(opcao == 5){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.next();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome() == nome_seguradora){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                System.out.println("Qual o nome do Cliente?");
                String nome_cliente = scanner.next();
                listaSeguradoras.get(posicao).removerCliente(nome_cliente);
            }

            if(opcao == 6){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.next();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome() == nome_seguradora){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                listaSeguradoras.get(posicao).listarClientes();
            }

            if(opcao == 7){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.next();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome() == nome_seguradora){
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

            if(opcao == 8){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.next();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome() == nome_seguradora){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                listaSeguradoras.get(posicao).listarSinistros();
            }

            if(opcao == 9){
                System.out.println("Qual seguradora o cliente pertence?");
                String nome_seguradora = scanner.next();
                int posicao = 0;
                for(int i = 0; i< listaSeguradoras.size(); i++){
                    if (listaSeguradoras.get(i).getNome() == nome_seguradora){
                        posicao = i;
                    }
                    else{
                        System.out.println("Procure uma Seguradora existente ou cadastre uma nova.");
                        break;
                    }
                }
                System.out.println("Qual o nome do Cliente?");
                String nome_cliente = scanner.next();
                listaSeguradoras.get(posicao).encontrarCliente(nome_cliente).listarVeiculos();
            }
        }
    }
}

