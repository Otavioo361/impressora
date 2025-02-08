package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service;
import org.mindrot.jbcrypt.BCrypt;


public class PasswordService {
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public static boolean validarSenha(String senha, String passwordHash){
        return BCrypt.checkpw (senha,passwordHash);
    }
}
