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
@Table(name = "impressora_taxa")
public class ImpressoraTaxa {
    @Id
    @Column(name = "id_impressora_taxa", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_impressora", nullable = false)
    private Impressora idImpressora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_taxa", nullable = false)
    private Taxa idTaxa;

    @Column(name = "qmn_impressora", nullable = false)
    private Integer qmnImpressora;

    @Column(name = "qmx_impressora", nullable = false)
    private Integer qmxImpressora;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}