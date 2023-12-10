package av2.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_aluno")
public class Aluno {

    @Id
    @GeneratedValue
    @Column(name = "al_id")
    private Long id;

    @Column(name = "al_nome")
    private String nome;

    @Column(name = "al_nascimento")
    private LocalDateTime dataNascimento;

    @Column(name = "al_cidade_natal")
    private String cidadeNatal;

    public Aluno() {
    }

    public Aluno(String nome, LocalDateTime dataNascimento, String cidadeNatal) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cidadeNatal = cidadeNatal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidadeNatal() {
        return cidadeNatal;
    }

    public void setCidadeNatal(String cidadeNatal) {
        this.cidadeNatal = cidadeNatal;
    }
}
