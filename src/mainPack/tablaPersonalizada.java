package mainPack;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tablaPersonalizada extends DefaultTableModel {

    public tablaPersonalizada() {
        super(); // Llama al constructor de la superclase
    }

    // Sobrescribe el método isCellEditable para hacer que todas las celdas sean no editables
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    // Personaliza la forma en que se muestra el contenido en las celdas (esto es opcional)
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4) { // Supongamos que la columna 4 contiene fechas
            return Date.class; // Devuelve el tipo Date para esa columna
        }
        return super.getColumnClass(columnIndex); // De lo contrario, usa el comportamiento predeterminado
    }

    // Personaliza el renderizado de las celdas (esto es opcional)
    @Override
    public Object getValueAt(int row, int column) {
        Object value = super.getValueAt(row, column);
        if (column == 4 && value instanceof Date) { // Supongamos que la columna 4 contiene fechas
            // Personaliza la forma en que se muestra la fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.format((Date) value);
        }
        return value;
    }
}
