package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.CadastroCliente;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class RouterView {
    public static List<Object> stackNavigator = new Stack<>();
    public static HashMap<ScreensName, JPanel> screens = new HashMap<>();

    public RouterView() {
        this.prapareScreens();
    }

    private void prapareScreens(){
        screens.put(ScreensName.CADASTRO_CLIENTE, new CadastroCliente());
    }
    public JPanel getScreen(ScreensName screenName) {
        return screens.get(screenName);
    }
}
