package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DataResponseFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ImpressoraDao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.transaction.Transactional;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateImpressora;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.List;


public class ImpressoraController {
    private static final String name = Impressora.class.getSimpleName();
    private ImpressoraDao impressoraDao = new ImpressoraDao();
    private ValidateImpressora validateImpressora = new ValidateImpressora();
    private Logger logger = LoggerSingleton.getLogger(this.getClass());
    @Transactional
    public DataResponseModel<Impressora> save(HashMap<String, String> dados) {
        try {
            Impressora impressora = validateImpressora.validarCamposEntrada(dados);
            System.out.println(impressora);
            this.impressoraDao.save(impressora);
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), impressora);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            return DataResponseFabric.fabricFailResponse(e.getMessage(),e );
        }
    }

    public DataResponseModel<List<Impressora>> buscarImpressorasRecentes() {
        try {
            List<Impressora> impressoras = this.impressoraDao.listarTop20();
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),impressoras);

        } catch (RuntimeException e) {
            this.logger.error(DefaultMessages.CONSULTA_ERROR.formatMessage(name));
            this.logger.error(e.getMessage());
            return DataResponseFabric.fabricFailResponse(DefaultMessages.CONSULTA_ERROR.formatMessage(name),e );
        }
    }
}
