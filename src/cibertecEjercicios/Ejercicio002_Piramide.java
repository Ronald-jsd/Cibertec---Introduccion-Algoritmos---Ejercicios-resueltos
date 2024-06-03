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

	class Ejercicio002_Piramide extends JFrame implements ActionListener{
		
		//Declaracion de variables -
		private static final long serialVersionUID = 1L;
		
		//textos
		private JLabel lblLargo; 
		private JLabel lblAncho;
		private JLabel lblAltura;

		//cajas
		private JTextField txtLargo;
		private JTextField txtAncho;
		private JTextField txtAltura;

		//botones
		private JButton btnProcesar;
		private JButton btnBorrar;
		
		//scroll y textarea
		private JScrollPane scpScroll;
		private JTextArea txtS;
		
		
		//DECLARO METODO MAIN - (Metodo que ejecuta la aplicación)
	public static void main(String[] args) {
		try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
			}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() { try { Ejercicio002_Piramide frame = new Ejercicio002_Piramide();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
	}
	
	//CREA LA GUI - CONSTRUCTOR (Y darle valores declarando)
	
	public Ejercicio002_Piramide() {
		setTitle("Piramide"); //titulo de ventana
		setBounds(200, 300, 550, 400); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		
		//para los textos que van a ir - 
		lblLargo = new JLabel("Largo"); //texto radio
		lblLargo.setBounds(10, 13, 80, 14); //x,y, ancho, alto
		getContentPane().add(lblLargo);  //Va a agregar al panel
		
		lblAncho = new JLabel("Ancho");
		lblAncho.setBounds(10, 38, 80, 14); 
		getContentPane().add(lblAncho);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 62, 80, 14); 
		getContentPane().add(lblAltura);
		
		
		//para las cajas/campos que van a ir -inputs
		txtLargo = new JTextField(); //campo de texto donde se completa el valor de radio
		txtLargo.setBounds(90, 10, 90, 20);
		getContentPane().add(txtLargo); //agrego
		txtLargo.setColumns(10);  //Establezco como columna de medida de 10
		
		txtAncho = new JTextField();
		txtAncho.setBounds(90, 35, 90, 20);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(90, 62, 90, 20);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		
		//para los botones que se muestran
		btnProcesar = new JButton("Procesar"); //creo botton procesar
		btnProcesar.addActionListener(this); //accion
		btnProcesar.setBounds(335, 9, 89, 23);  //ubico
		getContentPane().add(btnProcesar); //agrego
		
		btnBorrar = new JButton("Borrar"); 
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 34, 89, 23);
		getContentPane().add(btnBorrar);
		
		scpScroll = new JScrollPane(); //creo scroll
		scpScroll.setBounds(50, 100, 414, 120); //Tamaño del text area
		getContentPane().add(scpScroll); 
		
		txtS = new JTextArea(); //creo Textarea (Muestran resultados)
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12)); //font 12px 
		scpScroll.setViewportView(txtS);
		}
	
	// Direcciona eventos de tipo ActionEvent 

		public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == btnProcesar) { 
			actionPerformedBtnProcesar(arg0);

		} if (arg0.getSource() == btnBorrar) { 
			actionPerformedBtnBorrar(arg0);
			}
		}
		
		
		//DECLARO VARIABLES 
		protected void actionPerformedBtnProcesar(ActionEvent arg0) {
			double m, n, h, are, vol;

			//ENTRADA DE DATOS
			
			//convertimos el valor de entrada de string a double
			m = Double.parseDouble(txtLargo.getText()); 
			n = Double.parseDouble(txtAncho.getText());
			h = Double.parseDouble(txtAltura.getText());

			//PROCESO DE DATOS
			are =  m*n; 
			vol = (are*h)/3;

			//SALIDA DE DATOS
			txtS.setText("El Area es: " + are + "\n"); 
			txtS.append ("El Volumen es : " + vol); }
			
		
			//Al accionar btn Borrar se borran los campos siuientes declarados
			//gracias al metodo action btnBorrar
			protected void actionPerformedBtnBorrar(ActionEvent arg0) { 				
			txtLargo.setText("");
			txtAncho.setText("");
			txtAltura.setText("");
			
			
			txtS.setText("");
			txtLargo.requestFocus();
			//(requestFocus)al presionar btn borrar sera redirigido al campo declarado
			}
		
}
