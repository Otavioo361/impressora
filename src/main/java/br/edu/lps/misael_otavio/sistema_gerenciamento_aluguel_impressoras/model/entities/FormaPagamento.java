package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {
    @Id
    @Column(name = "id_forma_pagamento", nullable = false)
    private Integer id;

    @Column(name = "cd_forma_pagamento", nullable = false)
    private Integer cdFormaPagamento;

    @Column(name = "nm_forma_pagamento", nullable = false, length = 30)
    private String nmFormaPagamento;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_forma_pagamento_ativo", nullable = false)
    private Boolean inFormaPagamentoAtivo = false;

}