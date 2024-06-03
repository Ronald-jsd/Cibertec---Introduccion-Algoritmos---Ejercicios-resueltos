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

	
//3. Para hacer la GUI tenemos que extender a la clase JFrame
class ejercicio024 extends JFrame implements ActionListener{
//Hemos creado la clase Cilindro, 
//Y vamos a usar esa clase para hacer una GUI debemos extender de la clase Cilindro de la clase JFRAME
//A Ese JFrame extiende la clase ACTIONLISTENER , esta clase va captar acciones	
	
	private static final long serialVersionUID = 1L; //Declaracion de variables - Se guarda serializado

	// Declaración de variables, que se introduciran 

	private JLabel lblMonto; 
	
	private JTextField txtMonto;
	
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
			public void run() { try { ejercicio024 frame = new ejercicio024();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//CREA LA GUI - CONSTRUCTOR
	//Vamos a darle valores 
	public ejercicio024() {
		//ContentPane
		setTitle("PRESTAMO"); //Establesco titulo de ventana, le doy valor
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		
		//texto a mostrar
		lblMonto = new JLabel("Monto de prestamo"); //completo a llenar los valores de las variables //texto de radio
		lblMonto.setBounds(10, 13, 120, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblMonto);  //Va agregar al panel
		
		
		
		//nombre de los campos vacios
		txtMonto = new JTextField(); //nuevo objeto de la clase JTextField, lo que esta entre parentesis va depender de lo que ingresa el usuario
		txtMonto.setBounds(120, 10, 90, 20);
		getContentPane().add(txtMonto); //agrego
		txtMonto.setColumns(4);  //Establezco como columna de medida de 10
		
		
		
		
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
	double  MonPresta, interes, MontIntTotal, MPrestMens;
	int NCuotas;
	//ENTRADA DE DATOS
	//ctddocenas = Integer.parseInt(txtctdDocna.getText()); //Esto viene del recuadro de JTextFiel y eso es texto entonces ingresara como texto por lo que te teno que convertirlo a double
	//parsedouble va convertir a decimal lo que esta dentro del txt radio, que esta en el jtextFiel
	MonPresta = Double.parseDouble(txtMonto.getText());
	
	//PROCESO DE DATOS
	
	//OBTENER NUMERO DE CUOTAS
	if(MonPresta<=5000)
		NCuotas = 2;
	else if (MonPresta<=10000)
		NCuotas = 4;
	else if (MonPresta <= 15000)
		NCuotas = 6;
	else
		NCuotas = 10;
	
	
	//OBTIENE LA TAS DE INTERES
	if(MonPresta >10000)
		interes = 0.03;
	else 
		interes = 0.05;
	
	
	//MONTO DE INTERES TOTAL
	MontIntTotal = interes * MonPresta * NCuotas;
	
	//MONTO DE LA CUOTA MENSUAL
	MPrestMens = (MonPresta + MontIntTotal) / NCuotas;
	
	
	
	//SALIDA DE DATOS
	txtS.setText("El monto mensual es: " + MPrestMens + "\n");
	txtS.append("El interes total es: " + MontIntTotal + "\n");
	txtS.append("El numero de cuotas es: " + NCuotas + "\n");

	}
	
	//Procesa accion de borrar		
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtMonto.setText("");
	txtS.setText("");
	txtMonto.requestFocus();
	//requestFocus - volver a comenzar el txtRadio en la gui
	}
}
