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
@Table(name = "modelo_impressora")
public class ModeloImpressora {
    @Id
    @Column(name = "id_modelo_impressora", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_marca_impressora", nullable = false)
    private MarcaImpressora marcaImpressora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_impressora", nullable = false)
    private TipoImpressora tipoImpressora;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_taxa", nullable = false)
    private Taxa taxa;

    @Column(name = "nm_modelo_impressora", nullable = false, length = 64)
    private String nmModeloImpressora;

    @Column(name = "qt_impressora")
    private Integer qtImpressora;

    @Column(name = "qt_impressora_disponivel")
    private Integer qtImpressoraDisponivel;

    @Column(name = "qt_impressora_alugada")
    private Integer qtImpressoraAlugada;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_modelo_impressora_ativo", nullable = false)
    private Boolean inModeloImpressoraAtivo = false;

}