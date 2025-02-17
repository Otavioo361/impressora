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
@Table(name = "plano_pagamento")
public class PlanoPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano_pagamento", nullable = false)
    private Long id;

    @Column(name = "id_forma_pagamento", nullable = false)
    private Integer idFormaPagamento;

    @Column(name = "cd_plano_pagamento", nullable = false)
    private Long cdPlanoPagamento;

    @Column(name = "nm_plano_pagamento", length = 32)
    private String nmPlanoPagamento;

    @Column(name = "qt_min_parcelas", columnDefinition = "tinyint not null")
    private Short qtMinParcelas;

    @Column(name = "qt_max_parcelas", columnDefinition = "tinyint not null")
    private Short qtMaxParcelas;

    @Column(name = "in_a_vista", nullable = false)
    private Boolean inAVista = false;

    @Column(name = "in_cobranca_recorrente", nullable = false)
    private Boolean inCobrancaRecorrente = false;

    @Column(name = "in_cobranca_primeira_ato", nullable = false)
    private Boolean inCobrancaPrimeiraAto = false;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}