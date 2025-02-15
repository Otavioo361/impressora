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
@Table(name = "tipo_recorrencia")
public class TipoRecorrencia {
    @Id
    @Column(name = "id_tipo_recorrencia", nullable = false)
    private Integer id;

    @Column(name = "cd_tipo_recorrencia", nullable = false)
    private Integer cdTipoRecorrencia;

    @Column(name = "nm_tipo_recorrencia", nullable = false, length = 64)
    private String nmTipoRecorrencia;

    @Column(name = "ds_tipo_recorrencia", length = 64)
    private String dsTipoRecorrencia;

    @Column(name = "qt_dias_recorrencia")
    private Integer qtDiasRecorrencia;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_tipo_recorrencia_ativo", nullable = false)
    private Boolean inTipoRecorrenciaAtivo = false;

}