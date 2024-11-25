/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author otavi
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente extends Pessoa{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    private String email;    
    private String cpf_cnpj;
    private String telefone;
    
    public Cliente(){
     this.cpf_cnpj="";
     this.email="";
     this.id= -1;
     this.telefone ="";
    }
}
