import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorConsultar extends JFrame {

    private JPanel contentPane;
    private JTextField textField_salario;
    private JTextField textField_idespecialidad;
    private JTextField textField_email;
    private JTextField textField_id;
    private static final Font fuenteLabel = new Font("Montserrat", Font.PLAIN, 20);
    private static final Font fuenteGrande = new Font("Montserrat", Font.PLAIN, 50);
    private ImageIcon icono;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DoctorConsultar frame = new DoctorConsultar();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DoctorConsultar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Logo Fondo azul
        JLabel logoBlanco = new JLabel("");
        logoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(logoBlanco);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/logoAzul.png"));
        int ancho = imagen.getIconWidth();
        int alto = imagen.getIconHeight();
        logoBlanco.setBounds(0, 0, ancho, alto);

        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        logoBlanco.setIcon(icono);

        // JScrollPane para los botones del menú
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 101, 100, 590);
        contentPane.add(scrollPane);

        // Panel con los botones del menú
        JPanel buttonPanel = new JPanel();
        scrollPane.setViewportView(buttonPanel);
        buttonPanel.setBackground(Color.decode("#008cce"));
        buttonPanel.setLayout(new GridLayout(10, 1, 0, 5)); // GridLayout para alinear los botones verticalmente

        // Crear y agregar botones al panel
        for (int i = 1; i <= 10; i++) {
            JButton button = crearBoton("/icono" + i + ".png", "Botón " + i);
            buttonPanel.add(button);
        }

        // Panel principal
        JScrollPane editarPanel = new JScrollPane();
        editarPanel.setBounds(100, 0, 1164, 670);
        contentPane.add(editarPanel);

        // ... (Código para la imagen, labels, textfields, etc.)

        // Crear y agregar los botones de guardar, eliminar y volver
        JButton btnGuardar = crearBoton("/save.png", "Guardar");
        JButton btnEliminar = crearBoton("/eliminar.png", "Eliminar");
        JButton btnVolver = crearBoton("/volverIcono.png", "Volver");

        // Panel para los botones de guardar, eliminar y volver
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(70, 130, 180));
        panel_1.setBounds(591, 593, 592, 75);
        panel_1.setLayout(new FlowLayout()); // FlowLayout para alinear los botones horizontalmente
        panel_1.add(btnGuardar);
        panel_1.add(btnEliminar);
        panel_1.add(btnVolver);
        contentPane.add(panel_1);
    }

    private JButton crearBoton(String imagePath, String buttonText) {
        java.net.URL imgUrl = getClass().getResource(imagePath);
        Icon icon = new ImageIcon(imgUrl);
        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(98, 40));
        button.setBackground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para el botón
            }
        });
        return button;
    }
}
