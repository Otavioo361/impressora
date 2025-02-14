package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;

public class DataResponseFabric<T> {
    public static <T> DataResponseModel<T> fabricSuccessResponse(String message,T data) {
        return new DataResponseModel<T>(true,message,data,null);
    }
    public static <T> DataResponseModel<T> fabricFailResponse(String message, Object error) {
        return new DataResponseModel<>(false,message,null,error);
    }
}
