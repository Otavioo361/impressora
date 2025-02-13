package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "modelo_consumivel")
public class ModeloConsumivel {
    @Id
    @Column(name = "id_modelo_consumivel", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_marca_consumivel", nullable = false)
    private Marca marcaConsumivel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_consumivel", nullable = false)
    private TipoConsumivel tipoConsumivel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_taxa", nullable = false)
    private Taxa taxa;

    @Column(name = "nm_modelo_consumivel", nullable = false, length = 64)
    private String nmModeloConsumivel;

    @Column(name = "qt_consumivel")
    private Integer qtConsumivel;

    @Column(name = "qt_consumivel_disponivel")
    private Integer qtConsumivelDisponivel;

    @Column(name = "qt_consumivel_alugada")
    private Integer qtConsumivelAlugada;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_modelo_consumivel_ativo", nullable = false)
    private Boolean inModeloConsumivelAtivo = false;

}