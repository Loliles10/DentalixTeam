package mainPack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class HeaderTabla extends DefaultTableCellRenderer {
	public HeaderTabla() {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel label = new JLabel(value != null ? value.toString() : "");
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setVerticalAlignment(JLabel.CENTER);

		Font montserratFont = new Font("Montserrat", Font.BOLD, 12);
		label.setFont(montserratFont);

		label.setOpaque(true);
		label.setBackground(new Color(0, 140, 206));
		label.setForeground(Color.WHITE);

		label.setPreferredSize(new java.awt.Dimension(30, 100));
		// PADDING A LA IZQUIERDA PARA HEADER
		label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

		return label;
	}
}
