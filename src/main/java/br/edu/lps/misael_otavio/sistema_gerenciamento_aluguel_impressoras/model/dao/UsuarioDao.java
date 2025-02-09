package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Usuario;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.UsuarioGrupoAcesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.slf4j.Logger;

import java.util.List;

public class UsuarioDao {

    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger = LoggerSingleton.getLogger(this.getClass());
    private final String queryFindUsuario = "SELECT\n" +
            "  u\n" +
            "FROM Usuario u\n" +
            "  JOIN FETCH u.gruposAcesso ga\n" +
            "  JOIN FETCH ga.acessos a\n" +
            "  JOIN FETCH a.tela\n" +
            "WHERE u.id = :idUsuario";

    public Usuario findGrupoAcessoByUsuario(Long idUsuario) {
        Query query = entityManager.createQuery(queryFindUsuario, UsuarioGrupoAcesso.class);
        query.setParameter("idUsuario", idUsuario);
        return (Usuario)query.getSingleResult();
    }

}
