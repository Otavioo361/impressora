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
@Table(name = "impressora")
public class Impressora {
    @Id
    @Column(name = "id_impressora", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "impressora_consumivel",
            joinColumns = @JoinColumn(name = "id_impressora"),
            inverseJoinColumns = @JoinColumn(name = "id_consumivel")
    )
    private Set<Consumivel> consumiveis;

    @ManyToMany
    @JoinTable(
            name = "impressora_taxa",
            joinColumns = @JoinColumn(name = "id_impressora"),
            inverseJoinColumns = @JoinColumn(name = "id_taxa")
    )
    private Set<Taxa> taxas;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_impressora", nullable = false)
    private TipoImpressora idTipoImpressora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fornecedor_impressora", nullable = false)
    private Fornecedor idFornecedorImpressora;

    @Column(name = "id_taxa_impressora", nullable = false)
    private Integer idTaxaImpressora;

    @Column(name = "cd_serie_impressora", nullable = false, length = 20)
    private String cdSerieImpressora;

    @Column(name = "cd_barras_impressora", nullable = false, length = 9)
    private String cdBarrasImpressora;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "dt_ultima_locacao")
    private LocalDateTime dtUltimaLocacao;

    @Column(name = "in_impressora_alugada")
    private Boolean inImpressoraAlugada;

    @Column(name = "in_impressora_disponivel")
    private Boolean inImpressoraDisponivel;

}