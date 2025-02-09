package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao.UsuarioDao;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service.PasswordService;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.template.FrLogin;

public class SistemaGerenciamentoAluguelImpressoras {



    public static void main(String[] args) {
        System.out.println(PasswordService.hash("123"));
        new FrLogin().setVisible(true);
    }

}
