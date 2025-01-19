package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "grupo_acesso")
public class GrupoAcesso {
    @Id
    @Column(name = "id_grupo_acesso", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_acesso", nullable = false)
    private Acesso idAcesso;

    @Column(name = "cd_grupo_acesso", nullable = false, length = 30)
    private String cdGrupoAcesso;

    @Column(name = "nm_grupo_acesso", nullable = false, length = 30)
    private String nmGrupoAcesso;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

}