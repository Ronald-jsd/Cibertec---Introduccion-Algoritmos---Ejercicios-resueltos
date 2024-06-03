	package cibertecEjercicios;
	
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
	
	
	
	public class Ejercicio016_MetRetorno extends JFrame implements ActionListener {
		private static final long serialVersionUID = 1L;
	
	// Declaración de variables
		private JLabel lblBase;
		private JLabel lblAltura;
		private JTextField txtBase;
		private JTextField txtAltura;
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
						Ejercicio016_MetRetorno frame = new Ejercicio016_MetRetorno();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	//Crea la GUI
		public Ejercicio016_MetRetorno() {
			setTitle("Rectangulo");
			setBounds(100, 100, 450, 239);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			lblBase = new JLabel("Base");
			lblBase.setBounds(10, 13, 80, 14);
			getContentPane().add(lblBase);
			lblAltura = new JLabel("Altura");
			lblAltura.setBounds(10, 38, 80, 14);
			getContentPane().add(lblAltura);
			
			
			txtBase = new JTextField();
			txtBase.setBounds(90, 10, 90, 20);
			getContentPane().add(txtBase);
			
			txtBase.setColumns(10);
			txtAltura = new JTextField();
			txtAltura.setBounds(90, 35, 90, 20);
			getContentPane().add(txtAltura);
			txtAltura.setColumns(10);
			
			
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
	
	//Direcciona eventos de tipo ActionEvent
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnProcesar) {
				actionPerformedBtnProcesar(arg0);
			}
			if (arg0.getSource() == btnBorrar) {
				actionPerformedBtnBorrar(arg0);
			}
		}
	
	//Procesa la pulsación del botón Procesar
		protected void actionPerformedBtnProcesar(ActionEvent arg0) {
	
	//Declaración de variables locales
			double b, h, arearec;
	
	//Llama a getBase
	//getBase envía como retorno(devuelve) la base del rectángulo
	//El valor retornado es almacenado en b
			b = getBase(); //get base- obtener base
	
	//Llama a getAltura
	//getAltura envía como retorno la altura del rectángulo
	//El valor retornado es almacenado en h
			h = getAltura();
	
	//Llama a calcularArea y le envía los valores de b y h
	//El valor de b es recibido por el parámetro bas de calcularArea
	//El valor de h es recibido por el parámetro alt de calcularArea
	//calcularArea retorna el área del rectángulo
	//El valor retornado es almacenado en arearec
			arearec = calcularArea(b, h); //es libre a crear aqii el nombre del metodo calculararea por oro pero abajo se declara el metodo con el misoonombre
	
	//Llama a mostrarArea y le envía el valor de arearec
	//El valor de arearec es recibido por el parámetro are
	//mostrarArea retorna sin ningún resultado
	//Un método que no retorna un resultado es de tipo void
			mostrarArea(arearec);
		}
	
		//---------------------------------------------
	//Procesa la pulsación del botón Borrar
		protected void actionPerformedBtnBorrar(ActionEvent arg0) {
			txtBase.setText("");
			txtAltura.setText("");
			txtS.setText("");
			txtBase.requestFocus();
		}
	//-----------------------------------------------------------
	//Lee y retorna la base que fue inresado en el input (jtextfield)
	//Dado que la base es de tipo double, el tipo de retorno es double
		double getBase() {
			return Double.parseDouble(txtBase.getText());
			
			//el valor de getBase es  lo que entrara en el imput y este sera retornado (return ) al getbase 
			//Entoces mas arriba getbase recibira este valor y sera perteneciente a la variable b
		}
	
	//Lee y retorna la altura
	//Dado que la altura es de tipo double, el tipo de retorno es double
		double getAltura() {
			return Double.parseDouble(txtAltura.getText());
		}
	
	//Calcula y retorna el área
		//los valores que estaban en calculararea que era b y h  , aqui se les da otro nombre variable cualquiera
	//El parámetro bas recibirá el valor de la base
	//El parámetro alt recibirá el valor de la altura
	//Dado que el área es de tipo double, el tipo de retorno es double
	//Los valores son enviados desde actionPerformedBtnProcesar
		double calcularArea(double bas, double alt) {
			return bas * alt;
		}
	
	//Muestra el área
	//El parámetro are recibirá el valor del área
	//El valor del área es enviado desde actionPerformedBtnProcesar
	//El método no retorna ningún resultado; por lo que, es de tipo void
		void mostrarArea(double are) {
			txtS.setText("Area : " + are);
		}
	
	}
	
	//	//El segundo método almacena temporalmente el valor de la base en una variable local (xb) antes de retornarlo. 
	//El primer método retorna el valor directamente.