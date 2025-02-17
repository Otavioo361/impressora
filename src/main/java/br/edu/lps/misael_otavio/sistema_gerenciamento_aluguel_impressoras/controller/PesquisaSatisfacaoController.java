package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.DataResponseFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.ClienteDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.PesquisaSatisfacaoDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.PesquisaSatisfacao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidateCliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.valid.ValidatePesquisaSatisfacao;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PesquisaSatisfacaoController {
    private static final String name = PesquisaSatisfacao.class.getSimpleName();
    private final PesquisaSatisfacaoDao pesquisaSatisfacaoDao = new PesquisaSatisfacaoDao();
    private final ValidatePesquisaSatisfacao validatePesquisaSatisfacao = new ValidatePesquisaSatisfacao();
    private final Logger logger = LoggerSingleton.getLogger(PesquisaSatisfacaoController.class);

    public DataResponseModel<PesquisaSatisfacao> save(HashMap<String,String> dados) {
        try {
            PesquisaSatisfacao pesquisaSatisfacao = validatePesquisaSatisfacao.validarCamposEntrada(dados);
            this.pesquisaSatisfacaoDao.save(pesquisaSatisfacao);
            return DataResponseFabric.fabricSuccessResponse(DefaultMessages.CADASTRADO_SUCESSO.formatMessage(name), pesquisaSatisfacao);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage());
            this.logger.error(Arrays.toString(e.getStackTrace()));
            return DataResponseFabric.fabricFailResponse(e.getMessage(),e );
        }
    }

}
