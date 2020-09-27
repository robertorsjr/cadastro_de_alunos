package cadastro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

public class TabController {

    @FXML
    private Tab listarTab;
    @FXML
    private Tab cadastrarTab;
    @FXML
    private Tab buscarTab;

    @FXML
    public void initialize() throws Exception{
        listarTab.setContent(FXMLLoader.load(getClass().getResource("/cadastro/views/lista_Aluno.fxml")));
        cadastrarTab.setContent(FXMLLoader.load(getClass().getResource("/cadastro/views/cadastro_Aluno.fxml")));
        buscarTab.setContent(FXMLLoader.load(getClass().getResource("/cadastro/views/buscar_Aluno.fxml")));
    }
}
