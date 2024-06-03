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
	public class Ejercicio014_puntaje_Met_voiGlobal extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; //Declaracion de variables - Se guarda serializado

	// Declaración de variables de la GUI

	private JLabel lblTardanza; 
	private JLabel lblObservaciones;
	
	private JTextField txtTardanza;
	private JTextField txtObservaciones;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JScrollPane scpScroll;
	private JTextArea txtS;
	
	//DECLARO VARIABLES GLOBALES
	int MinTar, NObse, PjPun, PjRend;
	double boni, PTotal;


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
				Ejercicio014_puntaje_Met_voiGlobal frame = new Ejercicio014_puntaje_Met_voiGlobal();
				frame.setVisible(true);
			} 
			catch (Exception e) {
			e.printStackTrace(); 
					}
				}
			});
		}
	
	//CREA LA GUI - CONSTRUCTOR
	public Ejercicio014_puntaje_Met_voiGlobal() {
		//ContentPane
		setTitle("EVALUACIÓN"); 
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		
		//texto a mostrar
		lblTardanza = new JLabel("Minutos de tardanza"); //completo a llenar los valores de las variables //texto de radio
		lblTardanza.setBounds(10, 13, 130, 14); //-> , y-,  ancho largo
		getContentPane().add(lblTardanza);  //Va agregar al panel
		
		lblObservaciones = new JLabel("Numero de Observaciones");
		lblObservaciones.setBounds(10, 38, 130, 14); 
		getContentPane().add(lblObservaciones);
		
		
		//inputs
		
		txtTardanza= new JTextField();
		txtTardanza.setBounds(150, 10, 90, 20);
		getContentPane().add(txtTardanza);
		txtTardanza.setColumns(10);
		
		
		txtObservaciones= new JTextField();
		txtObservaciones.setBounds(150, 35, 90, 20);
		getContentPane().add(txtObservaciones);
		txtObservaciones.setColumns(10);
	
		
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
	//AQUI VAN LOS NOMBRES DE LOS METODOS QUE SE EJECUTARAN AL PRECIONAR EL BOTON PROCESAR
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
	ingresarDatos(); //
	PuntajeporPuntualidad();
	PuntajeporRendimiento();
	calcularPuntajeTotal();
	calcularBonificacion();
	mostrarResultados();//
}

//METODO BORRAR		
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtTardanza.setText("");
	txtObservaciones.setText("");
	txtS.setText("");
	
	txtTardanza.requestFocus();
	}
	

	
	//PROCESO DE DATO
	//ENTRADA DE DATOS
		void ingresarDatos() {
		MinTar = Integer.parseInt(txtTardanza.getText());
		NObse = Integer.parseInt(txtObservaciones.getText()); //Esto viene del recuadro de JTextFiel y eso es texto entonces ingresara como texto por lo que te teno que convertirlo a double
		}
		
	//PROCESO DE DATOS
			void PuntajeporPuntualidad() {
					if (MinTar ==  0)
						PjPun = 10;
					else if (MinTar <3)
						PjPun = 8;
					else if (MinTar <6)
						PjPun = 6;
					else if (MinTar <10)
						PjPun = 4;
					else 
						PjPun = 0;
			}
			
			//CALCULO DESCUENTO
			void PuntajeporRendimiento() {
				if (NObse == 0)
					PjRend = 10;
				else if (NObse == 1)
					PjRend = 8;
				else if (NObse == 2)
					PjRend = 5;
				else if (NObse == 3)
					PjRend = 1;
				else 
					PjRend = 0;
			
			}
					
			
			//Calculo la nueva pension
			void calcularPuntajeTotal() {
				PTotal = PjPun + PjRend;
			}
			
			void calcularBonificacion() {
				if (PTotal < 11)
					boni = 2.5 * PTotal;
				else if (PTotal < 14)
					boni = 5 * PTotal;
				else if (PTotal < 17)
					boni = 7.5 * PTotal;
				else if (PTotal < 20)
					boni = 10 * PTotal;
				else 
					boni = 12.5 * PTotal;
			}
			
		//Muestra resultados
		void mostrarResultados() {
			txtS.setText("");
			imprimir("El puntaje por puntualidad es: " + PjPun);
			imprimir("El puntaje por Rendimiento es:  " + PjRend );
			imprimir("El puntaje Total es: : " + PTotal );
			imprimir("La bonificación es: S/." + boni );
		}
		
		//Imprime una linea de texto incluyendo un salto de linera
		void imprimir(String cad) {
			txtS.append(cad + "\n");
		}	
}
