package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComboBoxItem {
    private int index;
    private String id;
    private String nome;

    @Override
    public String toString(){
        return nome;
    }
}
