package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.AluguelImpressoraException;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.SessionStorageSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.SessionModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.LoginDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.UsuarioDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service.PasswordService;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import lombok.extern.java.Log;

import java.util.HashMap;

public class LoginController {
    private final LoginDao loginDao = new LoginDao();
    private final UsuarioDao usuarioDao = new UsuarioDao();

    public DataResponseModel<SessionModel> validarLogin(String email, String password){
        try {

            Login login = this.loginDao.findByEmail(email);

            if(!PasswordService.validarSenha(password,login.getHashPassword())){
                return new DataResponseModel<>(
                        false,
                        DefaultMessages.USUARIO_SENHA_INCORRETOS.getMessage(),
                        null,
                        null
                );
            }

            Usuario usuario = this.usuarioDao.findGrupoAcessoByUsuario(login.getUsuario().getId());

            SessionModel session = new SessionModel(
                    true,
                    login.getId(),
                    usuario.getId(),
                    usuario.getNmUsuario(),
                    login.getCdCpfCnpj(),
                    usuario.getPessoa().getNmPessoa(),
                    usuario.getGruposAcesso(),
                    this.montarTelas(usuario)
            );

            SessionStorageSingleton.set("session", session);
            SessionStorageSingleton.set("nomeUsuario", usuario.getPessoa().getNmPessoa());
            SessionStorageSingleton.set("nmUsuario", usuario.getNmUsuario());
            SessionStorageSingleton.set("idUsuario", usuario.getId());

            return new DataResponseModel<>(
                    true,
                    DefaultMessages.LOGIN_SUCESSO.getMessage(),
                    session,
                    null
            );
        }catch (AluguelImpressoraException e){
            return new DataResponseModel<>(false,e.getMessage(),null,e);
        }
    }

    private HashMap<String, Acesso> montarTelas(Usuario usuario){
        HashMap<String, Acesso> telas = new HashMap<>();
        for(GrupoAcesso grupoAcesso : usuario.getGruposAcesso()){
            for (Acesso acesso : grupoAcesso.getAcessos()){
              telas.put(acesso.getTela().getCdTela(), acesso);
            }
        }
        return telas;
    }
}
