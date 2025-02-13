package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.template;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.ImpressoraController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.ScreensName;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components.CustomMenuButton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.HomeScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.read.ReadImpressoraScreen;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class JpMenuLateral extends JPanel {
    private HashMap<ScreensName,CustomMenuButton> screensButtons;
    private JFrame mainFrame;
    public JpMenuLateral(HashMap<ScreensName,CustomMenuButton> screens,JFrame mainFrame) {
        this.screensButtons = screens;
        this.mainFrame = mainFrame;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.instanciarBotoes();

    }
    private CustomMenuButton fabricMenuButton(ScreensName screensName) {
        return new CustomMenuButton(screensName);
    }

    private void instanciarBotoes(){
        CustomMenuButton btn = this.fabricMenuButton(ScreensName.HOME);
        btn.addActionListener(e -> {
            HomeScreen dlghome = new HomeScreen();
            dlghome.setLocationRelativeTo(this.mainFrame);
            dlghome.setSize(this.mainFrame.getSize());
            dlghome.setVisible(true);
        });
        this.add(btn);
        this.screensButtons.put(ScreensName.HOME,btn);

        btn = this.fabricMenuButton(ScreensName.IMPRESSORAS);
        btn.addActionListener(e -> {
            ImpressoraController impressoraController = new ImpressoraController();
            DataResponseModel<List<Impressora>> resp = impressoraController.buscarImpressorasRecentes();
            if(!resp.isSuccess()){
                FrMain.exibirPopUp(resp.getMessage());
                return;
            }

            ReadImpressoraScreen dlgImpressora = new ReadImpressoraScreen(this.mainFrame,false,resp.getData());
            dlgImpressora.setLocationRelativeTo(this.mainFrame);
            dlgImpressora.setSize(mainFrame.getSize());
            dlgImpressora.setVisible(true);
        });
        this.add(btn);
        this.screensButtons.put(ScreensName.HOME,btn);
    }
}
