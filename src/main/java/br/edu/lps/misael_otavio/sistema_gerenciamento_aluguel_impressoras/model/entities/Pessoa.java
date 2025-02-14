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
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @Column(name = "id_pessoa", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa_fisica")
    private PessoaFisica pessoaFisica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa_juridica")
    private PessoaJuridica pessoaJuridica;

    @Column(name = "cd_cpf_cnpj", nullable = false, length = 14)
    private String cdCpfCnpj;

    @Column(name = "nm_pessoa", length = 60)
    private String nmPessoa;

    @Column(name = "cd_email", nullable = false, length = 120)
    private String cdEmail;

    @Column(name = "nr_ddd")
    private Integer nrDdd;

    @Column(name = "nr_telefone")
    private Integer nrTelefone;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}