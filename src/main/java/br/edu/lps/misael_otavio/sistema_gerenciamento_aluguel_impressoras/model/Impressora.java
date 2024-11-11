/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author otavi
 */
public class Impressora {
    @Getter @Setter
    private String tipoImpressora;
    @Getter @Setter
    private String cdBarrasImpressora;
    @Getter @Setter
    private String cdSerieImpressora;
}