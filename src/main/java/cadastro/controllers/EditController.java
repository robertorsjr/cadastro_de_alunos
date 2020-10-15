package cadastro.controllers;

import cadastro.models.Aluno;
import cadastro.models.Sexo;
import cadastro.services.AlunoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Optional;

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
    private final AlunoService alunoService = AlunoService.getInstance();
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
      try {
          Aluno aluno = new Aluno();
          aluno.setNome(tfNome.getText());
          aluno.setDataDeNasc(datePicker.getValue());
          aluno.setSexo(cb.getValue());
          aluno.setResponsavel(tfResponsavel.getText());

          boolean editadoComSucesso = alunoService.editarCadastro(tfNome.getText(), aluno);
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
      }catch (Exception e){
          alert = new Alert(
                  Alert.AlertType.ERROR,
                  "Ocorreu um erro ao editar o aluno.",
                  ButtonType.OK
          );
          alert.setHeaderText("Erro");
          alert.showAndWait();
      }


    }
    @FXML
    public void onClickRemove() {
        Stage stage = (Stage) btnRemover.getScene ().getWindow ();
        stage.close ();

        Alert alert = new Alert (
                Alert.AlertType.CONFIRMATION,
                "Deseja remover esse aluno?",
                ButtonType.CANCEL,
                ButtonType.OK
        );
        alert.setHeaderText ("Remover aluno");
        Optional<ButtonType> result = alert.showAndWait ();

        if(result.isPresent() && result.get() == ButtonType.OK){
            try {
                boolean sucess = alunoService.removerAluno(tfNome.getText());

                if(sucess){
                    alert = new Alert(
                            Alert.AlertType.INFORMATION,
                            "Aluno removido com sucesso",
                            ButtonType.OK
                    );
                    alert.setHeaderText("Remover");
                    alert.showAndWait();
                }
            }catch (Exception e){
                alert = new Alert(
                        Alert.AlertType.ERROR,
                        "Ocorreu um erro ao remover o aluno.",
                        ButtonType.OK
                );
                alert.setHeaderText("Erro");
                alert.showAndWait();
            }
        }
    }
}
