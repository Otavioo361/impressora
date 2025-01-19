package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "impressora_taxa")
public class ImpressoraTaxa {
    @EmbeddedId
    private ImpressoraTaxaId id;

    @MapsId("idImpressora")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_impressora", nullable = false)
    private Impressora idImpressora;

    @MapsId("idTaxa")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_taxa", nullable = false)
    private Taxa taxa;

    @Column(name = "qmn_impressora", nullable = false)
    private Integer qmnImpressora;

    @Column(name = "qmx_impressora", nullable = false)
    private Integer qmxImpressora;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}