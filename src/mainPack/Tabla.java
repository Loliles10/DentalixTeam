package mainPack;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Tabla extends JTable {

    private static final long serialVersionUID = 1L;

    public Tabla(DefaultTableModel modelo) {
        super(modelo);

        setShowVerticalLines(false);

        modelo.addColumn(""); // No se agrega texto para la columna

        setRowHeight(100);
        setGridColor(Color.BLACK);
        setEnabled(false);
        setBackground(new Color(255, 255, 255));
        setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        Font montserratFont = new Font("Montserrat", Font.PLAIN, 12);
        setFont(montserratFont);
        setOpaque(true);

        TableCellRenderer headerRenderer = new ColumnaBuscar();
        getTableHeader().setDefaultRenderer(headerRenderer);

        int columnaDeBusqueda = getColumnCount() - 1;

        setDefaultRenderer(Object.class, new CustomCellRenderer());

        getColumnModel().getColumn(columnaDeBusqueda).setCellEditor(new BotonEditarEditor(new JCheckBox()));
        getColumnModel().getColumn(columnaDeBusqueda).setCellRenderer(new DatosTablaRenderer());
        getColumnModel().getColumn(columnaDeBusqueda).setHeaderRenderer(new ColumnaBuscar());

        // Ajuste de la altura de las filas del encabezado
        getTableHeader().setPreferredSize(new java.awt.Dimension(30, 100));
    }
}
