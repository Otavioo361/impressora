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
@Table(name = "tipo_cliente")
public class TipoCliente {
    @Id
    @Column(name = "id_tipo_cliente", nullable = false)
    private Integer id;

    @Column(name = "cd_tipo_cliente", nullable = false)
    private Integer cdTipoCliente;

    @Column(name = "nm_tipo_cliente", nullable = false, length = 30)
    private String nmTipoCliente;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_tipo_cliente_ativo", nullable = false)
    private Boolean inTipoClienteAtivo = false;

}