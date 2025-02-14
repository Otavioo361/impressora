package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ConsumivelDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ModeloImpressoraDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Consumivel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;

import java.util.List;

public class ModeloImpressoraController {
    private static final String name = ModeloImpressora.class.getSimpleName();
    private final ModeloImpressoraDao modeloImpressoraDao = new ModeloImpressoraDao();

    public DataResponseModel<List<ModeloImpressora>> findAll() {
        try {
            List<ModeloImpressora> dados = this.modeloImpressoraDao.findAll();
            return new DataResponseModel<>(
                    true,
                    DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),
                    dados,
                    null
            );
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new DataResponseModel<>(false, DefaultMessages.CONSULTA_ERROR.formatMessage(name),null,e);
        }
    }
}
