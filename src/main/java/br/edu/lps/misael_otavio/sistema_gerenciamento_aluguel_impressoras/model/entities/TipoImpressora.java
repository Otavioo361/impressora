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
@Table(name = "tipo_impressora")
public class TipoImpressora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_impressora", nullable = false)
    private Integer id;

    @Column(name = "cd_tipo_impressora", nullable = false)
    private Integer cdTipoImpressora;

    @Column(name = "nm_tipo_impressora", nullable = false, length = 30)
    private String nmTipoImpressora;

    @Column(name = "qt_impressora")
    private Integer qtImpressora;

    @Column(name = "qt_impressora_disponivel")
    private Integer qtImpressoraDisponivel;

    @Column(name = "qt_impressora_alugada")
    private Integer qtImpressoraAlugada;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_tipo_impressora_ativo", nullable = false)
    private Boolean inTipoImpressoraAtivo = false;

}