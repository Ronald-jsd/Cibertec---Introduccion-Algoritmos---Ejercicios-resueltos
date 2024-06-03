package Cibertec; 

	import java.awt.EventQueue;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.UIManager;
	import java.awt.Font;
	import javax.swing.JFrame;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	
	// Variables GUI
	class ejercicio031 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; 
	private JLabel lblPresupuesto; 
	
	private JTextField txtPresuspuesto;
	
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JScrollPane scpScroll;
	private JTextArea txtS;
	
	double presupuesto, total;
	double IyDesarrollo, Marketing, ITecnologica,RRHH, Capacitacion, GAdministrativos;

	// MAIN 
	public static void main(String[] args) { 
		try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //
		} catch (Throwable e) {
			e.printStackTrace();
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() { try { ejercicio031 frame = new ejercicio031();
			frame.setVisible(true); //
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//GUI 
	public ejercicio031() {
		//ContentPane
		setTitle("Empresa"); 
		setBounds(150, 300, 450, 239); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null); // panel null
		
		lblPresupuesto = new JLabel("Presupuesto"); 
		lblPresupuesto.setBounds(10, 13, 120, 14); 
		getContentPane().add(lblPresupuesto);  //get
		
		
			
		txtPresuspuesto = new JTextField(); 
		txtPresuspuesto.setBounds(120, 10, 90, 20);
		getContentPane().add(txtPresuspuesto); 
		txtPresuspuesto.setColumns(10);  //column med 10
		
	
		
		btnProcesar = new JButton("Procesar"); //create
		btnProcesar.addActionListener(this); //action
		btnProcesar.setBounds(335, 9, 89, 23);  
		getContentPane().add(btnProcesar); //get
		
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
	
	// ActionEvent 
	public void actionPerformed(ActionEvent arg0) {
	if (arg0.getSource() == btnProcesar) { //tap 
		actionPerformedBtnProcesar(arg0); //-> executed
	} if (arg0.getSource() == btnBorrar) { 
		actionPerformedBtnBorrar(arg0);
		}
	}

	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
	
		//double presupuesto;
		//double IyDesarrollo, Marketing, ITecnologica,RRHH, Capacitacion, GAdministrativos;
		EntradadeDatos();
		CalculodeGasto();
		SalidadeResultados();
	}
		
	
	
		void EntradadeDatos() {
			presupuesto = Double.parseDouble(txtPresuspuesto.getText());
		}
		
		void CalculodeGasto() {
			IyDesarrollo = 0.3*presupuesto;
			Marketing = 0.15*presupuesto;
			ITecnologica = 0.2*presupuesto;
			RRHH = 0.10*presupuesto;
			Capacitacion = 0.15*presupuesto;
			GAdministrativos = 0.1*presupuesto;
			
			total = IyDesarrollo+Marketing+ITecnologica+RRHH+Capacitacion+GAdministrativos;
		}
		
		
		void SalidadeResultados() {
			txtS.setText("");
			imprimir("El gasto del area de Investigación y Desarrollo es: " + IyDesarrollo);
			imprimir("El gasto del area de Marketing  es: " + Marketing);
			imprimir("El gasto del area de Infraestructura Tecnológica  es: " + ITecnologica);
			imprimir("El gasto del area de Recursos Humanos  es: " + RRHH);
			imprimir("El gasto del area de Capacitación  es: " + Capacitacion);
			imprimir("El gasto del area de Gastos Administrativos es: " + GAdministrativos);
			
			imprimir("El gasto total es: " + total);
		}
		
			
		void imprimir(String cad){
		txtS.append(cad + "\n");		
		}

		
	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtPresuspuesto.setText("");
	txtPresuspuesto.setText("");
	txtS.setText("");
	
	txtPresuspuesto.requestFocus();
	}
}
