
package br.edu.lps.misael_otavio.sistema_gerenciamento_aluguel_impressoras.controller;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author otavi
 */
public class Util {
    
    
    public static void jTableShow(JTable grd, AbstractTableModel tableModel, TableCellRenderer render) {
        grd.setModel(tableModel);
        if (render != null) {
            grd.setDefaultRenderer(Object.class, render);
        }
        
    }       
}
