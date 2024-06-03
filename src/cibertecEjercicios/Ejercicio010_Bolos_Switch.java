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

	
//3.CREACION DE GUI	
class Ejercicio010_Bolos_Switch extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; 

	// Declaración de variables 

	private JLabel lblImporte; 
	private JLabel lblBolo;
	
	private JTextField txtImporte;
	private JTextField txtBolo;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;


	//DECLARO METODO MAIN
	public static void main(String[] args) { //El metodo main es el metodo que ejecuta la aplicacion
		
		try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
			}
		
		EventQueue.invokeLater(new Runnable() {
			//Dentro del metodo main hay un metodo run
			//se usa para definir la loica de la ejecucionde un hio en JAVA
			public void run() { try { Ejercicio010_Bolos_Switch frame = new Ejercicio010_Bolos_Switch();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//CREA LA GUI - CONSTRUCTOR
	public Ejercicio010_Bolos_Switch() {
		setTitle("OBSEQUIO"); 
		setBounds(150, 300, 450, 239);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		getContentPane().setLayout(null); 
		
		lblImporte = new JLabel("Monto de Importe"); 
		lblImporte.setBounds(10, 13, 90, 14); 
		getContentPane().add(lblImporte);  
		
		lblBolo = new JLabel("Numero de Bolo");
		lblBolo.setBounds(10, 38, 80, 14); 
		getContentPane().add(lblBolo);
		
		txtImporte = new JTextField();
		txtImporte.setBounds(110, 10, 90, 20);
		getContentPane().add(txtImporte); 
		txtImporte.setColumns(10);  
		
		txtBolo = new JTextField();
		txtBolo.setBounds(110, 35, 90, 20);
		getContentPane().add(txtBolo);
		txtBolo.setColumns(10);
		
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

	if (arg0.getSource() == btnProcesar) { //Si eh presionado btnProcesar
		actionPerformedBtnProcesar(arg0); //Se ejecutara btnProcesar

	} if (arg0.getSource() == btnBorrar) { //Si eh presionado btnBorrar
		actionPerformedBtnBorrar(arg0);//Si eh presionado btnBorrar
		}
	}


//DECLARO VARIABLLES QUE ENTRARAN A MI ALORITMO
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

	//DECLARO VARIABLES
		double ITPagar;
		int NBolo;
		String obsequio;
		
		
	//ENTRADA DE DATOS
		ITPagar = Double.parseDouble(txtImporte.getText());
		NBolo = Integer.parseInt(txtBolo.getText());
		
	//PROCESO DE DATOS
		if(ITPagar > 500) {
			switch (NBolo) {
			
			case 10: obsequio = "Una Agenda";
			break;
			
			case 20: obsequio = "Una Reloj";
			break;
			
			case 30: obsequio = "Una USB";
			break;
			
			case 40: obsequio = "Una Perfume";
			break;
			
			case 50: obsequio = "Una Radio";
			break;
			
			default : obsequio = "Una pelota";
			
			}
			txtS.setText("El obsequio es:" + obsequio);
		}
		
		else 
			txtS.setText("No obtuvo Premio");
		
		
	}
	
	
	

	//METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		
	txtImporte.setText("");
	txtBolo.setText("");
	txtS.setText("");
	txtImporte.requestFocus();
	}
}
