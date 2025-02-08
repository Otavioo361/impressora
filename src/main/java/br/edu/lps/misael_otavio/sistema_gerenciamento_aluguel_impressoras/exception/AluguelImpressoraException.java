
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;

/**
 *
 * @author otavi
 */
public class AluguelImpressoraException extends RuntimeException {
    public AluguelImpressoraException(String message) {
        super(message);
    }
    public AluguelImpressoraException(DefaultMessages message) {
        super(message.getMessage());
    }

    public AluguelImpressoraException(String message, Throwable cause) {
        super(message, cause);
    }
}
