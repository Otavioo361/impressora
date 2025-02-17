package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DataResponseFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.GrupoImpressoraDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ImpressoraGrupoImpressoraDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ImpressoraGrupoImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.ModeloImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service.GrupoImpressoraService;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateGrupoImpressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateImpressoraGrupoImpressora;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ImpressoraGrupoImpressoraController {
    private static final String name = ImpressoraGrupoImpressora.class.getSimpleName();
    private final ImpressoraGrupoImpressoraDao grupoImpressoraDao = new ImpressoraGrupoImpressoraDao();
    private final ValidateImpressoraGrupoImpressora validateImpressoraGrupoImpressora = new ValidateImpressoraGrupoImpressora();
    private final Logger logger = LoggerSingleton.getLogger(ImpressoraGrupoImpressoraController.class);

    public DataResponseModel<ImpressoraGrupoImpressora> save(HashMap<String, String> dados) {
        try {
            ImpressoraGrupoImpressora grupoImpressora = this.validateImpressoraGrupoImpressora.validarCamposEntrada(dados);
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), new ImpressoraGrupoImpressora());
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(), e);
        }
    }


    public DataResponseModel<ImpressoraGrupoImpressora> save(GrupoImpressora grupoImpressora) {
        try {
            List<ImpressoraGrupoImpressora> impressoraGrupoImpressoras = new ArrayList<>();
            grupoImpressora.getImpressoras().forEach(impressora -> {
                ImpressoraGrupoImpressora temp = new ImpressoraGrupoImpressora();
                impressora.setInImpressoraDisponivel(false);
                impressora.setDtUltimaLocacao(LocalDateTime.now());
                temp.setImpressora(impressora);
                temp.setGrupoImpressora(grupoImpressora);
                impressoraGrupoImpressoras.add(temp);
            });
            this.grupoImpressoraDao.saveAll(impressoraGrupoImpressoras);
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), new ImpressoraGrupoImpressora());
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            e.printStackTrace();
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(), e);
        }
    }

    public DataResponseModel<List<ImpressoraGrupoImpressora>> findAll() {
        try {
            List<ImpressoraGrupoImpressora> dados = this.grupoImpressoraDao.findAll();
            return new DataResponseModel<>(
                    true,
                    DefaultMessages.CONSULTA_SUCESSO.formatMessage(name),
                    dados,
                    null
            );
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(DefaultMessages.CONSULTA_ERROR.formatMessage(name), e);
        }
    }
}
