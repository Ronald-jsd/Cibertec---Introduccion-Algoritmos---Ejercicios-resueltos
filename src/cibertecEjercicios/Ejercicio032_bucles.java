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
	
	// Variables GUI
	class Ejercicio032_bucles extends JFrame implements ActionListener{
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
			public void run() { try { Ejercicio032_bucles frame = new Ejercicio032_bucles();
			frame.setVisible(true); //
		} catch (Exception e) {
			e.printStackTrace(); }
		}
		}
		);
		}
	
	//GUI 
	public Ejercicio032_bucles() {
		//ContentPane
		setTitle("Empresa"); 
		setBounds(150, 300, 450, 239); 
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
	
		int num=6;
		int i=1, res=1, res2=0, res3=0, res4=20;
		while(i<=num)
		{
		res *=i;
		txtS.append("multiplicacion acumulada: " + res + "\n");
		res2 +=i;
		txtS.append("suma acumulada es:   " + res2+"\n");
		res3 -=i;
		txtS.append("resta acumulada es:   " + res3+"\n");
		res4 /=i;
		txtS.append("division acumulada es:   " + res4+"\n");


		txtS.append(" sucesion es:   "+ i+"\n");
		i++;
		}
		txtS.append("----Resultados------"+"\n");
		txtS.append("ultimo valor de la iteracion:  " + i+"\n");
		txtS.append("lo acumulado  de la multiplicacion:  "    + res+"\n");
		  txtS.append("lo acumulado de la suma:  " + res2+"\n");
		  txtS.append("lo acumulado  de la resta:  "    + res3+"\n");
		txtS.append("lo acumulado  de la division:  "    + res4+"\n");

		    }
		
	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {

	txtS.setText("");
	
	}
}
