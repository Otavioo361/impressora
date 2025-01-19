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
public class ImpressoraConsumivelId implements java.io.Serializable {
    private static final long serialVersionUID = -1180989442948733319L;
    @Column(name = "id_impressora", nullable = false)
    private Long idImpressora;

    @Column(name = "id_consumivel", nullable = false)
    private Long idConsumivel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ImpressoraConsumivelId entity = (ImpressoraConsumivelId) o;
        return Objects.equals(this.idConsumivel, entity.idConsumivel) &&
                Objects.equals(this.idImpressora, entity.idImpressora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConsumivel, idImpressora);
    }

}