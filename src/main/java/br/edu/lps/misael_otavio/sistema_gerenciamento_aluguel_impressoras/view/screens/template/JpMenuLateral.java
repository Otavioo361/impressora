package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.ImpressoraController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.SessionModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Acesso;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Impressora;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.ScreensName;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components.CustomMenuButton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.HomeScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.read.ReadClienteScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.read.ReadFornecedorScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.read.ReadImpressoraScreen;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.read.ReadModeloImpressoraScreen;
import net.miginfocom.swing.MigLayout;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class JpMenuLateral extends JPanel {
    private JFrame mainFrame;
    private SessionModel sessionModel;
    public JpMenuLateral(JFrame mainFrame,SessionModel sessionModel) {
        this.mainFrame = mainFrame;
        this.sessionModel = sessionModel;
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new MigLayout("fillx, insets 10, gapy 2"));
        this.instanciarBotoes();
    }
    private CustomMenuButton fabricMenuButton(ScreensName screensName) {
        return new CustomMenuButton(screensName);
    }

    private void instanciarBotoes(){
        this.addBtnHome();
        this.addBtnClientes();
        this.addBtnFornecedores();
        this.addBtnImpressora();
        this.addBtnModeloImpressora();
        this.addBtnLogout();
    }
    private void addButton(CustomMenuButton button){
        this.add(button,"growx, h 50!, wrap");
    }

    private void addBtnHome(){
        CustomMenuButton btn = this.fabricMenuButton(ScreensName.HOME);
        btn.addActionListener(e -> {
            FrMain.clearAllDialogs();
        });
        this.addButton(btn);
    }

    private void addBtnLogout(){
        CustomMenuButton btn = this.fabricMenuButton(ScreensName.LOGOUT);
        btn.addActionListener(e -> {
            FrMain.logout();
        });
        this.addButton(btn);
    }

    private void addBtnClientes(){
        Acesso acesso = this.sessionModel.getAcessos().get(ScreensName.CLIENTES.getScreenName());
        if(Objects.isNull(acesso) || !acesso.getInRead()){
            return;
        }
        CustomMenuButton btn = this.fabricMenuButton(ScreensName.CLIENTES);
        btn.addActionListener(e -> {
            ReadClienteScreen dialog = new ReadClienteScreen(this.mainFrame, false);
            dialog.setLocationRelativeTo(this.mainFrame);
            dialog.setSize(mainFrame.getSize());
            dialog.setVisible(true);
        });
        this.addButton(btn);
    }

    private void addBtnImpressora(){
        Acesso acesso = this.sessionModel.getAcessos().get(ScreensName.IMPRESSORAS.getScreenName());
        if(Objects.isNull(acesso) || !acesso.getInRead()){
            return;
        }
        CustomMenuButton btn = this.fabricMenuButton(ScreensName.IMPRESSORAS);
        btn.addActionListener(e -> {
            ReadImpressoraScreen dialog = new ReadImpressoraScreen(this.mainFrame, false);
            dialog.setLocationRelativeTo(this.mainFrame);
            dialog.setSize(mainFrame.getSize());
            dialog.setVisible(true);
        });
        this.addButton(btn);
    }

    private void addBtnModeloImpressora(){
        Acesso acesso = this.sessionModel.getAcessos().get(ScreensName.MODELO_IMPRESSORA.getScreenName());
        if(Objects.isNull(acesso) || !acesso.getInRead()){
            return;
        }

        CustomMenuButton btn = this.fabricMenuButton(ScreensName.MODELO_IMPRESSORA);
        btn.addActionListener(e -> {
            ReadModeloImpressoraScreen dialog = new ReadModeloImpressoraScreen(this.mainFrame, false);
            dialog.setLocationRelativeTo(this.mainFrame);
            dialog.setSize(mainFrame.getSize());
            dialog.setVisible(true);
        });
        this.addButton(btn);
    }

    private void addBtnFornecedores(){
        Acesso acesso = this.sessionModel.getAcessos().get(ScreensName.FORNECEDORES.getScreenName());
        if(Objects.isNull(acesso) || !acesso.getInRead()){
            return;
        }
        CustomMenuButton btn = this.fabricMenuButton(ScreensName.FORNECEDORES);
        btn.addActionListener(e -> {
            ReadFornecedorScreen dialog = new ReadFornecedorScreen(this.mainFrame, false);
            dialog.setLocationRelativeTo(this.mainFrame);
            dialog.setSize(mainFrame.getSize());
            dialog.setVisible(true);
        });
        this.addButton(btn);
    }

}
