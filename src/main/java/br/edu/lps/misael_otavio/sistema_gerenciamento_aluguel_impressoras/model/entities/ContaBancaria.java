package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria {
    @Id
    @Column(name = "id_conta_bancaria", nullable = false)
    private Long id;

    @Column(name = "id_banco", nullable = false)
    private Long idBanco;

    @Column(name = "nr_agencia", nullable = false)
    private Integer nrAgencia;

    @Column(name = "cd_agencia_dv")
    private Integer cdAgenciaDv;

    @Column(name = "nr_conta_bancaria", nullable = false)
    private Integer nrContaBancaria;

    @Column(name = "cd_conta_bancaria_dv", nullable = false)
    private Integer cdContaBancariaDv;

    @Column(name = "in_conta_bancaria_ativo", nullable = false)
    private Boolean inContaBancariaAtivo = false;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}