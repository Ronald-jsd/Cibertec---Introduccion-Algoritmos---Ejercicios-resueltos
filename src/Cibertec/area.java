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

	
//3.CREACION DE GUI	
//3. Para hacer la GUI tenemos que extender a la clase JFrame
class area extends JFrame implements ActionListener{
//Hemos creado la clase Cilindro, 
//Y vamos a usar esa clase para hacer una GUI debemos extender de la clase Cilindro de la clase JFRAME
//A Ese JFrame extiende la clase ACTIONLISTENER , esta clase va captar acciones	
	
	private static final long serialVersionUID = 1L; //Declaracion de variables - Se guarda serializado

	// Declaración de variables 

	private JLabel lblRadio; 
	private JLabel lblAltura;
	
	private JTextField txtRadio;
	private JTextField txtAltura;
	
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
			public void run() { try { area frame = new area();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//CREA LA GUI - CONSTRUCTOR
	//Vamos a darle valores 
	public area() {
		setTitle("Cilindro"); //Establesco titulo de ventana, le doy valor
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		lblRadio = new JLabel("Radio"); //completo a llenar los valores de las variables //texto de radio
		lblRadio.setBounds(10, 13, 80, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblRadio);  //Va agregar al panel
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 38, 80, 14); 
		getContentPane().add(lblAltura);
		
		txtRadio = new JTextField(); //nuevo objeto de la clase JTextField, lo que esta entre parentesis va depender de lo que ingresa el usuario
		txtRadio.setBounds(90, 10, 90, 20);
		getContentPane().add(txtRadio); //agrego
		txtRadio.setColumns(10);  //Establezco como columna de medida de 10
		
		txtAltura = new JTextField();
		txtAltura.setBounds(90, 35, 90, 20);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);
		
		btnProcesar = new JButton("Procesar"); //creo
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

	public void actionPerformed(ActionEvent arg0) {
	if (arg0.getSource() == btnProcesar) { 
		actionPerformedBtnProcesar(arg0); 

	} if (arg0.getSource() == btnBorrar) { 
		
		}
	}
	
	
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		//AREA DE UN CILINDRO
		double area, radio, altura;
	
		radio = Double.parseDouble(txtRadio.getText());
		altura = Double.parseDouble(txtAltura.getText());
		
			area= 2*Math.PI*radio*(radio+altura);
			
			txtS.setText("El area es: " + area);
		
		}
		

	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {

	
		
		
	}
}
