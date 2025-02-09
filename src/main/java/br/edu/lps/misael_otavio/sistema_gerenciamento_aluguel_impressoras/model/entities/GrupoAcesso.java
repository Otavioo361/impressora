package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "grupo_acesso")
public class GrupoAcesso {
    @Id
    @Column(name = "id_grupo_acesso", nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "acesso_grupo_acesso",
            joinColumns = @JoinColumn(name = "id_grupo_acesso"),
            inverseJoinColumns = @JoinColumn(name = "id_acesso")
    )
    private Set<Acesso> acessos;
    @Column(name = "cd_grupo_acesso", nullable = false, length = 30)
    private String cdGrupoAcesso;

    @Column(name = "nm_grupo_acesso", nullable = false, length = 30)
    private String nmGrupoAcesso;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

}