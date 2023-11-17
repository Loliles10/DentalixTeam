package mainPack;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URL;

public class ColumnaBuscar extends DefaultTableCellRenderer {

    private JPanel panel;
    private JTextField textField;
    private JButton button;

    public ColumnaBuscar() {

        // JPanel
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 30));
        panel.setBackground(new Color(0, 140, 206, 230));
        panel.setBorder(BorderFactory.createEtchedBorder());

        // Componentes
        textField = new JTextField("Buscar... ");
        button = new JButton();
        URL imgUrl = getClass().getResource("/añadir.png");
        Icon icon = new ImageIcon(imgUrl);
        button.setIcon(icon);
        button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        button.setContentAreaFilled(false); 
        button.setBorderPainted(false); 
        panel.add(textField);
        panel.add(button);

        // TextField
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.GRAY);
        textField.setFont(new Font("Montserrat", Font.PLAIN, 12));
        textField.setHorizontalAlignment(JTextField.LEFT);
        textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 1),
                new EmptyBorder(0, 10, 0, 0)
        ));
        textField.setPreferredSize(new Dimension(150, 35));

        // Personalizaciones adicionales para el botón
        button.setBackground(Color.WHITE);
        button.setPreferredSize(new Dimension(40, 35)); // Aumenta el tamaño del botón
        button.setBorderPainted(false); // Quita el borde pintado del botón

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {

        if (column == table.getColumnCount() - 1) {

            // Configurar el panel solo para la última columna
            panel.setBackground(new Color(0, 140, 206, 230));
            panel.setBorder(BorderFactory.createEtchedBorder());

            return panel;

        } else {

            // Devuelve el valor predeterminado para las demás columnas
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                    column);
            label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
            Font montserratFont = new Font("Montserrat", Font.BOLD, 12);
            label.setFont(montserratFont);
            label.setOpaque(true);
            label.setBackground(new Color(0, 140, 206, 230));
            label.setForeground(Color.WHITE);
            return label;
        }
    }
}
