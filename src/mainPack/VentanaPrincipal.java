package mainPack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

//import mainPack.ColumnaBuscar;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel bienvenido;
	private JLabel texto1;
	private JButton playBoton;
	private ConectorBBDD conector = new ConectorBBDD();
	private JTextField fieldBuscar;

	/**
	 * Autores: David Andrade Pablo Rodriguez Ian Requena 2023
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setIconImage(Toolkit.getDefaultToolkit()
							.getImage(pantallaInicial.class.getResource("/logoDentilax.png")));
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public VentanaPrincipal() {

		// asdasd

		super("Dentilax");
		VentanaPrincipal.this.setLocationRelativeTo(null);
		setResizable(false);

		// Icono
		ImageIcon icono1 = new ImageIcon("/logoDentilax.png");
		VentanaPrincipal.this.setIconImage(icono1.getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1292, 728);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logoBlanco = new JLabel("");
		logoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(logoBlanco);

		ImageIcon imagenLogo = new ImageIcon(getClass().getResource("/logoAzul.png"));
		int ancho = imagenLogo.getIconWidth();
		int alto = imagenLogo.getIconHeight();

		logoBlanco.setBounds(0, 0, 100, 100);

		Icon icono = new ImageIcon(imagenLogo.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		logoBlanco.setIcon(icono);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(null);
		buttonPanel.setForeground(new Color(255, 255, 255));
		buttonPanel.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(buttonPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 101, 100, 590);
		scrollPane.setBorder(null);
		contentPane.add(scrollPane);

		// Tabla
		DefaultTableModel modeloTabla = new DefaultTableModel();
		Tabla table = new Tabla(modeloTabla);
		// table.getColumnModel().getColumn(modeloTabla.getColumnCount() -
		// 1).setCellRenderer(new ColumnaBuscar());

		// Esto es como si fuera el <div> que encierra al componente JTable
		JPanel tablasPanel = new JPanel();
		tablasPanel.setBackground(new Color(255, 255, 255));
		tablasPanel.setBounds(99, -1, 1179, 691);
		contentPane.add(tablasPanel);
		tablasPanel.setLayout(null);
		tablasPanel.setVisible(false);
		tablasPanel.add(table);

		// El JScrollPane es necesario para añadir una tabla de forma correcta en Java.
		// Para scrolear.
		JScrollPane scrollPaneT = new JScrollPane(table);
		scrollPaneT.setBounds(-2, 0, 1040, 691);
		tablasPanel.add(scrollPaneT);
		scrollPaneT.setBackground(new Color(255, 255, 255));

		// --------------------------------------------- //
		// Panel derecho de botones y field
		JPanel panelMenuDer = new JPanel();
		tablasPanel.add(panelMenuDer);
		panelMenuDer.setLayout(null);
		// ---- Componentes ---- //
		JPanel panelComponentes = new JPanel();
		panelComponentes.setBounds(0, 0, 141, 101);
		panelMenuDer.add(panelComponentes);
		panelComponentes.setLayout(null);
		// Campo de búsqueda
		fieldBuscar = new JTextField("Buscar...");
		fieldBuscar.setBounds(10, 10, 121, 25);
		panelComponentes.add(fieldBuscar);
		// Botón Añadir
		JButton botonAñadir = new JButton("AÑADIR");
		botonAñadir.setBounds(22, 40, 97, 21);
		panelComponentes.add(botonAñadir);
		// Botón Editar
		JButton botonEditar = new JButton("EDITAR");
		botonEditar.setBounds(22, 66, 97, 21);
		panelComponentes.add(botonEditar);
		// Estilos componentes //
		panelMenuDer.setBackground(Color.WHITE);
		panelMenuDer.setBounds(1038, 0, 141, 691);
		panelComponentes.setBackground(new Color(0, 140, 206));
		botonAñadir.setBackground(Color.WHITE);
		botonAñadir.setForeground(new Color(0, 140, 206));
		botonAñadir.setFont(new Font("Montserrat", Font.BOLD, 12));
		botonEditar.setBackground(Color.WHITE);
		botonEditar.setForeground(new Color(0, 140, 206));
		botonEditar.setFont(new Font("Montserrat", Font.BOLD, 12));
		fieldBuscar.setBackground(Color.WHITE);
		fieldBuscar.setForeground(Color.GRAY);
		fieldBuscar.setFont(new Font("Montserrat", Font.PLAIN, 12));
		fieldBuscar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		// Estilos componentes //
		// Funcionalidad componentes //
		// Campo de búsqueda
		fieldBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String criterio = fieldBuscar.getText().trim();
				boolean retrocesoRealizado = true;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!criterio.isEmpty()) {
						System.out.println("\nResultado de la búsqueda:");
						conector.realizarBusqueda(criterio, modeloTabla);
						retrocesoRealizado = false;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && retrocesoRealizado) {
					conector.cargarDatosPacientes(modeloTabla);
				}
			}
		});
		fieldBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldBuscar.getText().equals("Buscar...")) {
					fieldBuscar.setText("");
					fieldBuscar.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fieldBuscar.getText().isEmpty()) {
					fieldBuscar.setText("Buscar...");
					fieldBuscar.setForeground(Color.GRAY);
				}
			}
		});
		// Botones
		// Añadir
		JPanel ventanaPanel = new JPanel();
		Paciente ventanaPaciente = new Paciente();
		botonAñadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
				tablasPanel.setVisible(false);
				ventanaPanel.add(ventanaPaciente);
				ventanaPanel.setVisible(true);

				// Obtener la referencia al labelPaciente de la instancia de Paciente
				JLabel labelPaciente = ventanaPaciente.getLabelPaciente();

				// Cambiar el texto del label
				if (labelPaciente != null) {
					labelPaciente.setText("Nuevo Paciente");
				}
			}
		});

		// Editar
		botonEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Muestra un cuadro de diálogo de entrada
				String documento = JOptionPane.showInputDialog("Introduzca el Documento del paciente:");

				// Comprueba si se ingresó un documento
		        if (documento != null && !documento.isEmpty()) {
		            // Realizar la búsqueda en la base de datos
		            conector.realizarBusqueda(documento, modeloTabla);

		            // Obtener el nombre y apellidos del primer resultado
		            String nombre = "";
		            String apellidos = "";

		            if (modeloTabla.getRowCount() > 0) {
		                nombre = (String) modeloTabla.getValueAt(0, 0);
		                apellidos = (String) modeloTabla.getValueAt(0, 1);
		            }

		            // Actualizar el texto de labelPaciente con el nombre y apellidos
		            bienvenido.setVisible(false);
					texto1.setVisible(false);
					playBoton.setVisible(false);
					tablasPanel.setVisible(false);
					ventanaPanel.add(ventanaPaciente);
					ventanaPanel.setVisible(true);
		            ventanaPaciente.labelPaciente.setText(nombre + " " + apellidos);
		        } else {
		            // Se canceló el ingreso del documento o se dejó en blanco
		            System.out.println("Operación cancelada");
		        }
			}
		});
		// Funcionalidad componentes //
		// ---- Componentes ---- //
		// --------------------------------------------- //

		// Botón de Pacientes, que está en la barra lateral izquierda del JFrame.
		java.net.URL imgUrl1 = getClass().getResource("/pacientesIcono.png");
		Icon icon = new ImageIcon(imgUrl1);
		buttonPanel.setLayout(null);
		JButton button1 = new JButton(icon);
		button1.setForeground(new Color(255, 255, 255));
		button1.setBounds(20, 10, 50, 58);
		button1.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		button1.setBackground(Color.WHITE);
		button1.setBorderPainted(false);
		buttonPanel.add(button1);

		// Cuando se le hace click al botón, se muestra la tabla, se cargan los datos de
		// la bbdd en la tabla, etc.
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Se oculta lo que estaba antes en el "panel principal", por llamarlo así
					bienvenido.setVisible(false);
					texto1.setVisible(false);
					playBoton.setVisible(false);

					// Si la conexión a la base de datos es correcta, se cargan los datos de la
					// tabla paciente de la bbdd en nuestra tabla
					if (conector.conectarConBBDD()) {
						conector.cargarDatosPacientes(modeloTabla);
						tablasPanel.setVisible(true); // se muestra la tabla
					} else {
						JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al conectar con la base de datos",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al cargar los datos de pacientes",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		// ...Demás botones

		java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
		Icon icon2 = new ImageIcon(imgUrl2);
		JButton button2 = new JButton(icon2);
		button2.setBounds(20, 85, 50, 58);
		button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
		button2.setBackground(Color.WHITE);
		button2.setBorderPainted(false);
		buttonPanel.add(button2);

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
			}
		});

		java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
		Icon icon3 = new ImageIcon(imgUrl3);
		JButton button3 = new JButton(icon3);
		button3.setBounds(20, 159, 50, 58);
		button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
		button3.setBackground(Color.WHITE);
		button3.setBorderPainted(false);
		buttonPanel.add(button3);

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
			}
		});

		java.net.URL imgUrl4 = getClass().getResource("/materialIcono.png");
		Icon icon4 = new ImageIcon(imgUrl4);
		JButton button4 = new JButton(icon4);
		button4.setBounds(20, 228, 50, 58);
		button4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
		button4.setBackground(Color.WHITE);
		button4.setBorderPainted(false);
		buttonPanel.add(button4);

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
			}
		});

		java.net.URL imgUrl5 = getClass().getResource("/facturacionIcono.png");
		Icon icon5 = new ImageIcon(imgUrl5);
		JButton button5 = new JButton(icon5);
		button5.setBounds(20, 296, 50, 58);
		button5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
		button5.setBackground(Color.WHITE);
		button5.setBorderPainted(false);
		buttonPanel.add(button5);

		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
			}
		});

		java.net.URL imgUrl6 = getClass().getResource("/pedidosIcono.png");
		Icon icon6 = new ImageIcon(imgUrl6);
		JButton button6 = new JButton(icon6);
		button6.setBounds(20, 373, 50, 58);
		button6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
		button6.setBackground(Color.WHITE);
		button6.setBorderPainted(false);
		buttonPanel.add(button6);

		button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
			}
		});

		java.net.URL imgUrl7 = getClass().getResource("/proveedoresIcono.png");
		Icon icon7 = new ImageIcon(imgUrl7);
		JButton button7 = new JButton(icon7);
		button7.setBounds(20, 441, 50, 58);
		button7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
		button7.setBackground(Color.WHITE);
		button7.setBorderPainted(false);
		buttonPanel.add(button7);

		button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
			}
		});

		java.net.URL imgUrl8 = getClass().getResource("/tratamientosIcono.png");
		Icon icon8 = new ImageIcon(imgUrl8);
		JButton button8 = new JButton(icon8);
		button8.setBounds(20, 509, 50, 58);
		button8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
		button8.setBackground(Color.WHITE);
		button8.setBorderPainted(false);
		buttonPanel.add(button8);

		button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
			}
		});

		// java.net.URL imgUrl9 = getClass().getResource("/especialistasIcono.png");
		// Icon icon9 = new ImageIcon(imgUrl9);

		java.net.URL imgUrl10 = getClass().getResource("/usuariosIcono.png");
		Icon icon10 = new ImageIcon(imgUrl10);

		JLabel labeltiPacientes = new JLabel("Pacientes");
		labeltiPacientes.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiPacientes.setBounds(20, 68, 50, 13);
		buttonPanel.add(labeltiPacientes);

		JLabel labeltiDoctores = new JLabel("Doctores");
		labeltiDoctores.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiDoctores.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiDoctores.setBounds(20, 145, 50, 13);
		buttonPanel.add(labeltiDoctores);

		JLabel labeltiCitas = new JLabel("Citas");
		labeltiCitas.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiCitas.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiCitas.setBounds(20, 216, 50, 13);
		buttonPanel.add(labeltiCitas);

		JLabel labeltiMaterial = new JLabel("Material");
		labeltiMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiMaterial.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiMaterial.setBounds(20, 284, 50, 13);
		buttonPanel.add(labeltiMaterial);

		JLabel labeltiFacturas = new JLabel("Facturas");
		labeltiFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiFacturas.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiFacturas.setBounds(20, 353, 50, 13);
		buttonPanel.add(labeltiFacturas);

		JLabel labeltiPedidos = new JLabel("Pedidos");
		labeltiPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiPedidos.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiPedidos.setBounds(20, 429, 50, 13);
		buttonPanel.add(labeltiPedidos);

		JLabel labeltiStock = new JLabel("Stock");
		labeltiStock.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiStock.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiStock.setBounds(20, 498, 50, 13);
		buttonPanel.add(labeltiStock);

		JLabel labeltiTratamientos = new JLabel("Tratamientos");
		labeltiTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiTratamientos.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiTratamientos.setBounds(10, 565, 68, 13);
		buttonPanel.add(labeltiTratamientos);

		bienvenido = new JLabel(
				"<html><font color='#008CCE'>¡Bienvenido</font> admin<font color='#008CCE'>!</font></html>");
		bienvenido.setFont(new Font("Montserrat Medium", Font.BOLD, 60));
		bienvenido.setBounds(387, 210, 725, 62);
		contentPane.add(bienvenido);

		texto1 = new JLabel(
				"<html><div align='center'>Pulsa para un tutorial corto y te<br>mostramos cómo utilizar la<br> aplicación</div></html>");
		texto1.setHorizontalAlignment(SwingConstants.CENTER);
		texto1.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
		texto1.setBounds(499, 282, 421, 109);
		contentPane.add(texto1);

		java.net.URL imgUrl11 = getClass().getResource("/play.png");
		Icon icon11 = new ImageIcon(imgUrl11);
		playBoton = new JButton(icon11);
		playBoton.setBounds(679, 400, 57, 55);
		playBoton.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
		playBoton.setBackground(Color.WHITE);
		contentPane.add(playBoton);

		// JMENU BAR JITEM ETC

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Clases");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Paciente");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnNewMenu_1.add(mntmNewMenuItem);

		ventanaPanel.setBackground(new Color(255, 255, 255));
		ventanaPanel.setBounds(99, -1, 1179, 691);
		contentPane.add(ventanaPanel);
		ventanaPanel.setLayout(null);
		ventanaPanel.setVisible(false);

		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
				tablasPanel.setVisible(false);
				ventanaPanel.add(ventanaPaciente);
				ventanaPanel.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Doctor");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mnNewMenu.add(mnNewMenu_1);

		Doctor ventanaDoctor = new Doctor();

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				playBoton.setVisible(false);
				tablasPanel.setVisible(false);
				ventanaPanel.add(ventanaDoctor);
				ventanaPanel.setVisible(true);
			}
		});

		logoBlanco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				bienvenido.setVisible(true);
				texto1.setVisible(true);
				playBoton.setVisible(true);
				ventanaPanel.setVisible(false);
				tablasPanel.setVisible(false);
			}
		});

		logoBlanco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		playBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		playBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String videoPath = "C:\\Users\\ianre\\git\\DentalixTeam\\recursos\\tutorial1.mkv";

				try {
					Desktop.getDesktop().open(new File(videoPath));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

	}
}