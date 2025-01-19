package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.compositeIds.ConsumivelTaxaId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "consumivel_taxa")
public class ConsumivelTaxa {
    @EmbeddedId
    private ConsumivelTaxaId id;

    @MapsId("idConsumivel")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_consumivel", nullable = false)
    private Consumivel idConsumivel;

    @MapsId("idTaxa")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_taxa", nullable = false)
    private Taxa taxa;

    @Column(name = "qmn_consumivel", nullable = false)
    private Integer qmnConsumivel;

    @Column(name = "qmx_consumivel", nullable = false)
    private Integer qmxConsumivel;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}