/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
/**
 *
 * @author otavi
 */
public class DatabaseConnection {   
    private static final String URL = "jdbc:mysql://localhost:3306/aluguel_impressora"; // Ajuste o nome do banco de dados se necessário
    private static final String USER = "seu_usuario"; // Substitua pelo usuário do banco de dados
    private static final String PASSWORD = "sua_senha"; // Substitua pela senha do banco de dados

    public static Connection connect() {
        Connection connection = null;

        try {
            // Estabelece a conexão
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados bem-sucedida!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        // Testa a conexão
        Connection connection = connect();

        if (connection != null) {
            try {
                connection.close(); // Fecha a conexão após o teste
                System.out.println("Conexão encerrada com sucesso.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
