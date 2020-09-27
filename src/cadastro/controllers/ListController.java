package cadastro.controllers;

import cadastro.models.Aluno;
import cadastro.models.Sexo;
import cadastro.models.Sistema;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListController {

    @FXML
    private TableView<Aluno> listaTab = new TableView<>();
    @FXML
    private TableColumn<Aluno, String> tcNome;
    @FXML
    private TableColumn<Aluno, Sexo> tcSexo;
    @FXML
    private TableColumn<Aluno, String> tcData;
    @FXML
    private TableColumn<Aluno, String> tcResponsavel;

    Sistema sistema = Sistema.getInstance();

    public void initialize() {
        tcNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("Nome"));
        tcSexo.setCellValueFactory(new PropertyValueFactory<Aluno, Sexo>("sexo"));
        tcData.setCellValueFactory(new PropertyValueFactory<Aluno, String>("dataDeNasc"));
        tcResponsavel.setCellValueFactory(new PropertyValueFactory<Aluno, String>("responsavel"));

        listaTab.setPlaceholder(new Label("Nenhum Cadastro"));
        listaTab.setItems(sistema.alunos);
    }
}
