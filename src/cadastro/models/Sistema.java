package cadastro.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sistema {
    private static Sistema instance;
    public ObservableList<Aluno> alunos;

    private Sistema(){

        this.alunos = FXCollections.observableArrayList();
    }

    public static synchronized Sistema getInstance(){
        if(instance == null){
            instance = new Sistema();
        }
        return instance;
    }


    public boolean cadastrarAlunos(Aluno aluno){
        return alunos.add(aluno);

    }
}
