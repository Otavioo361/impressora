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
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_login", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "nm_username", length = 30)
    private String nmUsername;

    @Column(name = "cd_email", nullable = false, length = 60)
    private String cdEmail;

    @Column(name = "cd_cpf_cnpj", nullable = false, length = 14)
    private String cdCpfCnpj;

    @Column(name = "hash_password", length = 64)
    private String hashPassword;

    @Column(name = "in_login_ativo", nullable = false)
    private Boolean inLoginAtivo = false;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

}