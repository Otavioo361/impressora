package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ImpressoraTaxaId implements java.io.Serializable {
    private static final long serialVersionUID = -1195057613827171622L;
    @Column(name = "id_impressora", nullable = false)
    private Long idImpressora;

    @Column(name = "id_taxa", nullable = false)
    private Long idTaxa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ImpressoraTaxaId entity = (ImpressoraTaxaId) o;
        return Objects.equals(this.idTaxa, entity.idTaxa) &&
                Objects.equals(this.idImpressora, entity.idImpressora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTaxa, idImpressora);
    }

}