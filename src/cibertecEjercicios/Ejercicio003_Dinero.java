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

	class Ejercicio003_Dinero extends JFrame implements ActionListener{
		
		//Declaracion de variables -
		private static final long serialVersionUID = 1L;
		
		//textos
		private JLabel lblDinero; 
		

		//cajas
		private JTextField txtDinero;
	

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
			public void run() { try { Ejercicio003_Dinero frame = new Ejercicio003_Dinero();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
	}
	
	//CREA LA GUI - CONSTRUCTOR 
	//(Y darle valores declarando)
	//Segun la cantidad de datos de entrada
	
	public Ejercicio003_Dinero() {
		setTitle("Dinero"); //titulo de ventana
		setBounds(200, 300, 550, 400); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		
		//para los textos que van a ir - 
		lblDinero = new JLabel("Dinero"); //texto 
		lblDinero.setBounds(10, 13, 80, 14); //x,y, ancho, alto
		getContentPane().add(lblDinero);  //Va a agregar al panel
		
		
		
		
		//para las cajas/campos que van a ir -inputs
		txtDinero = new JTextField(); //campo de texto donde se completa el valor de radio
		txtDinero.setBounds(90, 10, 90, 20);
		getContentPane().add(txtDinero); //agrego
		txtDinero.setColumns(10);  //Establezco como columna de medida de 10
		
		
		
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
			double dineroHerencia, Tam, Jos, Cal, Dan, Dav;

			//ENTRADA DE DATOS
			
			//convertimos el valor de entrada de string a double
			//La variable que ingresara
			dineroHerencia = Double.parseDouble(txtDinero.getText()); 
			

			//PROCESO DE DATOS
			Jos =  0.27*dineroHerencia; 
			Tam = 0.85*Jos;
			Dan = 0.25*dineroHerencia;
			Cal = 0.23*(Jos+Dan);
			Dav = dineroHerencia-(Jos+Tam+Dan+Cal);
			
			
			
			
			//SALIDA DE DATOS
			txtS.setText("Josué recibira: " + Jos + "\n"); 
			txtS.append ("Tamar recibira : " + Tam+ "\n"); 
			txtS.append ("Daniel recibira : " + Dan+ "\n"); 
			txtS.append ("Caleb recibira : " + Cal+ "\n"); 
			txtS.append ("David recibira : " + Dav+ "\n"); 
		}
			
	
		
			//Al accionar btn Borrar se borran los campos siuientes declarados
			//gracias al metodo action btnBorrar
			protected void actionPerformedBtnBorrar(ActionEvent arg0) { 				
			txtDinero.setText("");
			
			
			txtS.setText("");
			txtDinero.requestFocus();
			//(requestFocus)al presionar btn borrar sera redirigido al campo declarado
			}
		
		

}
