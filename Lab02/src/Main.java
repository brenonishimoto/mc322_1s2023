
public class Main {
    public static void main(String[] args) {
        //Declaração de classe e instanciação, se é passado os valores de cada campo.
        Cliente cliente1 = new Cliente("Pessoa Aleatória 1", "416.213.142-26", "22/03/1993", 30, "UNICAMP Universidade Estadual de Campinas - Av. Albert Einstein, 1251 - Cidade Universitária, Campinas - SP, 13083-852");
        
        //Caso o CPF não seja válido será solicitado para colocar um válido, caso seja, o objeto será impresso.
        if (cliente1.validarCPF() == false){
            System.out.println("Coloque um CPF válido\n");
        } else{
            System.out.println(cliente1.toString());
        }

        Cliente cliente2 = new Cliente("Pessoa Aleatória 2", "416.213.142-27", "22/03/1992", 31, "UNICAMP Universidade Estadual de Campinas - Av. Albert Einstein, 1251 - Cidade Universitária, Campinas - SP, 13083-852");

        if (cliente2.validarCPF() == false){
            System.out.println("Coloque um CPF válido\n");
        } else{
            System.out.println(cliente2.toString());
        }

        //Declaração de classe e instanciação, se é passado os valores de cada campo.
        Veiculo veiculo1 = new Veiculo("BRA2E19", "Fiat", "Uno");
        Seguradora seguradora1 = new Seguradora("Porto Seguro", "(11)3003-9303", "portoseguro@gmail.com", "Av. Dr. Romeu Tortima, 446 - Jardim Santa Genebra, Campinas - SP, 13083-897");
        Sinistro sinistro1 = new Sinistro( "20/03/2023", "Av. Érico Veríssimo, 50 - Cidade Universitária, Campinas - SP, 13083-851");
        Sinistro sinistro2 = new Sinistro( "21/03/2023", "Av. Érico Veríssimo, 50 - Cidade Universitária, Campinas - SP, 13083-851");

        System.out.println(veiculo1.toString());
        System.out.println(seguradora1.toString());
        System.out.println(sinistro1.toString());
        System.out.println(sinistro2.toString());
    }
}
