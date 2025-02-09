package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoAcesso;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Usuario;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.UsuarioGrupoAcesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

public class GrupoAcessoDao {

    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());
    private final String queryFindAccess = "SELECT\n" +
            "  *\n" +
            "FROM aluguel_impressora.dbo.usuario_grupo_acesso uga\n" +
            "  INNER JOIN aluguel_impressora.dbo.grupo_acesso ga\n" +
            "    ON uga.id_grupo_acesso = ga.id_grupo_acesso\n" +
            "  INNER JOIN aluguel_impressora.dbo.acesso_grupo_acesso aga\n" +
            "    ON aga.id_grupo_acesso = ga.id_grupo_acesso\n" +
            "  INNER JOIN aluguel_impressora.dbo.acesso a\n" +
            "    ON aga.id_acesso = a.id_acesso\n" +
            "  INNER JOIN aluguel_impressora.dbo.tela t\n" +
            "    ON a.id_tela = t.id_tela" +
            "WHERE uga.id_usuario = :idUsuario";

    public UsuarioGrupoAcesso findGrupoAcessobyUsuario(Usuario usuario) {
        TypedQuery<UsuarioGrupoAcesso> qry = this.entityManager.createQuery(this.queryFindAccess, UsuarioGrupoAcesso.class);
        qry.setParameter("idUsuario", usuario.getId());
        return qry.getSingleResult();
    }
}
