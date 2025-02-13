package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImpressoraDao {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();

    private final String queryFind = "SELECT\n" +
            "  im\n" +
            "FROM Impressora im\n" +
            "JOIN FETCH im.modeloImpressora mi\n" +
            "JOIN FETCH mi.taxa t\n" +
            "ORDER BY im.dtInclusao DESC";

    public List<Impressora> listarTop20() {
        return this.listar(20);
    }
    public List<Impressora> listar() {
        return this.listar(10);
    }
    private List<Impressora> listar(int quantidade) {
        TypedQuery<Impressora> query = entityManager.createQuery(this.queryFind, Impressora.class);
        return query.setMaxResults(quantidade).getResultList();
    }
}
