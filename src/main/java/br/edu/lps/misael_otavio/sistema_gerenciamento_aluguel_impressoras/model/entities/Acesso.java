package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "acesso")
public class Acesso {
    @Id
    @Column(name = "id_acesso", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "acesso_grupo_acesso",
            joinColumns = @JoinColumn(name = "id_acesso"),
            inverseJoinColumns = @JoinColumn(name = "id_grupo_acesso")
    )
    private Set<GrupoAcesso> gruposAcesso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tela", nullable = false)
    private Tela idTela;

    @Column(name = "cd_acesso", nullable = false, length = 30)
    private String cdAcesso;

    @Column(name = "nm_acesso", nullable = false, length = 30)
    private String nmAcesso;

    @Column(name = "in_read", nullable = false)
    private Boolean inRead = false;

    @Column(name = "in_create", nullable = false)
    private Boolean inCreate = false;

    @Column(name = "in_update", nullable = false)
    private Boolean inUpdate = false;

    @Column(name = "in_delete", nullable = false)
    private Boolean inDelete = false;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

}