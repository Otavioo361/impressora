package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.LoginDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Login;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service.PasswordService;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DataResponse;

public class LoginController {
    private final LoginDao loginDao = new LoginDao();

    public DataResponse validarLogin(String email, String password){
        try {

            String hashedPassword = PasswordService.hash(password);

            Login login = this.loginDao.findByEmailAndPassword(email,hashedPassword);


        }catch (AluguelImpressoraException e){
            return new DataResponse(false,e.getMessage(),null,e);
        }
    return new DataResponse(true,null,null,null);
    }
}
