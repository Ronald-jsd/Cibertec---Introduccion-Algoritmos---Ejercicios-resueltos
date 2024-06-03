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

	
	class Ejercicio009_EmprVarioCriterioIFELSE extends JFrame implements ActionListener{

	
		// Declaración de variables, que se introduciran 
	private static final long serialVersionUID = 1L; 


	private JLabel lblMinTardz; 
	private JLabel lblNObser;
	
	private JTextField txtMinTardz;
	private JTextField txtNObser;
	
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
			public void run() { try { Ejercicio009_EmprVarioCriterioIFELSE frame = new Ejercicio009_EmprVarioCriterioIFELSE();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//CREA LA GUI - CONSTRUCTOR
	public Ejercicio009_EmprVarioCriterioIFELSE() {
		//ContentPane
		setTitle("Tienda promoción"); //Establesco titulo de ventana, le doy valor
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		//JLabel
		lblMinTardz = new JLabel("Minutos de tardanza"); //completo a llenar los valores de las variables //texto de radio
		lblMinTardz.setBounds(10, 13, 120, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblMinTardz);  //Va agregar al panel
		
		lblNObser = new JLabel("N° de Observaciones");
		lblNObser.setBounds(10, 38, 100, 14); 
		getContentPane().add(lblNObser);
		
		
		//JTextField
		txtMinTardz = new JTextField(); //nuevo objeto de la clase JTextField, lo que esta entre parentesis va depender de lo que ingresa el usuario
		txtMinTardz.setBounds(120, 10, 90, 20);
		getContentPane().add(txtMinTardz); //agrego
		txtMinTardz.setColumns(10);  //Establezco como columna de medida de 10
		
		txtNObser = new JTextField();
		txtNObser.setBounds(120, 35, 90, 20);
		getContentPane().add(txtNObser);
		txtNObser.setColumns(10);
		
		
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
	double  MinTard, Boni;
	int  NObse, PjPun , PjRen, PjTotal;

	//ENTRADA DE DATOS
	
	MinTard = Double.parseDouble(txtMinTardz.getText());
	NObse = Integer.parseInt(txtNObser.getText()); 

	
	//PROCESO DE DATOS

	//CLASIFICACION PUNTAJE POR RENDIMIENTO
	if(MinTard <1)
		PjPun = 10;
	else if(MinTard <= 2)
		PjPun = 8;
	else if(MinTard <= 5)
		PjPun = 6;
	else if(MinTard <= 9)
		PjPun = 4;
	else 
		PjPun = 0;
	
	
	//CLASIFICACION DE PUNTAJE POR RENDIMIENTO
	if(NObse == 0)
		PjRen = 10;
	else if(NObse == 1)
		PjRen = 8;
	else if(NObse == 2)
		PjRen = 5;
	else if(NObse == 3)
		PjRen = 1;
	else 
		PjRen = 0;
	
	//PUNTAJE TOTAL
	PjTotal= PjPun + PjRen;
	
	//BONIFICACION
	if(PjTotal < 11)
		Boni = 2.5*PjTotal;
	else if(PjTotal <=13)
		Boni = 5*PjTotal;
	else if(PjTotal <= 16)
		Boni = 7.5*PjTotal;
	else if(PjTotal <=19 )
		Boni = 10*PjTotal;
	else 
		Boni = 12.5 * PjTotal;
	
	
	
	//SALIDA DE DATOS
	txtS.setText("El Puntaje de puntualidad es: " + PjPun + "\n");
	txtS.append("El Puntaje de Rendimiento es: " + PjRen + "\n");
	txtS.append("El Puntaje de Total es: " + PjTotal + "\n");
	txtS.append("La bonificación es: " + Boni + "\n");


	//txtS.append("El descuento es: " + dscto + "\n");
	

	}
	
	
	//METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtMinTardz.setText("");
	txtNObser.setText("");
	txtS.setText("");
	
	txtMinTardz.requestFocus();
	}
}
