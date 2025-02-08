package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

public enum DefaultMessages {

    LOGIN_NAO_ENCONTRADO("Usuário não encontrado");

    private String message;
    DefaultMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
