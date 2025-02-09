package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table(name = "pessoa_fisica")
public class PessoaFisica {
    @Id
    @Column(name = "id_pessoa_fisica", nullable = false)
    private Long id;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    @Column(name = "in_ppe")
    private Boolean inPpe;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}