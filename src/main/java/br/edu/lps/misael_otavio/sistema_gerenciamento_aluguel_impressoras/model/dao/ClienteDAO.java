package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.dao;

import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.model.Cliente;
import br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.exception.ImpreException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() {
        try {
            // Estabelece a conexão com o banco de dados
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
        } catch (SQLException e) {
            throw new ImpreException("Erro ao conectar com o banco de dados.");
        }
    }

    public Cliente save(Cliente cliente) {
        String sql = "INSERT INTO pessoa (nome, email, cpfCnpj , telefone) VALUES (?, ?, ? ,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf_cnpj());
            stmt.setString(4 ,cliente.getTelefone());
            stmt.executeUpdate();
            
            // Obtém o ID gerado para o cliente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
            }
            return cliente;
        } catch (SQLException e) {
            throw new ImpreException("Erro ao salvar o cliente.");
        }
    }

    public Cliente update(Cliente cliente) {
        String sql = "UPDATE pessoa SET nome = ?, email = ?, cpfCnpj = ?  , telefone = ? ,WHERE id = ? " ;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf_cnpj());
            stmt.setString(4, cliente.getTelefone());
            stmt.setInt(4,cliente.getId());
            stmt.executeUpdate();
            return cliente;
        } catch (SQLException e) {
            throw new ImpreException("Erro ao atualizar o cliente.");
        }
    }

    public void delete(Cliente cliente) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ImpreException("Erro ao excluir o cliente.");
        }
    }

    public Cliente findById(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf_cnpj(rs.getString("cpfCnpj"));
                cliente.setTelefone(rs.getNString("telefone"));
                return cliente;
            }
        } catch (SQLException e) {
            throw new ImpreException("Erro ao buscar cliente pelo ID.");
        }
        return null;
    }

    public Cliente findByEmail(String email) {
        String sql = "SELECT * FROM pessoa WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf_cnpj(rs.getString("cpfCnpj"));
                cliente.setTelefone(rs.getNString("telefone"));
                return cliente;
            }
        } catch (SQLException e) {
            throw new ImpreException("Erro ao buscar cliente pelo email.");
        }
        return null;
    }

    public Cliente findByCpfCnpj(String cpfCnpj) {
        String sql = "SELECT * FROM pessoa WHERE cpfCnpj = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpfCnpj);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf_cnpj(rs.getString("cpfCnpj"));
                cliente.setTelefone(rs.getNString("telefone"));
                return cliente;
            }
        } catch (SQLException e) {
            throw new ImpreException("Erro ao buscar cliente pelo CPF/CNPJ.");
        }
        return null;
    }

    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCpf_cnpj(rs.getString("cpfCnpj"));
                cliente.setTelefone(rs.getNString("telefone"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new ImpreException("Erro ao buscar todos os clientes.");
        }
        return clientes;
    }
}
