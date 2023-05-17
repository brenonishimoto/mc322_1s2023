import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private ArrayList<Sinistro> listaSinistros;

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        listaSinistros = new ArrayList<Sinistro>();
    }


    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void  adicionarSinistro(Sinistro sinistro) {
        listaSinistros.add(sinistro);
    }


    @Override
    public String toString() {
        return "{" +
            " cpf='" + getCpf() + "'" +
            ", nome='" + getNome() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", email='" + getEmail() + "'" +
            ", dataNasc='" + getDataNasc() + "'" +
            ", listaSinistros='" + getListaSinistros() + "'" +
            "}";
    }
    
}
