package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "taxa")
public class Taxa {
    @Id
    @Column(name = "id_taxa", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_taxa", nullable = false)
    private TipoTaxa idTipoTaxa;

    @Column(name = "vl_taxa", nullable = false, precision = 10, scale = 2)
    private BigDecimal vlTaxa;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_taxa_ativo", nullable = false)
    private Boolean inTaxaAtivo = false;

}