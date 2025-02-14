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
@Table(name = "banco")
public class Banco {
    @Id
    @Column(name = "id_banco", nullable = false)
    private Long id;

    @Column(name = "cd_banco", nullable = false)
    private Integer cdBanco;

    @Column(name = "nm_banco", nullable = false, length = 64)
    private String nmBanco;

    @Column(name = "in_banco_ativo", nullable = false)
    private Boolean inBancoAtivo = false;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

}