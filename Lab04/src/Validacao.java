public class Validacao {
    
    public static boolean validarCPF(String cpf) {
		boolean valido = true;
		cpf = cpf.replaceAll("[^0-9]", "");
		if (cpf.length() != 11) {
			valido = false;
			return valido;
		}
		int contador = 0;
		for (int i = 0; i < cpf.length() - 1; i++) {
			if (cpf.charAt(i) == cpf.charAt(i+1)) {
				contador ++;
				if (contador == 10){
					valido = false;
					return valido;
				}
			}
		}

		int numero, resto1;
		char digito1;
		int soma1 = 0;
		int peso1 = 10;

		for (int i = 0; i < 9; i++){
			numero = (int)(cpf.charAt(i) - 48);
			soma1 = (soma1) + (numero * peso1);
			peso1 = peso1 - 1 ;
		}
		resto1 = 11 - (soma1 % 11);
		if ((resto1 == 10) || (resto1 == 11)){
			digito1 = '0';
		}else {
			digito1 = (char)(resto1 + 48);
		}

		int resto2;
		char digito2;
		int soma2 = 0;
		int peso2 = 11;

		for (int i = 0; i < 10; i++){
			numero = (int)(cpf.charAt(i) - 48);
			soma2 = (soma2) + (numero * peso2);
			peso2 = peso2 - 1 ;
		}
		resto2 = 11 - (soma2 % 11);
		if ((resto2 == 10) || (resto2 == 11)){
			digito2 = '0';
		}else {
			digito2 = (char)(resto2 + 48);
		}

		if ((digito1 == cpf.charAt(9)) && (digito2 == cpf.charAt(10))){
			return valido;
		}else {
			valido = false;
			return valido;
		}
	}

    public static boolean validarCNPJ(String cnpj) {
		boolean valido = true;
		cnpj = cnpj.replaceAll("[^0-9]", "");
		if (cnpj.length() != 14) {
			valido = false;
			return valido;
		}
		int contador = 0;
		for (int i = 0; i < cnpj.length() - 1; i++) {
			if (cnpj.charAt(i) == cnpj.charAt(i+1)) {
				contador ++;
				if (contador == 13){
					valido = false;
					return valido;
				}
			}
		}

		int numero, resto1;
		char digito1;
		int soma1 = 0;
		int peso1 = 5;

		for (int i = 0; i < 12; i++){
			numero = (int)(cnpj.charAt(i) - 48);
			soma1 = (soma1) + (numero * peso1);
			peso1 = peso1 - 1 ;
			if (peso1 == 1){
				peso1 = 9;
			}
		}
		resto1 = soma1 % 11;
		if ((resto1 == 0) || (resto1 == 1)){
			digito1 = '0';
		}else {
			digito1 = (char)((11 - resto1) + 48);
		}

		int resto2;
		char digito2;
		int soma2 = 0;
		int peso2 = 6;

		for (int i = 0; i < 13; i++){
			numero = (int)(cnpj.charAt(i) - 48);
			soma2 = (soma2) + (numero * peso2);
			peso2 = peso2 - 1 ;
			if(peso2 == 1){
				peso2 = 9;
			}
		}
		resto2 = soma2 % 11;
		if ((resto2 == 0) || (resto2 == 1)){
			digito2 = '0';
		}else {
			digito2 = (char)((11 - resto2) + 48);
		}

		if ((digito1 == cnpj.charAt(12)) && (digito2 == cnpj.charAt(13))){
			return valido;
		}else {
			valido = false;
			return valido;
		}
	}

    public static boolean validarNome(String nome){
        boolean valido = true;
		nome = nome.replaceAll(" ", "");
		for (int i = 0; i < nome.length(); i++){
			if (Character.isLetter(nome.charAt(i)) == false){
				valido = false;
				return valido;
			}
        }
        return valido;
    }
}
