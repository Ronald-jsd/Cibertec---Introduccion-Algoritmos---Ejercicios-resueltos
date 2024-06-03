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
	import javax.swing.JComboBox;
	import javax.swing.DefaultComboBoxModel;


	
//3. Para hacer la GUI tenemos que extender a la clase JFrame
class ejercicio023 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; //Declaracion de variables - Se guarda serializado

	// Declaración de variables, que se introduciran 

	private JLabel lblProducto; 
	private JLabel lblctdproducto;
	
	private JComboBox<String> cboProducto;
	private JTextField txtctdproducto;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JScrollPane scpScroll;
	private JTextArea txtS;


	//DECLARO METODO MAIN//Lanza la app
	public static void main(String[] args) { //El metodo main es el metodo que ejecuta la aplicacion
		
		try { UIManager.setLookAndFeel(
			"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Throwable e) {
			e.printStackTrace();
			}
		
			EventQueue.invokeLater(new Runnable() {
			//Dentro del metodo main hay un metodo run
			//se usa para definir la loica de la ejecucionde un hio en JAVA
			public void run() { 
			try { 
				ejercicio023 frame = new ejercicio023();
			frame.setVisible(true);
			} catch (Exception e) {
			e.printStackTrace(); }
			}
			}
			);
			}
	
	//CREA LA GUI - CONSTRUCTOR
	public ejercicio023() {
		//ContentPane
		setTitle("TIENDA"); 
		setBounds(150, 300, 450, 239); //medidas del panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para cerrar la ventana
		getContentPane().setLayout(null); //trae el panel limpio
		
		
		//texto a mostrar
		lblProducto = new JLabel("PRODUCTO"); //completo a llenar los valores de las variables //texto de radio
		lblProducto.setBounds(10, 13, 80, 14); //medidas donde aparecen -,  ancho largo
		getContentPane().add(lblProducto);  //Va agregar al panel
		
		lblctdproducto = new JLabel("Cantidad de Productos");
		lblctdproducto.setBounds(10, 38, 80, 14); 
		getContentPane().add(lblctdproducto);
		
		
		//nombre de los campos vacios
		
		//combobox
		cboProducto = new JComboBox<String>(); //Nueva instancia de la clase JCOMBOBOX
		cboProducto.setModel(new DefaultComboBoxModel<String>(new String[] { //setModel, de Model se relaciona a las base de datos y estoy definiendo por deafault un arreglo de String
		"P0", "P1", "P2"}));   
		cboProducto.setBounds(90,10,90,20);
		getContentPane().add(cboProducto); 
		
		
		txtctdproducto = new JTextField();
		txtctdproducto.setBounds(90, 35, 90, 20);
		getContentPane().add(txtctdproducto);
		txtctdproducto.setColumns(4);
		
		
		
		
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


//DECLARO VARIABLLES 
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
	
		
	
	//DECLARO VARIABLES
	int producto, ctdproductos, obsequio = 0;
	double precio = 0, IPagar;
	
	
	//ENTRADA DE DATOS
	
	producto = cboProducto.getSelectedIndex();
	ctdproductos = Integer.parseInt(txtctdproducto.getText()); //Esto viene del recuadro de JTextFiel y eso es texto entonces ingresara como texto por lo que te teno que convertirlo a double
	
	//PROCESO DE DATOS
		
	switch (producto) {
	case 0:
		precio = 15;
		break;
		
	case 1:
		precio = 17.5;
		break;
		
	case 2:
		precio = 20;
		break;
		
	}
		//IMPORTE A PAGAR
		
		IPagar = precio * ctdproductos;
		
		//OBSQUIO
		
		if (ctdproductos>12)
			obsequio = 2*ctdproductos;
		else if (ctdproductos <=12)
			obsequio = 1*ctdproductos;
		
		
	
	
	
	//SALIDA DE RESULTADOS
	txtS.setText("El Importe a pagar es: " + IPagar + "\n");
	txtS.append("El obsequio de gomitas es: " + obsequio + "\n");
	

	}
	
	//METODO BORRAR		
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtctdproducto.setText("");
	cboProducto.setSelectedIndex(0);
	txtS.setText("");
	
	txtctdproducto.requestFocus();
	//requestFocus - volver a comenzar el txtRadio en la gui
	}
}
