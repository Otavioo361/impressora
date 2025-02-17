package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "pesquisa_satisfacao")
public class PesquisaSatisfacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pesquisa_satisfacao", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "qt_pontos_avaliados", columnDefinition = "tinyint not null")
    private Short qtPontosAvaliados;

    @Column(name = "tx_descricao_avalicao", length = 400)
    private String txDescricaoAvalicao;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false,insertable = false,updatable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}