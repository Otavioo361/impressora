/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseJPA {
    
    private EntityManagerFactory factory;

    private static DatabaseJPA INSTANCE = null;

    public static DatabaseJPA getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseJPA();
        }

        return INSTANCE;
    }

    private DatabaseJPA() {
        factory = Persistence.createEntityManagerFactory("exemplo-jpa");        
    }
    
    public EntityManager getEntityManager() {        
        return factory.createEntityManager();
    }
    
    public void closeFactory(){
        this.factory.close();
    }
    
}
