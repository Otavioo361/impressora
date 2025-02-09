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
@Table(name = "cartao")
public class Cartao {
    @Id
    @Column(name = "id_cartao", nullable = false)
    private Long id;

    @Column(name = "cd_token_cartao", length = 64)
    private String cdTokenCartao;

    @Column(name = "cd_ultimos_digitos", length = 4)
    private String cdUltimosDigitos;

    @Column(name = "dt_validade", length = 7)
    private String dtValidade;

    @Column(name = "in_cartao_ativo", nullable = false)
    private Boolean inCartaoAtivo = false;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}