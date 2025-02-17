package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScreensName {
    IMPRESSORAS("IMPRESSORA","Impressoras"),
    FORNECEDORES("FORNECEDOR","Fornecedores"),
    CLIENTES("CLIENTE","Clientes"),
    MODELO_IMPRESSORA("MODELO_IMPRESSORA","Modelos de impressora"),
    NOVO_CONTRATO("NOVO_CONTRATO","Novo contrato"),
    HOME("HOME","Inicio"),
    LOGOUT("LOGOUT","SAIR"),
    ;
    private final String screenName;
    private final String label;

}
