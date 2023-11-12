package mainPack;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Tabla extends JTable {

    private static final long serialVersionUID = 1L;

    public Tabla(DefaultTableModel modelo) {
        super(modelo);

        modelo.addColumn("Búsqueda");

        setRowHeight(100);
        setGridColor(Color.BLACK);
        setEnabled(false);
        setBackground(new Color(255, 255, 255));
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        Font montserratFont = new Font("Montserrat", Font.PLAIN, 12);
        setFont(montserratFont);

        TableCellRenderer headerRenderer = new HeaderTabla();
        getTableHeader().setDefaultRenderer(headerRenderer);

        int columnaDeBusqueda = getColumnCount() - 1;

        getColumnModel().getColumn(columnaDeBusqueda).setCellRenderer(new BotonEditarRenderer());

        getColumnModel().getColumn(columnaDeBusqueda).setCellEditor(new BotonEditarEditor(new JCheckBox()));
        
    }
}
