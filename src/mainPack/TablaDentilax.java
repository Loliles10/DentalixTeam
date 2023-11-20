package mainPack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.*;

public class TablaDentilax extends JFrame {
    public TablaDentilax() {
        // Configuración de la ventana
        setTitle("Tabla Dentilax");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Crear un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Documento");
        modelo.addColumn("Última Consulta");
        modelo.addColumn("Acciones");

        // Agregar datos a la tabla
        Object[] fila1 = {"Patricia", "Gimenez", "12345678", "2022-12-11"};
        Object[] fila2 = {"Fernando", "Tranquilidad", "23456789", "2023-11-11"};
        Object[] fila3 = {"Luna", "Estrellada", "34567890", "2023-11-09"};
        Object[] fila4 = {"Lucas", "Aventurero", "45678901", "2023-11-08"};
        Object[] fila5 = {"Paco", "Jiménez", "56712349", "2023-10-12"};
        Object[] fila6 = {"Isabel", "Serena", "56789012", "2023-01-12"};
        Object[] fila7 = {"Jacobo", "Flaco", "56789013", "2023-10-13"};
        Object[] fila8 = {"pepe", "perez", "56789015", "2002-04-12"};

        modelo.addRow(fila1);
        modelo.addRow(fila2);
        modelo.addRow(fila3);
        modelo.addRow(fila4);
        modelo.addRow(fila5);
        modelo.addRow(fila6);
        modelo.addRow(fila7);
        modelo.addRow(fila8);

        // Crear la tabla y establecer el modelo
        JTable tabla = new JTable(modelo);
        tabla.setBackground(new Color(255, 255, 255));
        tabla.getTableHeader().setBackground(new Color(0, 140, 206));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.getTableHeader().setFont(new Font("Montserrat", Font.BOLD, 12));
        tabla.setFont(new Font("Montserrat", Font.PLAIN, 12));
        tabla.setRowHeight(100);

        // Agregar botones y campo de texto a la última columna
        TableColumnModel columnModel = tabla.getColumnModel();
        TableColumn accionesColumn = columnModel.getColumn(4);
        accionesColumn.setCellRenderer(new ButtonRenderer());
        accionesColumn.setCellEditor(new ButtonEditor(new JTextField()));

        // Configuración de la ventana con JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TablaDentilax());
    }
}
