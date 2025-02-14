package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "grupo_impressora")
public class GrupoImpressora {
    @Id
    @Column(name = "id_grupo_impressora", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "impressora_grupo_impressora",
            joinColumns = @JoinColumn(name = "id_grupo_impressora"),
            inverseJoinColumns = @JoinColumn(name = "id_impressora")
    )
    private Set<Impressora> impressoras;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_contrato", nullable = false)
    private Contrato idContrato;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco idEndereco;

    @Column(name = "nm_grupo_impressora", length = 64)
    private String nmGrupoImpressora;

    @Column(name = "qt_impressora")
    private Integer qtImpressora;

    @Column(name = "vl_aluguel_grupo_impressora", precision = 10, scale = 2)
    private BigDecimal vlAluguelGrupoImpressora;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}