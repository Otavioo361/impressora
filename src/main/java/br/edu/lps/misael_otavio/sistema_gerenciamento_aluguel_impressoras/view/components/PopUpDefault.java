package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class PopUpDefault {
    private JDialog modal;
    private JPanel panel ;

    public PopUpDefault(JFrame frame) {
        this.modal = new JDialog(frame, "Mensagem", true);
        this.modal.setSize(600, 400);
        this.modal.setLocationRelativeTo(frame);
        this.panel = new JPanel();
    }
    public void showPopUp(String message) {
        this.modal.remove(this.panel);
        this.panel = new JPanel();
        this.panel.setLayout(new MigLayout("fill, gap 2"));
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial",Font.BOLD,18));
        this.panel.add(label,"dock north, w 80%");

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e1 -> modal.dispose());
        this.panel.add(closeButton, "dock south");
        this.modal.add(this.panel);
        this.modal.setVisible(true);
    }
}
