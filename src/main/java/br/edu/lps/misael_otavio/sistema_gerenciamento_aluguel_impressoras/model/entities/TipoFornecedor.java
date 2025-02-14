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
@Table(name = "tipo_fornecedor")
public class TipoFornecedor {
    @Id
    @Column(name = "id_tipo_fornecedor", nullable = false)
    private Integer id;

    @Column(name = "cd_tipo_fornecedor", nullable = false)
    private Integer cdTipoFornecedor;

    @Column(name = "nm_tipo_fornecedor", nullable = false, length = 30)
    private String nmTipoFornecedor;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_tipo_fornecedor_ativo", nullable = false)
    private Boolean inTipoFornecedorAtivo = false;

}