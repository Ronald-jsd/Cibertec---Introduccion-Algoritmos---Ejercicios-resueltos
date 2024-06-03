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

	
	class ejercicio029 extends JFrame implements ActionListener{

	
		// Declaración de variables, que se introduciran 
	private static final long serialVersionUID = 1L; 


	private JLabel lblPeso; 
	private JLabel lblTalla;
	
	private JTextField txtPeso;
	private JTextField txtTalla;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JScrollPane scpScroll;
	private JTextArea txtS;


	//DECLARO METODO MAIN EJECUTA LA APLICACION
	public static void main(String[] args) { 
		
		try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
			}
		
		EventQueue.invokeLater(new Runnable() {
			
			//Dentro del metodo main hay un metodo run , para definir la logica de la ejecucuion
			public void run() { try { ejercicio029 frame = new ejercicio029();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//CREA LA GUI - CONSTRUCTOR
	public ejercicio029() {
		//ContentPane
		setTitle("Tienda promoción"); //Establesco titulo de ventana, le doy valor
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		//JLabel
		lblPeso = new JLabel("Peso (kg)"); //completo a llenar los valores de las variables //texto de radio
		lblPeso.setBounds(10, 13, 120, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblPeso);  //Va agregar al panel
		
		lblTalla = new JLabel("Talla (m)");
		lblTalla.setBounds(10, 38, 100, 14); 
		getContentPane().add(lblTalla);
		
		
		//JTextField
		txtPeso = new JTextField(); //nuevo objeto de la clase JTextField, lo que esta entre parentesis va depender de lo que ingresa el usuario
		txtPeso.setBounds(120, 10, 90, 20);
		getContentPane().add(txtPeso); //agrego
		txtPeso.setColumns(10);  //Establezco como columna de medida de 10
		
		txtTalla = new JTextField();
		txtTalla.setBounds(120, 35, 90, 20);
		getContentPane().add(txtTalla);
		txtTalla.setColumns(10);
		
		
		//Button
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
		scpScroll.setBounds(10, 69, 414, 120);
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


//DECLARO VARIABLLES QUE ENTRARAN A MI ALORITMO
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

	//DECLARO VARIABLES
	double  peso, talla, IMC;
	String  Diagnostico;

	//ENTRADA DE DATOS
	
	peso = Double.parseDouble(txtPeso.getText());
	talla = Double.parseDouble(txtTalla.getText());

	
	//PROCESO DE DATOS
	
	//IMC
	IMC = peso / Math.pow(talla, 2);
	
	//CLASIFICACION
	if (IMC < 18.5) 
		Diagnostico = "Bajo peso";
	else if (IMC <=24.9)
		Diagnostico = "Peso Normal";
	else if (IMC <=29.9)
		Diagnostico = "Sobrepeso";
	else if (IMC <=34.9)
		Diagnostico = "Obesidad Tipo 1";
	else if (IMC<=39.9)
		Diagnostico= "Obesidad tipo 2";
	else 
		Diagnostico = "Obesidad tipo 3";
		
	
	
	
	
	
	
	//SALIDA DE DATOS

	txtS.setText("Su IMC es: " + IMC + "\n");
	txtS.append("Su Diagnostico es: " + Diagnostico+ "\n");	
	}
	
	
	//METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtPeso.setText("");
	txtTalla.setText("");
	txtS.setText("");
	
	txtPeso.requestFocus();
	}
}
