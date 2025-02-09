package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica {
    @Id
    @Column(name = "id_pessoa_juridica", nullable = false)
    private Long id;

    @Column(name = "nm_razao_social", length = 60)
    private String nmRazaoSocial;

    @Column(name = "dt_abertura")
    private LocalDate dtAbertura;

    @Column(name = "nm_natureza_jurica", length = 120)
    private String nmNaturezaJurica;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}