package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.compositeIds.UsuarioGrupoAcessoId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "usuario_grupo_acesso")
public class UsuarioGrupoAcesso {
    @EmbeddedId
    private UsuarioGrupoAcessoId id;

    @MapsId("idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @MapsId("idGrupoAcesso")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_grupo_acesso", nullable = false)
    private GrupoAcesso idGrupoAcesso;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}