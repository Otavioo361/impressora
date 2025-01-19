/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
