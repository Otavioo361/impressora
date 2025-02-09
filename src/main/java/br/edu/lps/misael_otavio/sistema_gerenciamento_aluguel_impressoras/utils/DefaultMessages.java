package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

public enum DefaultMessages {

    LOGIN_NAO_ENCONTRADO("Usuário não encontrado"),
    USUARIO_SENHA_INCORRETOS("Email ou senha incorretos!"),
    LOGIN_SUCESSO("Usuário logado com sucesso!"),
    EMAIL_INVALIDO("O Email informádo é inválido.");
    
    private String message;
    DefaultMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
