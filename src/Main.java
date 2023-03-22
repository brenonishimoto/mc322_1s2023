
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Pessoa Aleatória", "416.213.142-27", "22/03/1993", 30, "UNICAMP Universidade Estadual de Campinas - Av. Albert Einstein, 1251 - Cidade Universitária, Campinas - SP, 13083-852");
        
        System.out.println(cliente1.toString());
        if (cliente1.validarCPF("416.213.142-27") == false){
            System.out.println("Coloque um CPF válido");
        }

        Veiculo veiculo1 = new Veiculo("BRA2E19", "Fiat", "Uno");
        Seguradora seguradora1 = new Seguradora("Porto Seguro", "(11)3003-9303", "portoseguro@gmail.com", "Av. Dr. Romeu Tortima, 446 - Jardim Santa Genebra, Campinas - SP, 13083-897");
        Sinistro sinistro1 = new Sinistro( "21/03/2023", "Av. Érico Veríssimo, 50 - Cidade Universitária, Campinas - SP, 13083-851");
        Sinistro sinistro2 = new Sinistro( "21/03/2023", "Av. Érico Veríssimo, 50 - Cidade Universitária, Campinas - SP, 13083-851");

        System.out.println(veiculo1.toString());
        System.out.println(seguradora1.toString());
        System.out.println(sinistro1.toString());
        System.out.println(sinistro2.toString());
    }
}
