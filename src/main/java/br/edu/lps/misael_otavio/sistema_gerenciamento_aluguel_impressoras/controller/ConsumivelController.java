package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ConsumivelDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Consumivel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;

import java.util.List;

public class ConsumivelController {
    private static final String name = Consumivel.class.getSimpleName();
    private final ConsumivelDao consumivelDao = new ConsumivelDao();

    public DataResponseModel<List<Consumivel>> buscarPorImpressora(Long idImpressora) {
        try {
            List<Consumivel> dados = this.consumivelDao.findByImpressoraId(idImpressora);
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
