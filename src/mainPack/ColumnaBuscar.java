package mainPack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class ColumnaBuscar extends DefaultTableCellRenderer {

	private JPanel panel;
	private JTextField textField;
	private JButton button;

	public ColumnaBuscar() {

		// Configura el diseño del panel con FlowLayout y alineación vertical centrada
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, (35 - 25) / 2));

		// Elementos
		textField = new JTextField("Buscar... ");
		button = new JButton("+");

		// Añade los elementos al panel
		panel.add(textField);
		panel.add(button);

		// Personalizaciones adicionales para el panel
		panel.setBackground(new Color(0, 140, 206, 230)); // Color de fondo con 90% de opacidad
		panel.setBorder(BorderFactory.createEtchedBorder()); // Borde

	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		if (column == table.getColumnCount() - 1) {

			// Configurar el panel solo para la última columna
			panel.setBackground(new Color(0, 140, 206, 230)); // Color de fondo con 90% de opacidad
			panel.setBorder(BorderFactory.createEtchedBorder()); // Borde

			// Personalización del Field
			textField.setBackground(Color.WHITE);
			textField.setForeground(Color.GRAY);
			textField.setFont(new Font("Montserrat", Font.PLAIN, 12));
			textField.setHorizontalAlignment(JTextField.LEFT);
			textField.setBorder(BorderFactory.createCompoundBorder(
			        new LineBorder(Color.BLACK, 1), 
			        new EmptyBorder(0, 10, 0, 0)  
			));
			textField.setPreferredSize(new Dimension(150, 35));

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
