import java.util.ArrayList;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    // Construtor
    public Frota(String code) {
        this.code = code;
        listaVeiculos = new ArrayList<Veiculo>();
    }

    //Getters e setters
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public boolean addVeiculo(Veiculo veiculo){
        listaVeiculos.add(veiculo);
        System.out.println("O Veiculo "+ veiculo.getPlaca() +" foi adicionado a frota.");
        return true;
    }

    public boolean removeVeiculo(Veiculo veiculo){
        for (int i =0; i<listaVeiculos.size();i++){
			if(listaVeiculos.get(i).equals(veiculo)){
				listaVeiculos.remove(i);
				return true;
			}
		}
		return false;
    }

    public Veiculo encontra_veiculo(String placa){
		for (int i =0; i<listaVeiculos.size();i++){
			if(listaVeiculos.get(i).getPlaca().equals(placa)){
				return listaVeiculos.get(i);
			}
		}
		return null;
	}

    @Override
    public String toString() {
        return "Code = " + getCode() + "\n" +
            "Lista de Veiculos='" + getListaVeiculos();
    }
    
}
