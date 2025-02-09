package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;


import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.LoginException;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.EntityManagerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Login;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

public class LoginDao {
    private final EntityManager entityManager = EntityManagerSingleton.createEntityManager();
    private final Logger logger =  LoggerSingleton.getLogger(this.getClass());
    private final String queryFindLogin = "SELECT login.* FROM aluguel_impressora.dbo.login login \n" +
            "WHERE login.cd_email = :cd_email\n" +
            " AND login.hash_password = :hash_password";


    public Login findByEmailAndPassword(String email, String hashPassword){
        logger.info("Realizando query na tabela de login buscando por {}", email);
        TypedQuery<Login> qry = this.entityManager.createQuery(this.queryFindLogin, Login.class);

        qry.setParameter("cd_email", email);
        qry.setParameter("hash_password", hashPassword);
        Login login = qry.getSingleResult();

        if(login == null){
            logger.error("Login não encontrado");
            throw new LoginException(DefaultMessages.LOGIN_NAO_ENCONTRADO);
        }
        logger.info("Login encontrado");
        return login;
    }

}
