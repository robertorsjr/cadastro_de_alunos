package cadastro.controllers;

import cadastro.models.Aluno;
import cadastro.models.Sexo;
import cadastro.models.Sistema;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AddController {
    @FXML
    private TextField tfNome;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<Sexo> cb;
    @FXML
    private TextField tfResponsavel;
    @FXML
    private Label lbResponsavel;


    ObservableList choiceBox = FXCollections.observableArrayList();
    Sistema sistema = Sistema.getInstance();

    public void initialize(){
        choiceBox();
        datePicker.valueProperty().addListener((observable, oldValue, newValue)->{
            long age = newValue.until(LocalDate.now(), ChronoUnit.YEARS);
            if(age >= 18){
                lbResponsavel.setVisible(false);
                tfResponsavel.setVisible(false);
            }else{
                lbResponsavel.setVisible(true);
                tfResponsavel.setVisible(true);
            }
        });
    }
    public void choiceBox(){
        choiceBox.addAll(Sexo.values());
        cb.getItems().addAll(choiceBox);
    }
    public void onClickExit(){
        System.exit(0);
    }
    public void onClick() {
        Alert alert;
        Aluno aluno = new Aluno();

        validacaoDeCampos();
        aluno.setNome(tfNome.getText());
        aluno.setDataDeNasc(datePicker.getValue());
        aluno.setSexo(cb.getValue());
        if(tfResponsavel.isVisible()){
            aluno.setResponsavel(tfResponsavel.getText());
        }else{
            aluno.setResponsavel("Não Precisa");
        }

        if(validacaoDeCampos()){
            cleanTextFilds();
            sistema.cadastrarAlunos(aluno);

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operação");
            alert.setHeaderText("Sucess");
            alert.setContentText("Cadastrado com Sucesso!");
            alert.show();
        }else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("ERRO");
            alert.setContentText("Preencher os campos");
            alert.show();
        }

    }
    public void cleanTextFilds(){
        tfNome.setText("");
        datePicker.getEditor().clear();
        cb.setItems(choiceBox);
        tfResponsavel.setText("");
        lbResponsavel.setVisible(false);
        tfResponsavel.setVisible(false);
    }
    public boolean validacaoDeCampos(){
        boolean valor =false;

        if(tfNome.getText().isEmpty()){
            return valor = false;
        }
        if(datePicker.getValue() == null) {
            return valor = false;
        }
        if(cb.getValue() == null){
            return valor = false;
        }
        if(tfResponsavel.isVisible()){
            if(tfResponsavel.getText().isEmpty()){
                return valor = false;
            }
        }
        return true;
    }
}


