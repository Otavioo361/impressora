package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.template;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.ScreensName;

import javax.swing.*;
import java.awt.*;

public class JpMenuLateral extends javax.swing.JPanel {
    public JpMenuLateral() {
        this.setBackground(Color.LIGHT_GRAY);

        JButton btnHome = new JButton("Home");
        JButton btnSettings = new JButton("Settings");
        JButton btnAbout = new JButton("About");
        btnHome.addActionListener(e->{
            FrMain.changeScreen(ScreensName.CADASTRO_CLIENTE);
        });
        this.add(btnHome);
        this.add(btnSettings);
        this.add(btnAbout);
    }
}
