/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model;

/**
 *
 * @author otavi
 */
public class Impressora {
    private String tipoImpressora,cdBarrasImpressora,cdSerieImpressora;

    /**
     * @return the tipoImpressora
     */
    public String getTipoImpressora() {
        return tipoImpressora;
    }

    /**
     * @param tipoImpressora the tipoImpressora to set
     */
    public void setTipoImpressora(String tipoImpressora) {
        this.tipoImpressora = tipoImpressora;
    }

    /**
     * @return the cdBarrasImpressora
     */
    public String getCdBarrasImpressora() {
        return cdBarrasImpressora;
    }

    /**
     * @param cdBarrasImpressora the cdBarrasImpressora to set
     */
    public void setCdBarrasImpressora(String cdBarrasImpressora) {
        this.cdBarrasImpressora = cdBarrasImpressora;
    }

    /**
     * @return the cdSerieImpressora
     */
    public String getCdSerieImpressora() {
        return cdSerieImpressora;
    }

    /**
     * @param cdSerieImpressora the cdSerieImpressora to set
     */
    public void setCdSerieImpressora(String cdSerieImpressora) {
        this.cdSerieImpressora = cdSerieImpressora;
    }
}
