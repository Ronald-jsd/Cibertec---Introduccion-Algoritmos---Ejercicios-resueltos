package Cibertec;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Ejercicio013_Universidad_VarElseIf extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	// Declaración de variables
	private JLabel lblCategoria;
	private JLabel lblPromedio;
	private JComboBox<String> cboCategoria;
	private JTextField txtPromedio;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
		
	// Declaración de variables globales
		int categoria;
		double actualpen, nuevapen, descuento, promedio;
		
		// Lanza la aplicación
		
		public static void main(String[] args) {
		try {
		UIManager.setLookAndFeel(
		"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Throwable e) {
		e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio013_Universidad_VarElseIf frame = new Ejercicio013_Universidad_VarElseIf();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}
		
		
// Crea la GUI
	public Ejercicio013_Universidad_VarElseIf() {
	
		setTitle("Universidad");	
		setBounds(100, 100, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
	lblCategoria = new JLabel("Categoría");
	lblCategoria.setBounds(10, 13, 80, 14);
	getContentPane().add(lblCategoria);
	
	lblPromedio = new JLabel("Promedio");
	lblPromedio.setBounds(10, 38, 80, 14);
	getContentPane().add(lblPromedio);
	
	cboCategoria = new JComboBox<String>();
	cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {
	"A", "B", "C", "D" }));
	cboCategoria.setBounds(90, 10, 90, 20);
	getContentPane().add(cboCategoria);
	
	txtPromedio = new JTextField();
	txtPromedio.setBounds(90, 35, 90, 20);
	getContentPane().add(txtPromedio);
	txtPromedio.setColumns(10);
	
	btnProcesar = new JButton("Procesar");
	btnProcesar.addActionListener(this);
	btnProcesar.setBounds(335, 9, 89, 23);
	getContentPane().add(btnProcesar);
	
	btnBorrar = new JButton("Borrar");
	btnBorrar.addActionListener(this);
	btnBorrar.setBounds(335, 34, 89, 23);
	getContentPane().add(btnBorrar);
	
	scpScroll = new JScrollPane();
	scpScroll.setBounds(10, 69, 414, 120);
	getContentPane().add(scpScroll);
	
	txtS = new JTextArea();
	txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
	scpScroll.setViewportView(txtS);
	
	}
	
	
	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
			}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
			}
	}
	
	//Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		ingresarDatos();
		calcularPensionActual();
		calcularDescuento();
		calcularNuevaPension();
		mostrarResultados();
		}
	
		//Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtPromedio.setText("");
		txtS.setText("");
		txtPromedio.requestFocus();
		}
		
	//Ingresa datos
	void ingresarDatos() {
	categoria = cboCategoria.getSelectedIndex();
	promedio = Double.parseDouble(txtPromedio.getText());
	}
	
	//Calcula la pensión actual
	void calcularPensionActual() {
	if (categoria == 0)
	actualpen = 550;
	else if (categoria == 1)
	actualpen = 500;
	else if (categoria == 2)
	actualpen = 460;
	else
	actualpen = 400;
	}
	
	//Calcula el descuento
	void calcularDescuento() {
	if (promedio <= 13.99)
	descuento = 0;
	else if (promedio <= 15.99)
	descuento = 0.10 * actualpen;
	else if (promedio <= 17.99)
	descuento = 0.12 * actualpen;
	else
	descuento = 0.15 * actualpen;
	}
	
	//Calcula la nueva pensión
	void calcularNuevaPension() {
	nuevapen = actualpen - descuento;
	}
	
	//Muestra resultados
	void mostrarResultados() {
	txtS.setText("");
	imprimir("Pensión actual : S/. " + actualpen);
	imprimir("Descuento : S/. " + descuento);
	imprimir("Nueva pensión : S/. " + nuevapen);
	}
	
	//Imprime una línea de texto incluyendo un salto de línea
	void imprimir(String cad) {
	txtS.append(cad + "\n");
	}
	}

