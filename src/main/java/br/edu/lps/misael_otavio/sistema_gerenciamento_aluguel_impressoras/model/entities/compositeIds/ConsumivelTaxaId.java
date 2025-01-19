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
public class ConsumivelTaxaId implements java.io.Serializable {
    private static final long serialVersionUID = -6486758444667250184L;
    @Column(name = "id_consumivel", nullable = false)
    private Long idConsumivel;

    @Column(name = "id_taxa", nullable = false)
    private Long idTaxa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ConsumivelTaxaId entity = (ConsumivelTaxaId) o;
        return Objects.equals(this.idTaxa, entity.idTaxa) &&
                Objects.equals(this.idConsumivel, entity.idConsumivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTaxa, idConsumivel);
    }

}