package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.compositeIds;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UsuarioGrupoAcessoId implements java.io.Serializable {
    private static final long serialVersionUID = -6127031877153091673L;
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_grupo_acesso", nullable = false)
    private Long idGrupoAcesso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioGrupoAcessoId entity = (UsuarioGrupoAcessoId) o;
        return Objects.equals(this.idUsuario, entity.idUsuario) &&
                Objects.equals(this.idGrupoAcesso, entity.idGrupoAcesso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idGrupoAcesso);
    }

}