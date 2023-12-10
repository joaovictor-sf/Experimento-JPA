package av2;

import av2.entities.Aluno;
import av2.entities.Disciplina;
import av2.entities.Matricula;
import av2.services.MatriculaService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("Iniciando...");



        Aluno aluno = new Aluno("João", LocalDateTime.now(), "São Paulo");
        Aluno aluno2 = new Aluno("Maria", LocalDateTime.now(), "Rio de Janeiro");
        Disciplina disciplina = new Disciplina("Matemática");
        Matricula matricula = new Matricula(aluno, disciplina, LocalDateTime.now());
        Matricula matricula1 = new Matricula(aluno2, disciplina, LocalDateTime.now());

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();

        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Aluno.class)
                    .addAnnotatedClass(Disciplina.class)
                    .addAnnotatedClass(Matricula.class)
                    .buildMetadata()
                    .buildSessionFactory();

            MatriculaService matriculaService = new MatriculaService(sessionFactory);

            sessionFactory.inTransaction(session -> {
                session.persist(aluno);
                session.persist(aluno2);
                session.persist(disciplina);
                session.persist(matricula);
                session.persist(matricula1);
            });
            sessionFactory.inTransaction(session -> {
                List<Matricula> matriculas = session.createQuery("from Matricula", Matricula.class).getResultList();
                System.out.println("Matriculas Encontradas:");
                //Matricula.forEach(matricula -> matricula.print());
                matriculas.forEach(Matricula -> Matricula.print());
                System.out.println("Total de Matriculas: " + matriculas.size());

                matriculaService.atualizarDadosdoAluno((long) 1, "estragogildobigo",LocalDateTime.now(), "são paulo");
            });
            sessionFactory.inTransaction(session -> {
                    List<Object[]> listaAlunos = session.createQuery("SELECT nome, dataNascimento FROM Aluno", Object[].class).list();

                for (Object[] alunos : listaAlunos) {
                    String nome = (String) alunos[0];
                    LocalDateTime dataNascimento = (LocalDateTime) alunos[1];
                    System.out.println("Nome: " + nome + ", DataNascimento: " + dataNascimento.toString());
                }
            });

        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }

        System.out.println("Fim!");
    }
}
