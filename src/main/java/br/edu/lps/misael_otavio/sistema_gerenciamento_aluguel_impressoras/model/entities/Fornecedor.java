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
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_fornecedor", nullable = false)
    private TipoFornecedor tipoFornecedor;

    @Column(name = "nm_fornecedor", nullable = false, length = 120)
    private String nmFornecedor;

    @Column(name = "cd_cnpj_fornecedor", nullable = false, length = 14)
    private String cdCnpjFornecedor;

    @Column(name = "cd_url_site_fornecedor", length = 260)
    private String cdUrlSiteFornecedor;

    @Column(name = "nm_contato_fornecedor", length = 60)
    private String nmContatoFornecedor;

    @Column(name = "cd_telefone_contato_fornecedor", length = 20)
    private String cdTelefoneContatoFornecedor;

    @Column(name = "cd_email_contato_fornecedor", length = 60)
    private String cdEmailContatoFornecedor;

    @Column(name = "dt_inicio_contrato")
    private LocalDateTime dtInicioContrato;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_fornecedor_disponivel")
    private Boolean inFornecedorDisponivel;

    @Column(name = "dt_fim_contrato")
    private LocalDateTime dtFimContrato;

}