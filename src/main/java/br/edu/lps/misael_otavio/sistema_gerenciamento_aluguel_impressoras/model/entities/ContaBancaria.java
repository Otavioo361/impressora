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
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
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

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}