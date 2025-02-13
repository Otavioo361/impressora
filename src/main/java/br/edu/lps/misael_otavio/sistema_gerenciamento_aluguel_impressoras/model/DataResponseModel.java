package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataResponseModel<T> {
    private boolean success;
    private String message;
    private T data;
    private Object error;

}
