import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int i;
        System.out.println("Quantos veículos o Cliente possui?");
        int n_veiculos = scanner.nextInt();
        for ( i = 0; i < n_veiculos; i++){
            System.out.println("Qual a placa do carro?");
            String placa = scanner.next();
            System.out.println("Qual a marca do carro?");
            String marca = scanner.next();
            System.out.println("Qual o modelo do carro?");
            String modelo = scanner.next();
            System.out.println("Qual o ano de Fabricação do carro?");
            int anoFabricacao = scanner.nextInt();
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);

        }
        scanner.close();
    }
}
