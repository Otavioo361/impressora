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
@Table(name = "consumivel")
public class Consumivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumivel", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_consumivel", nullable = false)
    private TipoConsumivel tipoConsumivel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fornecedor_consumivel", nullable = false)
    private Fornecedor fornecedorConsumivel;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_modelo_consumivel", nullable = false)
    private ModeloConsumivel modeloConsumivel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_impressora")
    private Impressora impressora;

    @Column(name = "cd_barras_consumivel", nullable = false, length = 30)
    private String cdBarrasConsumivel;

    @Column(name = "nm_consumivel", nullable = false, length = 30)
    private String nmConsumivel;

    @Column(name = "dt_consumido")
    private LocalDateTime dtConsumido;

    @Column(name = "in_em_consumo", nullable = false)
    private Boolean inEmConsumo = false;

    @Column(name = "dt_validade_consumivel")
    private LocalDateTime dtValidadeConsumivel;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_consumivel_ativo", nullable = false)
    private Boolean inConsumivelAtivo = false;

}