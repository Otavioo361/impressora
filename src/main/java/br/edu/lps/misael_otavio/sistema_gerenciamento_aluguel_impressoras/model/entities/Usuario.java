package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa idPessoa;

    @Column(name = "nm_usuario", nullable = false, length = 30)
    private String nmUsuario;

    @Column(name = "nm_password")
    private byte[] nmPassword;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "in_usuario_ativo", nullable = false)
    private Boolean inUsuarioAtivo = false;

}