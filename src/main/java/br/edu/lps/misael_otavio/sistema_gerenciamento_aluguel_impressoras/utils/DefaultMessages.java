package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import java.util.List;

public enum DefaultMessages {
    //SUCESSO
    CONSULTA_SUCESSO("Consulta de %s feita com sucesso!"),
    CADASTRADO_SUCESSO("%s cadastrado com sucesso!"),
    LOGIN_SUCESSO("Usuário logado com sucesso!"),
    //ERROS
    CADASTRADO_ERROR("Falha ao cadastrar %s"),
    USUARIO_SENHA_INCORRETOS("Email ou senha incorretos!"),
    LOGIN_NAO_ENCONTRADO("Usuário não encontrado!"),
    USUARIO_SEM_PERMISSOES("Usuário não possui permissões!"),
    EMAIL_INVALIDO("O Email informádo é inválido!"),
    CONSULTA_ERROR("Falha ao realizar a consulta de %s!"),
    ERRO_FOMULARIO("<html>Falha ao processar formulario.<br> Erros: <br>&nbsp;&nbsp;&nbsp;&nbsp; %s </html>"),
    ERRO_DADOS_NAO_ENCOTRADO("Operação cancelada, sem dados suficiente.");

    private String message;
    DefaultMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
    public String formatMessage(String message){
        return String.format(this.getMessage(),message);
    }
    public String formatMessage(List<String> message){
        return String.format(this.getMessage(), String.join("<br>&nbsp;&nbsp;&nbsp;&nbsp;", message));
    }
}
