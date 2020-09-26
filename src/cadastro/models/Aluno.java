package cadastro.models;


import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Aluno {
    private String nome;
    private String sexo;
    private String dataDeNasc;
    private TextField responsavel;
    private int idade;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeNasc() {
        return dataDeNasc;
    }

    public void setDataDeNasc(String dataDeNasc) {
        this.dataDeNasc = dataDeNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public TextField getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(TextField responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", dataDeNasc=" + dataDeNasc +
                ", sexo=" + sexo +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
