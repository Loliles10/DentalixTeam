package mainPack;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BotonEditarRenderer implements TableCellRenderer {
    private final JButton boton;

    public BotonEditarRenderer() {
        this.boton = new JButton("Editar");
        this.boton.setOpaque(true); // Añadido para garantizar la opacidad
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return boton;
    }
}