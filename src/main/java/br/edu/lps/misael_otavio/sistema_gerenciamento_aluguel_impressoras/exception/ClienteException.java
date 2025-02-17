package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception;

public class ClienteException extends AluguelImpressoraException {
    public ClienteException(String mensagem) {
        super(mensagem);
    }
    public ClienteException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }
}
