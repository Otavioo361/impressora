package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "endereco")
public class Endereco {
    @Id
    @Column(name = "id_endereco", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_uf", nullable = false)
    private Uf idUf;

    @Column(name = "nr_logradouro")
    private Integer nrLogradouro;

    @Column(name = "nm_logradouro", length = 120)
    private String nmLogradouro;

    @Column(name = "nm_bairro", length = 30)
    private String nmBairro;

    @Column(name = "nm_cep", length = 11)
    private String nmCep;

    @Column(name = "nm_complemento", length = 32)
    private String nmComplemento;

    @Column(name = "nm_referencia", length = 32)
    private String nmReferencia;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}