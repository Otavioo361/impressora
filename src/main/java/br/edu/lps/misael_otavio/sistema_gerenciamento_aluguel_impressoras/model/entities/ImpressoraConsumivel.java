package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.compositeIds.ImpressoraConsumivelId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "impressora_consumivel")
public class ImpressoraConsumivel {
    @EmbeddedId
    private ImpressoraConsumivelId id;

    @MapsId("idImpressora")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_impressora", nullable = false)
    private Impressora idImpressora;

    @MapsId("idConsumivel")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_consumivel", nullable = false)
    private Consumivel idConsumivel;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}