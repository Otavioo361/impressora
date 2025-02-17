package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;


import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.LoginException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Login;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.slf4j.Logger;

public class LoginDao {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());
    private final String queryFindLogin = "SELECT login from Login login WHERE login.cdEmail = :cd_email";


    public Login findByEmail(String email){
        logger.info("Realizando query na tabela de login buscando por {}", email);
        Query qry = entityManager.createQuery(queryFindLogin, Login.class);
        qry.setParameter("cd_email", email);
        Login login = (Login)qry.getSingleResult();

        if(login == null){
            logger.error("Login não encontrado");
            throw new LoginException(DefaultMessages.LOGIN_NAO_ENCONTRADO);
        }

        logger.info("Login encontrado");
        return login;
    }

}
