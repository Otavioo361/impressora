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
public class ImpressoraGrupoImpressoraId implements java.io.Serializable {
    private static final long serialVersionUID = -3555742752101900339L;
    @Column(name = "id_grupo_impressora", nullable = false)
    private Long idGrupoImpressora;

    @Column(name = "id_impressora", nullable = false)
    private Long idImpressora;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ImpressoraGrupoImpressoraId entity = (ImpressoraGrupoImpressoraId) o;
        return Objects.equals(this.idGrupoImpressora, entity.idGrupoImpressora) &&
                Objects.equals(this.idImpressora, entity.idImpressora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrupoImpressora, idImpressora);
    }

}