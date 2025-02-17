package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DataResponseFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.MarcaDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Marca;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MarcaController {
    private static final String name = Marca.class.getSimpleName();
    private final MarcaDao marcaDao = new MarcaDao();
    private final Logger logger = LoggerSingleton.getLogger(MarcaController.class);

    public DataResponseModel<Marca> save(HashMap<String,String> dados) {
        try {
            Marca marca = new Marca();
            this.marcaDao.save(marca);
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), marca);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(),e );
        }
    }

    public DataResponseModel<List<Marca>> findAll() {
        try {
            List<Marca> dados = this.marcaDao.findAll();
            return new DataResponseModel<>(
                    true,
                    DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),
                    dados,
                    null
            );
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(DefaultMessages.CONSULTA_ERROR.formatMessage(name),e);
        }
    }

    public DataResponseModel<List<Marca>> findActiveOnly() {
        try {
            List<Marca> dados = this.marcaDao.findActivesOnly();
            return new DataResponseModel<>(
                    true,
                    DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),
                    dados,
                    null
            );
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(DefaultMessages.CONSULTA_ERROR.formatMessage(name),e);
        }
    }
}
