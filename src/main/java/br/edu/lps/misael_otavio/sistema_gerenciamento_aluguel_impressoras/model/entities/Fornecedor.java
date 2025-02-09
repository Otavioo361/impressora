package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @Column(name = "id_fornecedor", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_fornecedor", nullable = false)
    private TipoFornecedor idTipoFornecedor;

    @Column(name = "nm_fornecedor", nullable = false, length = 120)
    private String nmFornecedor;

    @Column(name = "cd_url_site_fornecedor", length = 260)
    private String cdUrlSiteFornecedor;

    @Column(name = "nm_contato_fornecedor", length = 60)
    private String nmContatoFornecedor;

    @Column(name = "cd_telefone_contato_fornecedor", length = 20)
    private String cdTelefoneContatoFornecedor;

    @Column(name = "cd_email_contato_fornecedor", length = 60)
    private String cdEmailContatoFornecedor;

    @Column(name = "dt_inicio_contrato")
    private Instant dtInicioContrato;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private Instant dtInclusao;

    @Column(name = "dt_alteracao")
    private Instant dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_fornecedor_disponivel")
    private Boolean inFornecedorDisponivel;

    @Column(name = "dt_fim_contrato")
    private Instant dtFimContrato;

}