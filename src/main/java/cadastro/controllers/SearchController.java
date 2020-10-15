package cadastro.controllers;

import cadastro.models.Aluno;
import cadastro.models.Sexo;
import cadastro.models.Sistema;
import cadastro.services.AlunoService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class SearchController {
    @FXML
    private TextField tfBuscar;
    @FXML
    private TableView<Aluno> tableViewBuscar;
    @FXML
    private TableColumn<Aluno, String> tcNome1;
    @FXML
    private TableColumn<Aluno, Sexo> tcSexo1;
    @FXML
    private TableColumn<Aluno, String> tcData1;
    @FXML
    private TableColumn<Aluno, String> tcResponsavel1;


    private static AlunoService alunoService = AlunoService.getInstance();

    public void onClickSearch() throws SQLException {

        ObservableList <Aluno> alunosFiltrados = alunoService.procurarAlunos(tfBuscar.getText());
        tcNome1.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcSexo1.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tcData1.setCellValueFactory(new PropertyValueFactory<>("dataDeNasc"));
        tcResponsavel1.setCellValueFactory(new PropertyValueFactory<>("responsavel"));

        tableViewBuscar.setPlaceholder(new Label("Nenhuma Busca"));
        tableViewBuscar.setItems(alunosFiltrados);
    }
    public void onClickLimpar(){

    }
    public void onClickSair(){
        System.exit(0);
    }
}
