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
public class Pessoa {
    @Getter @Setter
     protected String nome;
    @Getter @Setter
    protected char sexo;
    @Getter @Setter
    protected int idade;

    public Pessoa() {
        this.nome = "";
        this.sexo = ' ';
        this.idade = 0;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    } 

    @Override
    public String toString() {
        String txt = "Nome: " + this.nome +"\n"
        +"Sexo: "+ this.sexo + "\n"
        +"Idade: "+ this.idade+"\n";
        return txt;
    }   
    
    @Override
    public boolean equals(Object obj) {
        Pessoa outro = (Pessoa) obj;
        if(!this.nome.equals(outro.getNome()))
            return false;
        else if(this.idade != outro.getIdade())
            return false;
        else if(this.sexo != outro.getSexo())
            return false;
        
        return true;
    }
    
}