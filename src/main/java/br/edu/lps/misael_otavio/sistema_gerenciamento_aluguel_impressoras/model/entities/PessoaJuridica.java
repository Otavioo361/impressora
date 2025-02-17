package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
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
@Table(name = "pessoa_juridica")
public class PessoaJuridica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa_juridica", nullable = false)
    private Long id;

    @Column(name = "nm_razao_social", length = 60)
    private String nmRazaoSocial;

    @Column(name = "dt_abertura")
    private LocalDate dtAbertura;

    @Column(name = "nm_natureza_jurica", length = 120)
    private String nmNaturezaJurica;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}