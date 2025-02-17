package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.GrupoAcesso;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SessionModel {
    private final LocalDateTime dtIncioSessao = LocalDateTime.now();
    private boolean inAtivo;
    private Long idLogin;
    private Long idUsuario;
    private String userName;
    private String cpfCnpj;
    private String nmUsuario;
    private Set<GrupoAcesso> permissoes;
}
