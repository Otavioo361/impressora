
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception;

/**
 *
 * @author otavi
 */
public class ImpreException extends RuntimeException {  
    public ImpreException(String message) {
        super(message);
    }

    public ImpreException(String message, Throwable cause) {
        super(message, cause);
    }
}
