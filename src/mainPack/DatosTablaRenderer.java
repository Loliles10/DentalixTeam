package mainPack;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DatosTablaRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JLabel label = new JLabel(value != null ? value.toString() : "");
        label.setHorizontalAlignment(JLabel.LEFT); 
        label.setVerticalAlignment(JLabel.CENTER);

        return label;
    }
}
