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
@Table(name = "tipo_impressora")
public class TipoImpressora {
    @Id
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
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_tipo_impressora_ativo", nullable = false)
    private Boolean inTipoImpressoraAtivo = false;

}