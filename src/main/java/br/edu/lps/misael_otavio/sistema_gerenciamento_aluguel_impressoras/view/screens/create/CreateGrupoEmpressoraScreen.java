/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.create;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.ClienteController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.EnderecoController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.GrupoImpressoraController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller.UfController;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.LoggerSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.MaskFormatterFabric;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory.SessionStorageSingleton;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.DataResponseModel;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.entities.*;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.service.EnderecoService;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.ComboBoxItem;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.DefaultMessages;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.utils.Validators;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components.ClienteCard;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components.ContratoCard;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.components.GrupoImpressoraCard;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.view.screens.template.FrMain;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.json.JSONObject;
import org.slf4j.Logger;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.xml.stream.events.EndElement;

/**
 *
 * @author misael
 */
public class CreateGrupoEmpressoraScreen extends javax.swing.JDialog {
    private final Logger logger = LoggerSingleton.getLogger(this.getClass());
    private final GrupoImpressoraController grupoImpressoraController = new GrupoImpressoraController();

    private final EnderecoController enderecoController = new EnderecoController();

    private List<GrupoImpressora> grupoImpressoraLista = new ArrayList<>();
    private Cliente cliente;
    private Contrato contrato;
    private List<Endereco> enderecoLista;
    private HashMap<String,Boolean> checkList;

    private JPanel contentPanel;
    private JScrollPane jspListaDados;

    /**
     * Creates new form CreateImpressoraScreen
     */
    public CreateGrupoEmpressoraScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public CreateGrupoEmpressoraScreen(java.awt.Frame parent, boolean modal, Contrato contrato, HashMap<String,Boolean> checkList) {
        super(parent, modal);
        initComponents();
        this.contrato = contrato;
        this.cliente = contrato.getCliente();
        this.checkList = checkList;
        this.buscarEnderecos();
        this.buscarGruposImpressoraContrato();
        this.iniciarComboBox();
        this.atualizaListaDeGruposImpressora();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txNmGrupoImpr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jcbEndereco = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jpBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro Grupos Impressora");

        txNmGrupoImpr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNmGrupoImprActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel5.setText("Nome grupo:");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText("Endereço");

        jcbEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEnderecoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("GRUPOS JÁ CRIADO");

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txNmGrupoImpr, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnVoltar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNmGrupoImpr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jpBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        HashMap<String,String> dados = this.pegarDadosPreenchidos();
        DataResponseModel<GrupoImpressora> resp = this.grupoImpressoraController.save(dados);
        FrMain.exibirPopUp(resp.getMessage());
        if(resp.isSuccess()) {
            this.grupoImpressoraLista.add(resp.getData());
            this.atualizaListaDeGruposImpressora();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.checkList.put("endereco",this.checkList.getOrDefault("endereco",false));
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txNmGrupoImprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNmGrupoImprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNmGrupoImprActionPerformed

    private void jcbEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEnderecoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateGrupoEmpressoraScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateGrupoEmpressoraScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateGrupoEmpressoraScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateGrupoEmpressoraScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateGrupoEmpressoraScreen dialog = new CreateGrupoEmpressoraScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private void atualizaListaDeGruposImpressora() {
        this.jpBody.removeAll();
        this.contentPanel = new JPanel();
        this.contentPanel.setLayout(new GridLayout(0, 4));
        this.jpBody.setLayout(new BoxLayout(jpBody, BoxLayout.Y_AXIS));

        if (!Validators.isListaValida(grupoImpressoraLista)) {
            return;
        }

        for (GrupoImpressora dados : this.grupoImpressoraLista) {
            GrupoImpressoraCard card = new GrupoImpressoraCard(dados,this.checkList);
            this.contentPanel.add(card);
        }

        this.jspListaDados = new JScrollPane(this.contentPanel);
        this.jspListaDados.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.jpBody.add(this.jspListaDados);
        this.revalidate();
        this.repaint();
    }
    private void buscarEnderecos(){
        DataResponseModel<List<Endereco>> resp = this.enderecoController.findByClienteId(this.cliente.getId());
        if(!resp.isSuccess()){
            FrMain.exibirPopUp(resp.getMessage());
            this.autoClose();
        }
        this.enderecoLista = resp.getData();
    }

    private void iniciarComboBox(){
        if(!Validators.isListaValida(this.enderecoLista)) {
            FrMain.exibirPopUp(DefaultMessages.ERRO_DADOS_NAO_ENCOTRADO.getMessage());
            this.autoClose();
            return;
        }
        for (int i=0; i<this.enderecoLista.size(); i++) {
            Endereco endereco = this.enderecoLista.get(i);
            this.jcbEndereco.addItem(new ComboBoxItem(i,String.valueOf(endereco.getId()),endereco.getNmEndereco()));
        }
    }

    private void buscarGruposImpressoraContrato(){
        DataResponseModel<List<GrupoImpressora>> resp = this.grupoImpressoraController.findByContratoId(this.contrato.getId());
        if(!resp.isSuccess()){
            FrMain.exibirPopUp(resp.getMessage());
            this.autoClose();
        }
        this.grupoImpressoraLista = resp.getData();
    }



    private HashMap<String,String> pegarDadosPreenchidos(){
        HashMap<String,String> map = new HashMap<>();
        if(this.txNmGrupoImpr.getText().isEmpty()){
            FrMain.exibirPopUp("Campos obrigatórios estão vazio.");
            return null;
        }
        map.put("idEndereco",String.valueOf(this.enderecoLista.get(this.jcbEndereco.getSelectedIndex()).getId()));
        map.put("idContrato",String.valueOf(this.contrato.getId()));
        map.put("nmGrupoImpressora",String.valueOf(this.txNmGrupoImpr.getText()));
        map.put("nmUsuario", SessionStorageSingleton.get("nmUsuario").toString());

        return map;
    }

    private void autoClose(){
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                dispose();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<ComboBoxItem> jcbEndereco;
    private javax.swing.JPanel jpBody;
    private javax.swing.JTextField txNmGrupoImpr;
    // End of variables declaration//GEN-END:variables
}
