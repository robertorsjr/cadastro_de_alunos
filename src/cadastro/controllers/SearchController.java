package cadastro.controllers;

import cadastro.models.Aluno;
import cadastro.models.Sistema;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class SearchController {
    @FXML
    private TextField tfBuscar;
    @FXML
    private TextField tfNome1;
    @FXML
    private TextField tfData1;
    @FXML
    private TextField tfSexo1;
    @FXML
    private TextField tfResponsavel1;



    Sistema sistema = Sistema.getInstance();

    public void onClickSearch(){
        Aluno aluno = sistema.buscarAlunosPorNome(tfBuscar.getText());
            tfNome1.setText(aluno.getNome());
            tfData1.setText(aluno.getDataDeNasc());
            tfSexo1.setText(aluno.getSexo());
            tfResponsavel1.setText(aluno.getResponsavel());

    }
    public void onClickLimpar(){
        tfNome1.setText("");
        tfData1.setText("");
        tfSexo1.setText("");
        tfResponsavel1.setText("");
    }
    public void onClickSair(){
        System.exit(0);
    }
}
