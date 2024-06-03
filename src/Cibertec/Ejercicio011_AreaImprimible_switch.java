//1.Estamos declarando el paquete
package Cibertec; 

//2.Importamos Libreria
	import java.awt.EventQueue;
	import java.awt.Font;
	import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;

	
//3. Para hacer la GUI tenemos que extender a la clase JFrame
class Ejercicio011_AreaImprimible_switch extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L; 

	// Declaración de variables 
	
	private JLabel lblTipo;

	private JLabel lblMsuperior; 
	private JLabel lblMinferior; 
	private JLabel lblMizquierdo; 
	private JLabel lblMderecho;
	
	private JTextField txtMsuperior;
	private JTextField txtMinferior;
	private JTextField txtMizquierdo;
	private JTextField txtMderecho;
	
	private JComboBox<String> cboDimensiones;
	
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
			public void run() { try { Ejercicio011_AreaImprimible_switch frame = new Ejercicio011_AreaImprimible_switch();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//CREA LA GUI - CONSTRUCTOR
	//Vamos a darle valores 
	public Ejercicio011_AreaImprimible_switch() {
		setTitle("Area Imprimible"); //Establesco titulo de ventana, le doy valor
		setBounds(150, 300, 450, 339); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		setLocationRelativeTo(null);
		
		
		lblTipo = new JLabel("Tipo de Papel");
		lblTipo.setBounds(10, 7, 80, 14); 
		getContentPane().add(lblTipo);
		
		
		lblMsuperior = new JLabel("Msuperior (cm)"); 
		lblMsuperior.setBounds(10, 33, 80, 14); 
		getContentPane().add(lblMsuperior);
		
		lblMinferior = new JLabel("Minferior (cm)");
		lblMinferior.setBounds(10, 58, 80, 14); 
		getContentPane().add(lblMinferior);
		
		lblMizquierdo = new JLabel("Mizquierdo (cm)");
		lblMizquierdo.setBounds(10, 83, 80, 14); 
		getContentPane().add(lblMizquierdo);
		
		lblMderecho = new JLabel("Mderecho (cm)");
		lblMderecho.setBounds(10, 108, 80, 14); 
		getContentPane().add(lblMderecho);
		
		
		cboDimensiones = new JComboBox<String>(); 
		cboDimensiones.setModel(new DefaultComboBoxModel<String>(new String[] {
		"A4", "B5", "A5", "Carta", "Legal", "Ejecutivo", "Media Carta"})) ;
		cboDimensiones.setBounds(90,7,90,20);
		getContentPane().add(cboDimensiones); 
		
		
		txtMsuperior = new JTextField(); //nuevo objeto de la clase JTextField, lo que esta entre parentesis va depender de lo que ingresa el usuario
		txtMsuperior.setBounds(90, 33, 80, 18);
		getContentPane().add(txtMsuperior); //agrego
		txtMsuperior.setColumns(10);  //Establezco como columna de medida de 10
		
		txtMinferior = new JTextField();
		txtMinferior.setBounds(90, 58, 80, 18);
		getContentPane().add(txtMinferior);
		txtMinferior.setColumns(10);
		
		txtMizquierdo = new JTextField();
		txtMizquierdo.setBounds(90, 83, 80, 18);
		getContentPane().add(txtMizquierdo);
		txtMizquierdo.setColumns(10);
		
		txtMderecho = new JTextField();
		txtMderecho.setBounds(90, 108, 80, 18);
		getContentPane().add(txtMderecho);
		txtMderecho.setColumns(10);
		
		
		btnProcesar = new JButton("Procesar"); //creo
		btnProcesar.addActionListener(this); //accion
		btnProcesar.setBounds(335, 9, 89, 23);  //ubico
		getContentPane().add(btnProcesar); //agrego
		
		btnBorrar = new JButton("Borrar"); 
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 34, 89, 23);
		getContentPane().add(btnBorrar);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 153, 414, 120);
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
	//Metodo btnProcesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {

	//DECLARO VARIABLES
	int tipo;
	double msuperior, minferior, mderecho, mizquierdo, ancho, alto, area;

	
	//ENTRADA DE DATOS
	tipo = cboDimensiones.getSelectedIndex();
	
	msuperior = Double.parseDouble(txtMsuperior.getText()); 
	minferior = Double.parseDouble(txtMinferior.getText());
	mderecho = Double.parseDouble(txtMderecho.getText());
	mizquierdo = Double.parseDouble(txtMizquierdo.getText());


	//PROCESO DE DATOS
	//1. Dar valor a los tipos de papel
	// Determina el ancho y el alto del papel en cm
	switch (tipo) {
		
		case 0:
		ancho = 29.7;
		alto = 21.0;
		break;
		
		case 1:
		ancho = 18.2;
		alto = 25.7;
		break;
		
		case 2:
		ancho = 14.8;
		alto = 21.0;
		break;
		
		case 3:
		ancho = 8.5 * 2.54;
		alto = 11 * 2.54;
		break;
		
		case 4:
		ancho = 8.5 * 2.54;
		alto = 14 * 2.54;
		break;
		
		case 5:
		ancho = 7.25 * 2.54;
		alto = 10.5 * 2.54;
		break;
			
		default:
		ancho = 5.5 * 2.54;
		alto = 8.5 * 2.54;
	}
	
	// Calcula el area imprimible
	area = (ancho - mizquierdo - mderecho) * (alto - msuperior - minferior);
	 	
	// Muestra al área imprimible
	txtS.setText("Área imprimible : " + area + "cm²");
	}
	
	//METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtMsuperior.setText("");
	txtMinferior.setText("");
	txtMizquierdo.setText("");
	txtMderecho.setText("");
	
	txtS.setText("");
	txtMsuperior.requestFocus();
}
}
