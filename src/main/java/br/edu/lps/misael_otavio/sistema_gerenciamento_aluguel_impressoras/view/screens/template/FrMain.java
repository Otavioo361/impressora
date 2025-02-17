package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.SessionModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.Acesso;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.ScreensName;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components.PopUpDefault;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.HomeScreen;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FrMain {
    private static final int screenWidth = 1240;
    private static final int screenHeight = 720;
    @Getter
    private static final JFrame frame = new JFrame("Aluguel impressoras");
    private static final PopUpDefault popUp = new PopUpDefault(frame); //OBRIGATORIO ESTAR NESSA POSIÇÂO
    private static final HomeScreen homePanel = new HomeScreen();
    @Getter
    private static SessionModel sessionModel;


    public void  criarInterface(SessionModel session) {
        sessionModel = session;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenWidth, screenHeight);

        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());
        JButton toggleButton = new JButton("Toggle Menu");

        JpHeader header = new JpHeader(toggleButton,screenWidth);

        JpMenuLateral menuLateral = new JpMenuLateral(frame,sessionModel);


        frame.add(header, BorderLayout.NORTH);
        frame.add(menuLateral, BorderLayout.WEST);
        frame.add(homePanel, BorderLayout.CENTER);

        toggleButton.addActionListener(e -> {
            menuLateral.setVisible(!menuLateral.isVisible());
            menuLateral.setPreferredSize(new Dimension(screenWidth/4, frame.getHeight()));
        });

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int larguraJanela = frame.getWidth();
                menuLateral.setPreferredSize(new Dimension(screenWidth/4, frame.getHeight()));
                frame.revalidate();
            }
        });
        frame.setVisible(true);

    }
    public static void exibirPopUp(String message){
        popUp.showPopUp(message);
    }

    public static Acesso getAcesso(ScreensName screensName){
        return sessionModel.getAcessos().get(screensName.getScreenName());
    }

    public static void logout(){
        sessionModel = null;
        clearAllDialogs();
        frame.setVisible(false);
        frame.dispose();

        new FrLogin().setVisible(true);

    }

    public static void clearAllDialogs(){
        for (Window window : frame.getOwnedWindows()) {
            if (window instanceof JDialog) {
                window.dispose();
            }
        }
    }


}
