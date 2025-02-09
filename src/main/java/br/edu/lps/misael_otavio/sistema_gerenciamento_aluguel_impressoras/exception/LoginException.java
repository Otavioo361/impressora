package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;

public class LoginException extends AluguelImpressoraException{
    public LoginException(String mensagem) {
        super(mensagem);
    }
    public LoginException(DefaultMessages mensagem) {
        super(mensagem);
    }
    public LoginException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
    public LoginException(DefaultMessages mensagem, Throwable cause) {
        super(mensagem.getMessage(), cause);
    }
}
