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
@Table(name = "consumivel")
public class Consumivel {
    @Id
    @Column(name = "id_consumivel", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "consumivel_taxa",
            joinColumns = @JoinColumn(name = "id_consumivel"),
            inverseJoinColumns = @JoinColumn(name = "id_taxa")
    )
    private Set<GrupoAcesso> gruposAcesso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_consumivel", nullable = false)
    private TipoConsumivel idTipoConsumivel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fornecedor_consumivel", nullable = false)
    private Fornecedor idFornecedorConsumivel;

    @Column(name = "cd_consumivel", nullable = false)
    private Integer cdConsumivel;

    @Column(name = "nm_consumivel", nullable = false, length = 30)
    private String nmConsumivel;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_consumivel_ativo", nullable = false)
    private Boolean inConsumivelAtivo = false;

}