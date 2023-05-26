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
        return true;
    }

    public boolean removeVeiculo(Veiculo veiculo){
        return true;
    }

    @Override
    public String toString() {
        return "Code = " + getCode() + "\n" +
            "Lista de Veiculos='" + getListaVeiculos();
    }
    
}
