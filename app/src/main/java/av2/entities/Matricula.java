package av2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_id")
    private Long idMatricula;

    @OneToOne
    @JoinColumn(name = "al_id", referencedColumnName = "al_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "dis_id", referencedColumnName = "dis_id")
    private Disciplina disciplina;

    @Column(name = "ma_data")
    private LocalDateTime dataMatricula;

    public Matricula() {
    }

    public Matricula(Aluno aluno, Disciplina disciplina, LocalDateTime dataMatricula) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.dataMatricula = dataMatricula;
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public LocalDateTime getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDateTime dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public void print(){
        System.out.println("Matricula: " + this.getIdMatricula() + " | " + this.getAluno().getNome() + " | " + this.getDisciplina().getNome_disciplina() + " | " + this.getDataMatricula());
    }
}
