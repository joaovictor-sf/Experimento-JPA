package av2.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue
    @Column(name = "dis_id")
    private Long ID;

    @Column(name = "nome_disciplina")
    private String nome_disciplina;
    
    public Disciplina(){

    }

    public Disciplina(String nome_disciplina){
        this.nome_disciplina = nome_disciplina;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }
}
