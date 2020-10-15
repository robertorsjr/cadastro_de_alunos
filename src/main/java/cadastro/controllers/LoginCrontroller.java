package cadastro.controllers;

import cadastro.models.Usuario;
import cadastro.services.AlunoService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class LoginCrontroller {

    @FXML
    private AnchorPane loginTab;
    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField pwSenha;


    AlunoService alunoService = AlunoService.getInstance();
    ObservableList<Usuario> usuarios;

    @FXML
    public void initialize(){

        tfUsuario.setText("Admin");
        pwSenha.setText("admin");
    }

    public void onClickCadastrar(){
        // chamar tela de cadastro.
    }

    public void onClickEntrar(){
        tfUsuario.getText ();
        pwSenha.getText ();
        validacaoDeLogin ();
        alerts (validacaoDeLogin ());

    }
    public void onClickSair(){
        System.exit(0);
    }
    public boolean validacaoDeLogin(){
        if(tfUsuario.getText().equals ("Admin") && pwSenha.getText().equals("admin")){
            return true;
        }
        return false;
//        for(int i = 0; i < usuarios.size(); i++){
//            if (usuarios.get(i).getUsuario().equals (tfUsuario.getText())){
//               return true;
//            }
//            if(usuarios.get(i).getSenha().equals (pwSenha.getText())){
//                return true;
//            }
//        }
//        return false;
    }
    public void trocarTela(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/views/tab.fxml"));
            Stage tabDeCadastro = new Stage ();
            tabDeCadastro.initStyle(StageStyle.UNDECORATED);
            tabDeCadastro.setScene(new Scene (root, 600, 400));
            tabDeCadastro.show();
        }catch (Exception e){
            e.printStackTrace ();
            e.getCause ();
        }
    }
    public void fecharTelaDeLogin(){
        Stage stage;
        stage = (Stage) loginTab.getScene ().getWindow ();
        stage.close ();
    }
    public void alerts(boolean validacao){
       Alert alert;
        if(validacao){
            trocarTela ();
            fecharTelaDeLogin();
        }else{
            alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("ERRADO");
            alert.setTitle("ERRADO");
            alert.setContentText("Login ERRADO");
            alert.showAndWait();
        }
    }
}
