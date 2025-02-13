package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components;

import javax.swing.*;

public class PopUpDefault {
    private JDialog modal;

    public PopUpDefault(JFrame frame) {
        this.modal = new JDialog(frame, "Mensagem", true);
        this.modal.setSize(200, 150);
        this.modal.setLocationRelativeTo(frame);
    }
    public void showPopUp(String message) {
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        this.modal.add(label);
        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e1 -> modal.dispose());
        this.modal.add(closeButton, "South");

        this.modal.setVisible(true);
    }
}
