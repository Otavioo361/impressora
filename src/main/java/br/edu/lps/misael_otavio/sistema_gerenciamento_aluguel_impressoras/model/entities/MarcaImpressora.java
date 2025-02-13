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
@Table(name = "marca_impressora")
public class MarcaImpressora {
    @Id
    @Column(name = "id_marca_impressora", nullable = false)
    private Integer id;

    @Column(name = "nm_marca_impressora", nullable = false, length = 30)
    private String nmMarcaImpressora;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_marca_impressora_ativo", nullable = false)
    private Boolean inMarcaImpressoraAtivo = false;

}