package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "login")
public class Login {
    @Id
    @Column(name = "id_login", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "nm_login", length = 30)
    private String nmLogin;

    @Column(name = "cd_email", nullable = false, length = 60)
    private String cdEmail;

    @Column(name = "cd_cpf_cnpj", nullable = false, length = 14)
    private String cdCpfCnpj;

    @Column(name = "hash_password")
    private byte[] hashPassword;

    @Column(name = "cd_salt_password", length = 8)
    private String cdSaltPassword;

    @Column(name = "in_login_ativo", nullable = false)
    private Boolean inLoginAtivo = false;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

}