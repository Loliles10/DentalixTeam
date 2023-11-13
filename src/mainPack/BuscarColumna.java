package mainPack;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class BuscarColumna extends DefaultTableCellRenderer {

    private JPanel panel;
    private JTextField textField;
    private JButton button;

    public BuscarColumna() {
        // Configura el diseño del panel
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        textField = new JTextField("Introduzca su búsqueda ");
        button = new JButton("+");

        // Configura el diseño del panel
        panel.add(textField);
        panel.add(button);

        // Personalizaciones adicionales para el panel
        panel.setBackground(new Color(0, 140, 206, 230));  // Color de fondo con 90% de opacidad
        panel.setBorder(BorderFactory.createEtchedBorder());  // Borde

        // Personalizaciones adicionales para el textField
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.GRAY);
        textField.setFont(new Font("Montserrat", Font.PLAIN, 12));
        textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 1), // Borde negro
                new EmptyBorder(0, 10, 0, 0)  // Padding a la izquierda
        ));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (column == table.getColumnCount() - 1) {
            // Configurar el panel solo para la última columna
            panel.setBackground(new Color(0, 140, 206, 230));  // Color de fondo con 90% de opacidad
            panel.setBorder(BorderFactory.createEtchedBorder());  // Borde

            // Personalizaciones adicionales para el textField
            textField.setBackground(new Color(0, 140, 206, 230));  // Color con 90% de opacidad
            textField.setForeground(Color.WHITE);
            textField.setFont(new Font("Montserrat", Font.PLAIN, 12));
            textField.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

            return panel;  // Devuelve el panel con los componentes configurados solo para la última columna
        } else {
            // Devuelve el valor predeterminado para las demás columnas
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // PADDING A LA IZQUIERDA PARA HEADER
            label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

            // Personalizaciones adicionales para el label
            Font montserratFont = new Font("Montserrat", Font.BOLD, 12);
            label.setFont(montserratFont);

            label.setOpaque(true);
            label.setBackground(new Color(0, 140, 206, 230));  // Color con 90% de opacidad
            label.setForeground(Color.WHITE);

            return label;
        }
    }
}
