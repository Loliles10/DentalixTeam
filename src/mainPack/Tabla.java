package mainPack;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JTable {
	/**
	 * Autores:
	 * David Andrade
	 * Pablo Rodriguez
	 * Ian Requena
	 * 2023
	 */
	private static final long serialVersionUID = 1L;

	public Tabla(DefaultTableModel modelo) {
        super(modelo);
        // Personaliza la apariencia de la tabla aquí, por ejemplo:
        setRowHeight(30); // Altura de las filas
        setGridColor(Color.BLACK); // Color de las líneas de la cuadrícula
        // Agrega más personalizaciones según tus necesidades
    }
}
