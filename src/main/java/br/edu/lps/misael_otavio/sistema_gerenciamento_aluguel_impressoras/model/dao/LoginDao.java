package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;


import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.LoginException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Login;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Marca;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

import java.util.List;

public class LoginDao {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());
    private final String queryFindLogin = "SELECT login from Login login WHERE login.cdEmail = :cd_email";


    public Login findByEmail(String email){
        logger.info("Realizando query na tabela de login buscando por {}", email);
        TypedQuery<Login> query = entityManager.createQuery(queryFindLogin, Login.class);

        query.setParameter("cd_email", email);
        List<Login> logins = query.setMaxResults(1).getResultList();

        if(logins.isEmpty()){
            logger.error("Login não encontrado");
            throw new LoginException(DefaultMessages.LOGIN_NAO_ENCONTRADO);
        }

        logger.info("Login encontrado");
        return logins.get(0);
    }

}
