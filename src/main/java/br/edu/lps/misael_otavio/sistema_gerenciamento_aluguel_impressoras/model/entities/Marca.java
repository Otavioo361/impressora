package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @Column(name = "id_marca", nullable = false)
    private Integer id;

    @Column(name = "nm_marca", nullable = false, length = 30)
    private String nmMarca;

    @ColumnDefault("getdate()")
    @Column(name = "dt_inclusao", nullable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @Column(name = "nm_usuario", length = 60)
    private String nmUsuario;

    @Column(name = "in_marca_ativo", nullable = false)
    private Boolean inMarcaAtivo = false;

}