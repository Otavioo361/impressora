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
@Table(name = "tipo_cliente")
public class TipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_cliente", nullable = false)
    private Integer id;

    @Column(name = "cd_tipo_cliente", nullable = false)
    private Integer cdTipoCliente;

    @Column(name = "nm_tipo_cliente", nullable = false, length = 30)
    private String nmTipoCliente;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_tipo_cliente_ativo", nullable = false)
    private Boolean inTipoClienteAtivo = false;

}