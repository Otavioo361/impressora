package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "forma_pagamento")
public class FormaPagamento {
    @Id
    @Column(name = "id_forma_pagamento", nullable = false)
    private Integer id;

    @Column(name = "cd_forma_pagamento", nullable = false)
    private Integer cdFormaPagamento;

    @Column(name = "nm_forma_pagamento", nullable = false, length = 30)
    private String nmFormaPagamento;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_forma_pagamento_ativo", nullable = false)
    private Boolean inFormaPagamentoAtivo = false;

}