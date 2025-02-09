package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Tela;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SessionModel {
    LocalDateTime dtIncioSessao;
    boolean inAtivo;
    Integer idLogin;
    String userName;
    String cpfCnpj;
    String nmUsuario;
    List<Tela> permissoes;
    List<String> roles;
}
