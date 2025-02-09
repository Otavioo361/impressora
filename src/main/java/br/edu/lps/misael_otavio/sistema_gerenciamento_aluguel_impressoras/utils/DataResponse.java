package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {
    private boolean success;
    private String message;
    private Object data;
    private Object error;

}
