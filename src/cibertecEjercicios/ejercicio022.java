//1.Estamos declarando el paquete
package cibertecEjercicios; 

//2.Importamos Libreria
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


	
//3. Para hacer la GUI tenemos que extender a la clase JFrame
	class ejercicio022 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; //Declaracion de variables - Se guarda serializado

	// Declaración de variables, que se introduciran 

	private JLabel lblTipo; 
	private JLabel lblctdPasajero;
	
	private JComboBox<String> cboTipo;
	private JTextField txtctdPasajero;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JScrollPane scpScroll;
	private JTextArea txtS;


	int totalauto, totalcamion,totalcamioneta,totalomnibus,	totalotros;
	int pasajerosautomoviles,	pasajeroscamion ,	pasajeroscamioneta ,	pasajerosomnibus,pasajerosotross;


	//DECLARO METODO MAIN//Lanza la app
	public static void main(String[] args) { //El metodo main es el metodo que ejecuta la aplicacion
		
		try { UIManager.setLookAndFeel(
			"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Throwable e) {
			e.printStackTrace();
			}
		
			EventQueue.invokeLater(new Runnable() {
			//Dentro del metodo main hay un metodo run
			//se usa para definir la loica de la ejecucionde un hio en JAVA
			public void run() { 
			try { 
				ejercicio022 frame = new ejercicio022();
			frame.setVisible(true);
			} catch (Exception e) {
			e.printStackTrace(); }
			}
			}
			);
			}
	
	//CREA LA GUI - CONSTRUCTOR
	public ejercicio022() {
		//ContentPane
		setTitle("Transporte"); 
		setBounds(150, 300, 450, 459); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		
		//texto a mostrar
		lblTipo = new JLabel("Tipo"); //completo a llenar los valores de las variables //texto de radio
		lblTipo.setBounds(10, 13, 80, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblTipo);  //Va agregar al panel
		
		lblctdPasajero = new JLabel("Cantidad de pasajero");
		lblctdPasajero.setBounds(10, 38, 80, 14); 
		getContentPane().add(lblctdPasajero);
		
		
		//nombre de los campos vacios
		
		//combobox
		cboTipo = new JComboBox<String>(); //Nueva instancia de la clase JCOMBOBOX
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] { //setModel, de Model se relaciona a las base de datos y estoy definiendo por deafault un arreglo de String
		"Automovil", "Camion", "Camioneta", "Omnibus", "Otros"}));   
		cboTipo.setBounds(90,10,90,20);
		getContentPane().add(cboTipo); 
		
		
		txtctdPasajero = new JTextField();
		txtctdPasajero.setBounds(90, 35, 90, 20);
		getContentPane().add(txtctdPasajero);
		txtctdPasajero.setColumns(4);
		
		
		
		
		//botones
		btnProcesar = new JButton("Procesar"); //creo
		btnProcesar.addActionListener(this); //accion
		btnProcesar.setBounds(335, 9, 89, 23);  //ubico
		getContentPane().add(btnProcesar); //agrego
		
		btnBorrar = new JButton("Borrar"); 
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 34, 89, 23);
		getContentPane().add(btnBorrar);
		
		
		//
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 69, 414, 310);
		getContentPane().add(scpScroll); 
		//
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
		}
	
	
	// Direcciona eventos de tipo ActionEvent 

	public void actionPerformed(ActionEvent arg0) {

	if (arg0.getSource() == btnProcesar) { //Si eh presionado btnProcesar
		actionPerformedBtnProcesar(arg0); //Se ejecutara btnProcesar

	} if (arg0.getSource() == btnBorrar) { //Si eh presionado btnBorrar
		actionPerformedBtnBorrar(arg0);//Si eh presionado btnBorrar
		}
	}


	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

		//DECLARO VARIABLES
	int tipoveh=0,ctdPasajero=0;
	
	tipoveh = getTipo();
	ctdPasajero = getPasajeros();
	
	
	efectuarIncrementos(tipoveh,ctdPasajero);
	
	mostrarResultados();
	
	}

	//METODO BORRAR		
		protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtctdPasajero.setText("");
		cboTipo.setSelectedIndex(0);
		txtS.setText("");
		
		txtctdPasajero.requestFocus();
		}
		
		
	
	//ENTRADA DE DATOS
	
		int getTipo() {
		return cboTipo.getSelectedIndex();
		}
		
		int getPasajeros() {
			return   Integer.parseInt(txtctdPasajero.getText()); //Esto viene del recuadro de JTextFiel y eso es texto entonces ingresara como texto por lo que te teno que convertirlo a double
		}
		
		
		
		
	//PROCESO DE DATOS
	void efectuarIncrementos(int tipveh, int ctdpasajer) {
		
	switch (tipveh) {
	case 0:
		totalauto++;
		pasajerosautomoviles += ctdpasajer;
	break;
		
	case 1:
		totalcamion++;
		pasajeroscamion += ctdpasajer;
	break;
		
	case 2:
		totalcamioneta++;
		pasajeroscamioneta += ctdpasajer;
		break;
	case 3:
		totalomnibus++;
		pasajerosomnibus+= ctdpasajer;
	break;
		
		default:
		totalotros++;
		pasajerosotross += ctdpasajer;
	break;
	
	}
	
	}
	
	//MOSTRAR RESULTADO
	 void mostrarResultados() {
	txtS.setText("");
	imprimir("CANTIDAD TOTAL DE VEHICULOS POR TIPO: " );
	imprimir("Automóviles: " + totalauto );
	imprimir("Camiones: " + totalcamion );
	imprimir("Camionetas: " + totalcamioneta );
	imprimir("Omnibuses: " + totalomnibus );
	imprimir("Otros: " + totalotros );
	
	imprimir(" ");
	
	
	imprimir("CANTIDAD TOTAL DE PASAJEROS: " );
	imprimir("Automóviles: " + pasajerosautomoviles );
	imprimir("Camiones: " + pasajeroscamion );
	imprimir("Camionetas: " + pasajeroscamioneta );

	imprimir("Omnibuses: " + pasajerosomnibus );
	imprimir("Otros: " + pasajerosotross );
	}
	
	
	 void imprimir (String cad) {
		 txtS.append(cad + "\n");
	 }
	 
	 
	 
}
