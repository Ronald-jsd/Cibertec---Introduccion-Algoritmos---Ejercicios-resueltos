//1.Estamos declarando el paquete
//EJERCICIO 5 , IMPORTAR DEL 9
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

	
	class ejercicio030 extends JFrame implements ActionListener{

	
		// Declaración de variables, que se introduciran 
	private static final long serialVersionUID = 1L; 


	private JLabel lblNota; 
	
	private JTextField txtNota;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JScrollPane scpScroll;
	private JTextArea txtS;

	double sumaTotal=0 ;
	int totalNotas=0;

	//DECLARO METODO MAIN EJECUTA LA APLICACION
	public static void main(String[] args) { 
		
		try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
			}
		
		EventQueue.invokeLater(new Runnable() {
			
			//Dentro del metodo main hay un metodo run , para definir la logica de la ejecucuion
			public void run() { try { ejercicio030 frame = new ejercicio030();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//CREA LA GUI - CONSTRUCTOR
	public ejercicio030() {
		//ContentPane
		setTitle("Tienda promoción"); //Establesco titulo de ventana, le doy valor
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		//JLabel
		lblNota = new JLabel("Nota"); //completo a llenar los valores de las variables //texto de radio
		lblNota.setBounds(10, 13, 120, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblNota);  //Va agregar al panel
		
		
	
		
		//JTextField
		txtNota = new JTextField(); //nuevo objeto de la clase JTextField, lo que esta entre parentesis va depender de lo que ingresa el usuario
		txtNota.setBounds(120, 10, 90, 20);
		getContentPane().add(txtNota); //agrego
		txtNota.setColumns(10);  //Establezco como columna de medida de 10
		
	
		
		
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
	
	double nota=0 , promedio=0;
	
	
	

	//ENTRADA DE DATOS
	
	nota = Double.parseDouble(txtNota.getText());

	
	//PROCESO DE DATOS
	
	sumaTotal+=nota; //ACUMULA LAS NOTA EN SUMATOTAL  15 + 14 = 29
	totalNotas++; //VA IR CONTANDO LA CANTIDAD DE VECES QUE SE ESTA LLENANDO 1 + 1 = 2
	
	promedio = sumaTotal/totalNotas;
	// LO ACUMULADO SOBRE LA CANTIDAD DE VECES

	//SALIDA DE DATOS
	txtS.setText("El promedio de sus notas es: " + promedio + "\n");
	
	
	


	//txtS.append("El descuento es: " + dscto + "\n");
	

	}
	
	
	//METODO BORRAR
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtNota.setText("");
	sumaTotal=0;
	totalNotas=0;
	txtS.setText("");
	
	txtNota.requestFocus();
	}
}
