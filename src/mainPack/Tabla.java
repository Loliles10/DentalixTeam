package mainPack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.plaf.ColorUIResource;

public class Tabla extends JTable {

	private static final long serialVersionUID = 1L;

	public Tabla(DefaultTableModel modelo) {
		super(modelo);

		setShowVerticalLines(false);

		modelo.addColumn("Búsqueda");

		setRowHeight(100);
		setGridColor(Color.BLACK);
		setEnabled(false);
		setBackground(new Color(255, 255, 255));
		setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		Font montserratFont = new Font("Montserrat", Font.PLAIN, 12);
		setFont(montserratFont);
		setOpaque(true);
		
	     
		TableCellRenderer headerRenderer = new HeaderTabla();
		getTableHeader().setDefaultRenderer(headerRenderer);


		int columnaDeBusqueda = getColumnCount() - 1;
		
		setDefaultRenderer(Object.class, new CustomCellRenderer());

		getColumnModel().getColumn(columnaDeBusqueda).setCellEditor(new BotonEditarEditor(new JCheckBox()));
		getColumnModel().getColumn(columnaDeBusqueda).setCellRenderer(new DatosTablaRenderer());
		getColumnModel().getColumn(columnaDeBusqueda).setCellEditor(new BotonEditarEditor(new JCheckBox()));


	}

}
