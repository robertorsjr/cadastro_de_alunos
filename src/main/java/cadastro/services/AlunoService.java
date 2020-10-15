package cadastro.services;

import cadastro.models.Aluno;
import cadastro.models.Sexo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlunoService {
    private static AlunoService instence;
    Database database;
    public ObservableList<Aluno> alunos;

    public AlunoService(){
        alunos = FXCollections.observableArrayList();
    }
    public static synchronized AlunoService getInstance(){
        if(instence == null){
            instence = new AlunoService();
        }
        return instence;
    }
    public ObservableList<Aluno> listaAlunos() throws SQLException {
        database = new Database();
        try (
            Statement statement = database.connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from alunos");
        ){
            while (rs.next()){
                Aluno aluno = new Aluno();
                aluno.setNome(rs.getString("nome"));

                char sexo = rs.getString("sexo").charAt(0);

                if (sexo == 'F' || sexo == 'f') {
                    aluno.setSexo(Sexo.FEMININO);
                } else if (sexo == 'M' || sexo == 'm') {
                    aluno.setSexo(Sexo.MASCULINO);
                } else {
                    aluno.setSexo(Sexo.OUTRO);
                }

                aluno.setDataDeNasc(rs.getDate("data_nascimento").toLocalDate());
                aluno.setResponsavel(rs.getString("responsavel"));

                alunos.add(aluno);
            }

            database.shutdown();

            return alunos;
        }
    }
}
