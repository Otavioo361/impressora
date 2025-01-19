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
@Getter 
@Setter
public class Administrador extends Pessoa {    
    private String email;   
    private String cpf;
    
    public Administrador(){
    super();
    this.cpf = "000.000.000-00";
    }
    public Administrador(String nome, char sexo , int idade , String cpf){
        super(nome,sexo,idade);
        this.cpf = cpf;
    }

}

