package cadastro.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

public class tabController {

    @FXML
    private Tab listarTab;
    @FXML
    private Tab cadastrarTab;

    @FXML
    public void initialize() throws Exception{
        listarTab.setContent(FXMLLoader.load(getClass().getResource("/cadastro/views/lista_Aluno.fxml")));
        cadastrarTab.setContent(FXMLLoader.load(getClass().getResource("/cadastro/views/cadastro_Aluno.fxml")));
    }
}
