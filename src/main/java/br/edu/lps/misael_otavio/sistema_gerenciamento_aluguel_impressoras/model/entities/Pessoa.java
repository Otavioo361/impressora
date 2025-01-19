package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author otavi
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nm_pessoa", nullable = false, length = 100)
    private String nmPessoa;

    @Column(name = "sexo", nullable = false, length = 1)
    private String cdSexo;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dtNascimento;


    @Override
    public String toString() {
        return "Nome: " + this.nome +"\n"
        +"Sexo: "+ this.sexo + "\n"
        +"Idade: "+ this.idade+"\n";
    }   

    
}