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
	import javax.swing.JComboBox;
	import javax.swing.DefaultComboBoxModel;


	
//3. Para hacer la GUI tenemos que extender a la clase JFrame
public class Ejercicio015_Met_voiGlobal_CBOifelse extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; //Declaracion de variables - Se guarda serializado

	// Declaración de variables de la GUI

	private JLabel lblCategoria; 
	private JLabel lblPromedio;
	
	private JComboBox<String> cboCategoria;
	private JTextField txtPromedio;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JScrollPane scpScroll;
	private JTextArea txtS;
	
	//DECLARO VARIABLES GLOBALES
	int Categ;
	double Promed, pensionA = 0, dscto, NewPension;


	//DECLARO METODO MAIN//Lanza la app
	public static void main(String[] args) { //El metodo main es el metodo que ejecuta la aplicacion
		
		try 
		{ UIManager.setLookAndFeel(
			"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} 
		catch (Throwable e) {
			e.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
			public void run() { 
			try { 
				Ejercicio015_Met_voiGlobal_CBOifelse frame = new Ejercicio015_Met_voiGlobal_CBOifelse();
				frame.setVisible(true);
			} 
			catch (Exception e) {
			e.printStackTrace(); 
					}
				}
			});
		}
	
	//CREA LA GUI - CONSTRUCTOR
	public Ejercicio015_Met_voiGlobal_CBOifelse() {
		//ContentPane
		setTitle("Transporte"); 
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		
		//texto a mostrar
		lblCategoria = new JLabel("Categoria"); //completo a llenar los valores de las variables //texto de radio
		lblCategoria.setBounds(10, 13, 80, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblCategoria);  //Va agregar al panel
		
		lblPromedio = new JLabel("Promedio");
		lblPromedio.setBounds(10, 38, 80, 14); 
		getContentPane().add(lblPromedio);
		
		
		//nombre de los campos vacios
		
		//combobox
		cboCategoria = new JComboBox<String>(); //Nueva instancia de la clase JCOMBOBOX
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] { //setModel, de Model se relaciona a las base de datos y estoy definiendo por deafault un arreglo de String
		"A", "B", "C", "D"}));   
		cboCategoria.setBounds(90,10,90,20);
		getContentPane().add(cboCategoria); 
		
		
		txtPromedio= new JTextField();
		txtPromedio.setBounds(90, 35, 90, 20);
		getContentPane().add(txtPromedio);
		txtPromedio.setColumns(4);
	
		
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

	} 
	if (arg0.getSource() == btnBorrar) { //Si eh presionado btnBorrar
		actionPerformedBtnBorrar(arg0);//Si eh presionado btnBorrar
		}
	}


//PROCESA LA PULSACION DE PROOCESAR
	
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {			
			
	ingresarDatos();
	calcularPensionActual();
	calcularDescuento();
	calcularNuevaPension();
	mostrarResultados();
}

//METODO BORRAR		
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtPromedio.setText("");
	cboCategoria.setSelectedIndex(0);
	txtS.setText("");
	
	txtPromedio.requestFocus();
	}
	

	
	//PROCESO DE DATO
	//ENTRADA DE DATOS
		void ingresarDatos() {
		Categ = cboCategoria.getSelectedIndex();
		Promed = Double.parseDouble(txtPromedio.getText()); //Esto viene del recuadro de JTextFiel y eso es texto entonces ingresara como texto por lo que te teno que convertirlo a double
		}
		
	//PROCESO DE DATOS
			void calcularPensionActual() {
		//Dar valor por turno del combobox
			switch(Categ) {
			case 0:
				pensionA = 550;
				break;
			case 1:
				pensionA = 500;
				break;
			case 2:
				pensionA = 460;
				break;
			case 3:
				pensionA = 400;
				break;
			}
			}
			
			//CALCULO DESCUENTO
			void calcularDescuento() {
		
			if (Promed <= 13.99)
				dscto = 0;
			else if(Promed <= 15.99)
				dscto = 0.10*pensionA;
			else if(Promed <= 17.99)
				dscto = 0.12*pensionA;
			else 
				dscto = 0.15*pensionA;
			}
					
			
			//Calculo la nueva pension
			void calcularNuevaPension() {
			NewPension = pensionA - dscto;
			}
			
		//Muestra resultados
			//imprimir es un nombre  de metodo a eleccion 
		void mostrarResultados() {
		txtS.setText("");
		imprimir("La pension actual es: " + pensionA);
		imprimir("El descuento es: " + dscto );
		imprimir("La Nueva pension es: " + NewPension );
		}
		
		
		//Imprime una linea de texto incluyendo un salto de liera
		//cad es un nombre de metodo a eleccion
	void imprimir(String cad)  {
			txtS.append(cad + "\n");
		}	
}
