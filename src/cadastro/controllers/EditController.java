package cadastro.controllers;

import cadastro.models.Aluno;
import cadastro.models.Sexo;
import cadastro.models.Sistema;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class EditController {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField tfNome;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<Sexo> cb;
    @FXML
    private TextField tfResponsavel;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnRemover;

    ObservableList choiceBox = FXCollections.observableArrayList();
    private final Sistema sistema = Sistema.getInstance();
    public void choiceBox(){
        choiceBox.addAll(Sexo.values());
        cb.getItems().addAll(choiceBox);
    }
    @FXML
    public void initialize(){
        choiceBox();
    }
    public void exibirAluno(Aluno aluno){
        tfNome.setText(aluno.getNome());
        datePicker.setValue(aluno.getLocalDate());
        cb.setValue(aluno.sexo());
        tfResponsavel.setText(aluno.getResponsavel());
    }

    @FXML
    public void onClickSave(){
        Alert alert;
        Aluno aluno = new Aluno();
        aluno.setNome(tfNome.getText());
        aluno.setDataDeNasc(datePicker.getValue());
        aluno.setSexo(cb.getValue());

        boolean editadoComSucesso = sistema.editarAlunos(tfNome.getText(), aluno);
        if(editadoComSucesso){
            alert = new Alert(
                    Alert.AlertType.INFORMATION,
                    "Cadastro alterado com sucesso",
                    ButtonType.OK
            );
            alert.setHeaderText("Editar");
            alert.showAndWait();
        }
        Stage stage = (Stage) btnSalvar.getScene().getWindow();
        stage.close();

    }
    public void onClickRemove(){

    }

}
