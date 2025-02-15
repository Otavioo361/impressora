package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScreensName {
    IMPRESSORAS("impressoras","Impressoras"),
    FORNECEDORES("fornecedores","Fornecedores"),
    MODELO_IMPRESSORA("modeloImpressora","Modelos de impressora"),
    HOME("home","Inicio"),
    ;
    private final String screenName;
    private final String label;

}
