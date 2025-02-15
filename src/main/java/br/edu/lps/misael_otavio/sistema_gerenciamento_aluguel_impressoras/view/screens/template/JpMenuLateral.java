package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.ImpressoraController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.ScreensName;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components.CustomMenuButton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.HomeScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.read.ReadFornecedorScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.read.ReadImpressoraScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.read.ReadModeloImpressoraScreen;
import net.miginfocom.swing.MigLayout;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class JpMenuLateral extends JPanel {
    private JFrame mainFrame;
    public JpMenuLateral(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new MigLayout("fillx, insets 10, gapy 2"));
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
        this.addButton(btn);

        btn = this.fabricMenuButton(ScreensName.IMPRESSORAS);
        btn.addActionListener(e -> {
            ReadImpressoraScreen dlgImpressora = new ReadImpressoraScreen(this.mainFrame, false);
            dlgImpressora.setLocationRelativeTo(this.mainFrame);
            dlgImpressora.setSize(mainFrame.getSize());
            dlgImpressora.setVisible(true);
        });
        this.addButton(btn);
        
        btn = this.fabricMenuButton(ScreensName.FORNECEDORES);
        btn.addActionListener(e -> {
            ReadFornecedorScreen dlgImpressora = new ReadFornecedorScreen(this.mainFrame, false);
            dlgImpressora.setLocationRelativeTo(this.mainFrame);
            dlgImpressora.setSize(mainFrame.getSize());
            dlgImpressora.setVisible(true);
        });
        this.addButton(btn);

        btn = this.fabricMenuButton(ScreensName.MODELO_IMPRESSORA);
        btn.addActionListener(e -> {
            ReadModeloImpressoraScreen dialog = new ReadModeloImpressoraScreen(this.mainFrame, false);
            dialog.setLocationRelativeTo(this.mainFrame);
            dialog.setSize(mainFrame.getSize());
            dialog.setVisible(true);
        });
        this.addButton(btn);
    }
    private void addButton(CustomMenuButton button){
        this.add(button,"growx, h 50!, wrap");
    }
}
