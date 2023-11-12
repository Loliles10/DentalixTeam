package mainPack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class HeaderTabla extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JLabel label = new JLabel(value != null ? value.toString() : "");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        // Configurar la fuente Montserrat en negrita (bold)
        Font montserratFont = new Font("Montserrat", Font.BOLD, 12);
        label.setFont(montserratFont);

        // Convertir el código hexadecimal a color y añadir 90% de opacidad
        Color color = new Color(Integer.parseInt("008CCE", 16));
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) (255 * 0.9));

        label.setOpaque(true);
        label.setBackground(color);
        label.setForeground(Color.WHITE);

        // Establecer la altura del encabezado verticalmente
        label.setPreferredSize(new java.awt.Dimension(30, 100));
        return label;
    }
}
