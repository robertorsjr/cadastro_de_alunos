package cadastro.controllers;

import cadastro.models.Aluno;
import cadastro.models.Sexo;
import cadastro.models.Sistema;
import cadastro.services.AlunoService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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

    private final AlunoService alunoService = AlunoService.getInstance();

    public void initialize() throws SQLException {
        alunoService.listaAlunos();
        tcNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("Nome"));
        tcSexo.setCellValueFactory(new PropertyValueFactory<Aluno, Sexo>("sexo"));
        tcData.setCellValueFactory(new PropertyValueFactory<Aluno, String>("dataDeNasc"));
        tcResponsavel.setCellValueFactory(new PropertyValueFactory<Aluno, String>("responsavel"));

        listaTab.setPlaceholder(new Label("Nenhum Cadastro"));
        listaTab.setItems(alunoService.alunos);

        listaTab.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->
                onSelectRow(observableValue.getValue())


        );


    }
    public void onSelectRow(Aluno aluno){
       try{
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/views/editar_cadastro.fxml"));
           loader.load();

           EditController editController = loader.getController();
           editController.exibirAluno(aluno);
           Parent editRoot = loader.getRoot();

           Stage stage = new Stage();
           stage.setScene(new Scene(editRoot));
           stage.setTitle("Editar Cadastro");
           stage.initModality(Modality.WINDOW_MODAL);
           stage.show();
       }catch (IOException e){
           e.printStackTrace();
       }

    }
}
