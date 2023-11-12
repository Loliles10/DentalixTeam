package mainPack;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class BotonEditarEditor extends DefaultCellEditor {
    private final JButton button;
    private String label;

    public BotonEditarEditor(JCheckBox checkBox) {
        super(checkBox);
        this.button = new JButton();
        this.button.setOpaque(true);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                // Aquí puedes implementar la lógica para la acción de editar
                /*
                 * 
                 * 
                 * 
                 * */
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.label = (value == null) ? "" : value.toString();
        this.button.setText(label);
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }
}