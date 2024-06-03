//1.Estamos declarando el paquete
package Cibertec; 

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

	
//3. Para hacer la GUI tenemos que extender a la clase JFrame
class Ejercicio005_Obsequio_If extends JFrame implements ActionListener{
//Hemos creado la clase Cilindro, 
//Y vamos a usar esa clase para hacer una GUI debemos extender de la clase Cilindro de la clase JFRAME
//A Ese JFrame extiende la clase ACTIONLISTENER , esta clase va captar acciones	
	
	private static final long serialVersionUID = 1L; //Declaracion de variables - Se guarda serializado

	// Declaración de variables, que se introduciran 

	private JLabel lblNumBolos; 
	
	private JTextField txtNumBolos;

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
			//se usa para definir la logica de la ejecucion de un hilo en JAVA
			public void run() { try { Ejercicio005_Obsequio_If frame = new Ejercicio005_Obsequio_If();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//CREA LA GUI - CONSTRUCTOR
	//Vamos a darle valores 
	public Ejercicio005_Obsequio_If() {
		//ContentPane
		setTitle("Obsequios de Tienda"); //Establesco titulo de ventana, le doy valor
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		
		//textofijo
		lblNumBolos = new JLabel("N° de Bolo"); //completo a llenar los valores de las variables //texto de radio
		lblNumBolos.setBounds(10, 13, 80, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblNumBolos);  //Va agregar al panel
		
		
		
		
		//nombre de los campos vacios
		txtNumBolos = new JTextField(); //nuevo objeto de la clase JTextField, lo que esta entre parentesis va depender de lo que ingresa el usuario
		txtNumBolos.setBounds(90, 10, 90, 20);
		getContentPane().add(txtNumBolos); //agrego
		txtNumBolos.setColumns(10);  //Establezco como columna de medida de 10
		
		
		
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
	int NBolos;
	String result = " "; //la variable result sera un texto

	
	//ENTRADA DE DATOS
	NBolos = Integer.parseInt(txtNumBolos.getText()); //Esto viene del recuadro de JTextFiel y eso es texto entonces ingresara como texto por lo que te teno que convertirlo a double
	//pasedouble va convertir a decimal lo que esta dentro del txt radio, que esta en el jtextFiel
	
	//PROCESO DE DATOS
	if(NBolos>0 && NBolos<=20)
		result = "Gano un lapicero";

	if(NBolos >=21 && NBolos <=40)
		result = "Gano un cuaderno de 100 hojas";
	
	if(NBolos >=41 && NBolos <=60)
		result = "Gano una caja de plumones";
	
	if(NBolos >=61 && NBolos <=80)
		result = "Gano un cuaderno espiral";
	
	if(NBolos >=81 && NBolos <=99)
		result = "Gano una agenda";
	
	if(NBolos ==100)
		result = "Gano una mochila";

	if(NBolos >100)
		result = "Valores ingresados incorrectos";

	if(NBolos <1)
		result = "Valores ingresados incorrectos";
	
	
	//SALIDA DE DATOS
	txtS.setText("El premio es: " + result + "\n");
	}
	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		//El metodo borrar, me va borrar todo		
	txtNumBolos.setText("");
	
	txtS.setText("");
	
	txtNumBolos.requestFocus();
	//requestFocus - volver a comenzar el txtRadio en la gui
	}
}
