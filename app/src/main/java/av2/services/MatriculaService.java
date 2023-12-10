package av2.services;

import java.time.LocalDateTime;

import av2.entities.Disciplina;
import org.hibernate.SessionFactory;
import av2.entities.Aluno;

public class MatriculaService {

    private SessionFactory sessionFactory;

    public MatriculaService(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void atualizarDadosdoAluno(Long alunoID, String novoNome, LocalDateTime novaDataNascimento, String novoLocalNascimento) {
        sessionFactory.inTransaction(session -> {
            Aluno aluno = session.get(Aluno.class, alunoID);

            if(aluno != null) {
                aluno.setNome(novoNome);
                aluno.setDataNascimento(novaDataNascimento);
                aluno.setCidadeNatal(novoLocalNascimento);

            }else{
                System.out.println("Aluno não encontrado com o ID: " + alunoID);
            }
        });
    }

    public void atualizarDisciplina(Long disciplinaID, String novoNomeDisciplina) {
        sessionFactory.inTransaction(session -> {
            Disciplina disciplina = session.get(Disciplina.class, disciplinaID);

            if(disciplina != null) {
                disciplina.setNome_disciplina(novoNomeDisciplina);
            }else{
                System.out.println("disciplina não encontrado com o ID: " + disciplina);
            }
        });
    }
}