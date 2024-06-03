package cibertecEjercicios; 

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
	import java.text.DecimalFormat;
	
	// Variables GUI
	class Ejercicio033_bucle extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; 
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
			public void run() { try { Ejercicio035PAR_IMPAR frame = new Ejercicio035PAR_IMPAR();
			frame.setVisible(true); //
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//GUI 
	public Ejercicio033_bucle() {
		//ContentPane
		setTitle("Empresa"); 
		setBounds(150, 300, 450, 450); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null); // panel null
		
		
	
		
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
		scpScroll.setBounds(10, 69, 414, 380);
		getContentPane().add(scpScroll); 
		//
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
		txtS.setEditable(false);
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
	
		DecimalFormat df = new DecimalFormat("0.00");
		
		double x=0, y=0.00;
		
		while(x<=2.75) {	
			y = (Math.pow(x, 3)+3*x+1)/(x*x+2);
			txtS.append(x + "\t" + df.format(y)  + "\n");
			x+=0.25;
		    }
	}
	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {

	txtS.setText("");
	
	}
}
