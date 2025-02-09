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
@Table(name = "tipo_consumivel")
public class TipoConsumivel {
    @Id
    @Column(name = "id_tipo_consumivel", nullable = false)
    private Integer id;

    @Column(name = "cd_tipo_consumivel", nullable = false)
    private Integer cdTipoConsumivel;

    @Column(name = "nm_tipo_consumivel", nullable = false, length = 30)
    private String nmTipoConsumivel;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_tipo_consumivel_ativo", nullable = false)
    private Boolean inTipoConsumivelAtivo = false;

    @Column(name = "dt_desativacao", nullable = false)
    private LocalDateTime dtDesativacao;

}