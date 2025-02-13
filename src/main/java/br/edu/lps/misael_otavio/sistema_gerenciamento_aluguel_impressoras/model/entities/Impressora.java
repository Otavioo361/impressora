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
@Table(name = "impressora")
public class Impressora {
    @Id
    @Column(name = "id_impressora", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fornecedor_impressora", nullable = false)
    private Fornecedor fornecedorImpressora;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_modelo_impressora", nullable = false)
    private ModeloImpressora modeloImpressora;

    @Column(name = "cd_serie_impressora", nullable = false, length = 20)
    private String cdSerieImpressora;

    @Column(name = "cd_barras_impressora", nullable = false, length = 9)
    private String cdBarrasImpressora;

    @ColumnDefault("getdate()")
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