import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
    protected static int contador = 1;
	protected final int id;
    protected LocalDate dataInicio;
	protected LocalDate dataFim;
    protected Seguradora seguradora;
    protected ArrayList<Sinistro> listaSinistros;
    protected ArrayList<Condutor> listaCondutores;
    protected double valorMensal;
    protected static double qtd_sinistros_condutor;

    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
        this.id = Seguro.contador++;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        valorMensal = 0.0;
        listaSinistros = new ArrayList<Sinistro>();
        listaCondutores = new ArrayList<Condutor>();
        qtd_sinistros_condutor = 0;
    }

    public int getId(){
        return id;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return this.listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

    public static double getQtd_sinistros_condutor(){
        return qtd_sinistros_condutor;
    }

    public void setQtd_sinistros_condutor(double qtd_sinistros_condutor){
        Seguro.qtd_sinistros_condutor = qtd_sinistros_condutor;
    }
    
    public abstract boolean desautorizarCondutor(String cpf);

    public abstract boolean autorizarCondutor(Condutor condutor);

    public abstract double calcularValor();

    public abstract boolean gerarSinistro(Sinistro sinistro);

    @Override
    public String toString() {
        return "{" +
            " dataInicio='" + getDataInicio() + "'" +
            ", dataFim='" + getDataFim() + "'" +
            ", seguradora='" + getSeguradora() + "'" +
            ", listaSinistros='" + getListaSinistros() + "'" +
            ", listaCondutores='" + getListaCondutores() + "'" +
            ", valorMensal='" + getValorMensal() + "'" +
            "}";
    }
    
}
