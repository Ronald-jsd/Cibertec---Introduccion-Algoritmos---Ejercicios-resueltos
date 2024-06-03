	
	//Declaro el nombre de mi paquete
	package cibertecEjercicios;
	
	
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
	
	
	//Declaro eventos de ActionListener
		//Declaramos la clase publica ,  y va heredar propiedades y metodos del JFrame e implementa eventos de action
	public class EJERCICIO021_PRACTICA extends JFrame implements ActionListener {
		
		//Serailizacion de objetos
		private static final long serialVersionUID = 1L;
		
		// Declaración de variables DEL GUI
		private JLabel lblTipoVehiculo;
		private JLabel lblCantidadPasajeros;
		private JComboBox<String> cboTipoVehiculo;
		private JTextField txtCantidadPasajeros;
		private JButton btnProcesar;
		private JButton btnBorrar;
		private JScrollPane scpScroll;
		private JTextArea txtS;
		// ---------------------------------------------------
		// Declaración de variables globales para el algoritmo
		
		int canveh0, canveh1, canveh2, canveh3, canveh4;
		int totpas0, totpas1, totpas2, totpas3, totpas4;
		// ---------------------------------------------------
		// Lanza la aplicación
		public static void main(String[] args) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Throwable e) {
				e.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						EJERCICIO021_PRACTICA frame = new EJERCICIO021_PRACTICA();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
		// METODO Crea la GUI
		public EJERCICIO021_PRACTICA() {
			setTitle("Peaje");
			setBounds(100, 100, 450, 360);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
	
			lblTipoVehiculo = new JLabel("Tipo ");
			lblTipoVehiculo.setBounds(10, 13, 120, 14);
			getContentPane().add(lblTipoVehiculo);
			lblCantidadPasajeros = new JLabel("Cantidad de pasajeros");
			lblCantidadPasajeros.setBounds(10, 38, 120, 14);
			getContentPane().add(lblCantidadPasajeros);
			cboTipoVehiculo = new JComboBox<String>();
			cboTipoVehiculo.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Automóvil", "Camión", "Camioneta", "Omnibus", "Otro" }));
			cboTipoVehiculo.setBounds(120, 10, 90, 20);
			getContentPane().add(cboTipoVehiculo);
			txtCantidadPasajeros = new JTextField();
			txtCantidadPasajeros.setBounds(130, 35, 90, 20);
			getContentPane().add(txtCantidadPasajeros);
			txtCantidadPasajeros.setColumns(10);
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(335, 9, 89, 23);
			getContentPane().add(btnProcesar);
	
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(this);
			btnBorrar.setBounds(335, 34, 89, 23);
			getContentPane().add(btnBorrar);
			scpScroll = new JScrollPane();
			scpScroll.setBounds(10, 69, 414, 241);
			getContentPane().add(scpScroll);
			txtS = new JTextArea();
			txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
			scpScroll.setViewportView(txtS);
		}
	
		// Direcciona eventos de tipo ActionEvent // Las acciones que se realiza al dar clic en el boton
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnProcesar) {
				actionPerformedBtnProcesar(arg0);
			}
			if (arg0.getSource() == btnBorrar) {
				actionPerformedBtnBorrar(arg0);
			}
		}
	
		// Procesa la pulsación del botón Procesar
		protected void actionPerformedBtnProcesar(ActionEvent arg0) {
	
			int tipoveh, ctdPasaje;
		
	
			tipoveh = getVehiculo();
			ctdPasaje = getPasajeros();
			efectuarIncrementos(tipoveh, ctdPasaje);
			mostrarResultados();
	
		}
	
		// Procesa la pulsación del botón Borrar
		protected void actionPerformedBtnBorrar(ActionEvent arg0) {
			txtCantidadPasajeros.setText("");
			txtS.setText("");
			txtCantidadPasajeros.requestFocus();
		}
	
		// Lee y retorna el tipo de vehículo
		int getVehiculo() {
			return cboTipoVehiculo.getSelectedIndex();
		}
	
		// cantidad de pasajeros
		int getPasajeros() {
			return Integer.parseInt(txtCantidadPasajeros.getText());
		}
	
		// Efectúa los incrementos necesarios
		void efectuarIncrementos(int tipvehiculo, int canp) {
			switch (tipvehiculo) {
			case 0:
				canveh0++;
				totpas0 += canp;
				break;
			case 1:
				canveh1++;
				totpas1 += canp;
				break;
			case 2:
				canveh2++;
				totpas2 += canp;
				break;
			case 3:
				canveh3++;
				totpas3 += canp;
				break;
	
			default:
				canveh4++;
				totpas4 += canp;
			}
		}
	
		// Muestra el reporte solicitado
		//se  va mostrar en el textArea las siguientes lineas 
		void mostrarResultados() {
			txtS.setText("");
			imprimir("Cantidad total de vehículos");
			imprimir("- Automóviles : " + canveh0);
			imprimir("- Camiones : " + canveh1);
			imprimir("- Camionetas : " + canveh2);
			imprimir("- Omnibuses : " + canveh3);
			imprimir("- Otros : " + canveh4);
			imprimir("");
			imprimir("Cantidad total de pasajeros");
			imprimir("- Automóviles : " + totpas0);
			imprimir("- Camiones : " + totpas1);
			imprimir("- Camionetas : " + totpas2);
			imprimir("- Omnibuses : " + totpas3);
			imprimir("- Otros : " + totpas4);
		}
	
		//Luego con el metodo imprimir  vamos agregando las cadenas, añadiendo un salto de linea  y agregando hacia abjo con append
		//Imprime una cadena con un salto de línea al final
		void imprimir(String cad) {
			txtS.append(cad + "\n");
		}
	}