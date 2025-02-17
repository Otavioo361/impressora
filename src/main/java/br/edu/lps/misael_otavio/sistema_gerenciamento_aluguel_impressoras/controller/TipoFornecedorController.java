package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.TipoFornecedorDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.TipoFornecedor;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;

import java.util.List;

public class TipoFornecedorController {
    private static final String name = TipoFornecedor.class.getSimpleName();
    private final TipoFornecedorDao tipoFornecedorDao = new TipoFornecedorDao();

    public DataResponseModel<List<TipoFornecedor>> findAll() {
        try {
            List<TipoFornecedor> dados = this.tipoFornecedorDao.findAll();
            return new DataResponseModel<>(
                    true,
                    DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),
                    dados,
                    null
            );
        } catch (RuntimeException e) {
            
            e.printStackTrace();
            return new DataResponseModel<>(false, DefaultMessages.CONSULTA_ERROR.formatMessage(name), null, e);
        }
    }
}
