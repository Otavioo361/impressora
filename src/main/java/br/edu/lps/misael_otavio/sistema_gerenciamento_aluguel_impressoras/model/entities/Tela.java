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
@Table(name = "tela")
public class Tela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tela", nullable = false)
    private Long id;

    @Column(name = "cd_tela", nullable = false, length = 30)
    private String cdTela;

    @Column(name = "nm_tela", nullable = false, length = 30)
    private String nmTela;

    @ColumnDefault("DATETIMEOFFSET(6)")
    @Column(name = "dt_inclusao", insertable = false)
    private LocalDateTime dtInclusao;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

}