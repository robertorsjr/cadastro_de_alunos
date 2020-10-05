package cadastro.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sistema {
    private static Sistema instance;
    public ObservableList<Usuario> usuarios;
    public ObservableList<Aluno> alunos;

    private Sistema(){

        this.alunos = FXCollections.observableArrayList();
    }
    public boolean cadastrarUsuarios(Usuario usuario){
        return usuarios.add(usuario);
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
    public void removerAlunos(){

    }
    public boolean editarAlunos(String nome,Aluno aluno){
        for(int i = 0; i < alunos.size(); i++){
            if(alunos.get(i).getNome().equalsIgnoreCase(nome)) {
                alunos.remove(i);
                alunos.add(i, aluno);
                return true;
            }
        }
        return false;
    }
    public ObservableList<Aluno> buscarAlunosPorNome(String nome){
        ObservableList<Aluno> alunosFiltrados = FXCollections.observableArrayList();
        for(Aluno aluno : alunos){
            if(aluno.getNome().toLowerCase().startsWith(nome.toLowerCase())){
                alunosFiltrados.add(aluno);
            }
        }
        return alunosFiltrados;
    }

}
