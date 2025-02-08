package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "dado_cobranca")
public class DadoCobranca {
    @Id
    @Column(name = "id_dado_cobranca", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_forma_pagamento", nullable = false)
    private FormaPagamento idFormaPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cartao")
    private Cartao idCartao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conta_bancaria")
    private ContaBancaria idContaBancaria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_boleto")
    private Boleto idBoleto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dado_cobranca_alternativo")
    private DadoCobranca idDadoCobrancaAlternativo;

    @Column(name = "in_dado_cobranca_ativo", nullable = false)
    private Boolean inDadoCobrancaAtivo = false;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}