	package Cibertec;
	
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
	
	public class Ejercicio018_MetRet_AreCirc extends JFrame implements ActionListener {
		private static final long serialVersionUID = 1L;
	// Declaración de variables
		private JLabel lblRadio;

		
		private JTextField txtRadio;
		
		private JButton btnProcesar;
		private JButton btnBorrar;
		
		private JScrollPane scpScroll;
		private JTextArea txtS;
	
	// Lanza la aplicación
		public static void main(String[] args) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Throwable e) {
				e.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Ejercicio018_MetRet_AreCirc frame = new Ejercicio018_MetRet_AreCirc();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	// Crea la GUI
		public Ejercicio018_MetRet_AreCirc() {
			setTitle("Rectangulo");
			setBounds(100, 100, 450, 239);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			lblRadio = new JLabel("Radio");
			lblRadio.setBounds(10, 13, 80, 14);
			getContentPane().add(lblRadio);
			
			
			txtRadio = new JTextField();
			txtRadio.setBounds(90, 10, 90, 20);
			getContentPane().add(txtRadio);
			txtRadio.setColumns(10);
						
			
			btnProcesar = new JButton("Procesar");
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
	
	// Direcciona eventos de tipo ActionEvent
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnProcesar) {
				actionPerformedBtnProcesar(arg0);
			}
			if (arg0.getSource() == btnBorrar) {
				actionPerformedBtnBorrar(arg0);
			}
		}
	
	// Procesa la pulsación del botón Procesar
		protected void actionPerformedBtnProcesar(ActionEvent arg0) {
			
	// Declaración de variables locales
			double r, areaCirc, PerimCirc;
			
	// Llama a getBase
	// getBase envía como retorno la base del rectángulo
	// El valor retornado es almacenado en b
			r = getRadio(); //get - obtner , base 
			//variable local llamado r , almacena lo que yo almaceno en getRadio
	
			
	// Llama a calcularArea y le envía los valores de b y h
	// El valor de b es recibido por el parámetro bas de calcularArea
	// El valor de h es recibido por el parámetro alt de calcularArea
	// calcularArea retorna el área del rectángulo
	// Dado que el área es de tipo double, el tipo de retorno es double
	// El valor retornado es almacenado en arearec
			areaCirc = calcularArea(r); //arearec llama al metodo calcularArea, y ese metodo si tiene parametro y esta abajo
			
			PerimCirc = calcularPerimetro(r);
			
			
			
	// Llama a mostrarArea y le envía el valor de arearec
	// El valor de arearec es recibido por el parámetro are
	// mostrarArea retorna sin ningún resultado
	// Un método que no retorna un resultado es de tipo void
			mostrarArea(areaCirc);
			
			mostrarPerimetro(PerimCirc);

		}
		
	//-------------------------------------
		
	// Procesa la pulsación del botón Borrar
		protected void actionPerformedBtnBorrar(ActionEvent arg0) {
			txtRadio.setText("");
			txtS.setText("");
			txtRadio.requestFocus();
		}
	
	//-------------------------------------------	
		//Creo un metodo
	//Lee y retorna la base
	//Dado que la base es de tipo double, el tipo de retorno es double
	//Declara una variable local xb para guardar la base temporalmente
	//Almacena la base en xb
	//Retorna la base almacenada en xb
		double getRadio() { //al yo llamar a getBase, este valor ira con todo lo de abajo y se almacenara arriba en getbase
			//getRadio almacena el valor de entrada del input
			double xr;
			xr = Double.parseDouble(txtRadio.getText());
			return xr;
		}
	
		
	//Calcula y retorna el área
	//El parámetro bas recibirá el valor de la base
	//El parámetro alt recibirá el valor de la altura
	//Los valores son enviados desde actionPerformedBtnProcesar
	//Declara una variable local xa para guardar el área temporalmente
	//Almacena el área en xa
	//Retorna el área almacenada en xa
		double calcularArea(double rad) { //aqui esta y tengo que poner los tipos de datos - pueden llamarse diferente tambien
			double xa;
			xa = rad * rad * Math.PI;
			return xa;
		}
	
		double calcularPerimetro(double rad) {
			double xp;
			xp = rad * Math.PI *2;
			return xp;
		}
		
	//Muestra el área
	//El parámetro are recibirá el valor del área
	//El valor del área es enviado desde actionPerformedBtnProcesar
	//El método no retorna ningún resultado; por lo que, es de tipo void
		void mostrarArea(double are) {
			txtS.setText("Area : " + are + "\n");
		}
		
		//metodo muestra el perimetro
		void mostrarPerimetro(double peri) {
			txtS.append("El perimetro es:" + peri);
		
		}
		
	}