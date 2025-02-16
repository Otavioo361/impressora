package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@ToString
@Table(name = "grupo_impressora")
public class GrupoImpressora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_impressora", nullable = false)
    private Long id;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "impressora_grupo_impressora",
            joinColumns = @JoinColumn(name = "id_grupo_impressora"),
            inverseJoinColumns = @JoinColumn(name = "id_impressora")
    )
    private List<Impressora> impressoras;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contrato", nullable = false)
    private Contrato contrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @Column(name = "nm_grupo_impressora", length = 64)
    private String nmGrupoImpressora;

    @Column(name = "qt_impressora")
    private Integer qtImpressora;

    @Column(name = "vl_aluguel_grupo_impressora", precision = 10, scale = 2)
    private BigDecimal vlAluguelGrupoImpressora;

    @Column(name = "in_grupo_finalizado")
    private Boolean inGrupoFinalizado;


    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}