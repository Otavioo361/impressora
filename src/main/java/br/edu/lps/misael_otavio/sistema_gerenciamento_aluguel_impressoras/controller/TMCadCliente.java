
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;
import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author otavi
 */
public class TMCadCliente extends AbstractTableModel {
   private List<Cliente> clientes;
    
   
    private final String[] colunas = {"ID", "Nome", "Email", "CPF/CNPJ", "Telefone"};

    // Construtor que recebe a lista de clientes
    public TMCadCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: // ID
                return cliente.getId();
            case 1: // Nome
                return cliente.getNome();
            case 2: // Email
                return cliente.getEmail();
            case 3: // CPF/CNPJ
                return cliente.getCpf_cnpj();            
            case 4: // Telefone
                return cliente.getTelefone();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: // ID (não pode ser alterado diretamente)
                break;
            case 1: // Nome
                cliente.setNome((String) aValue);
                break;
            case 2: // Email
                cliente.setEmail((String) aValue);
                break;
            case 3: // CPF/CNPJ
                cliente.setCpf_cnpj((String) aValue);
                break;
            
            case 4: // Telefone
                cliente.setTelefone((String) aValue);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0; // Não permite editar o ID
    }

    // Método para atualizar a lista de clientes
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        fireTableDataChanged(); // Atualiza os dados da tabela
    }
}
