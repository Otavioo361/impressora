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
@Table(name = "cartao")
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}