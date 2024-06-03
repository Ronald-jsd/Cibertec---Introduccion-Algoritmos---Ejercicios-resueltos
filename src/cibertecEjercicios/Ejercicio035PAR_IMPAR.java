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
	class Ejercicio035PAR_IMPAR extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L; 
	private JButton btnProcesar;
	private JButton btnBorrar;
	
	private JLabel lblNumero;
	private JTextField	txtNumero;
	
	
	private JScrollPane scpScroll;
	private JTextArea txtS;


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
	public Ejercicio035PAR_IMPAR() {
		//ContentPane
		setTitle(""); 
		setBounds(150, 300, 450, 450); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null); // panel null
		
		
		lblNumero = new JLabel("Numero"); 
		lblNumero.setBounds(10, 13, 120, 14); 
		getContentPane().add(lblNumero);  //get
		
		
			
		txtNumero = new JTextField(); 
		txtNumero.setBounds(120, 10, 90, 20);
		getContentPane().add(txtNumero); 
		txtNumero.setColumns(10);  //column med 10
		
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
	
	       int i=0;
	       
	       i=Integer.parseInt(txtNumero.getText());
	        
       		txtS.setText("");
       		txtS.append("Numeros pares"+"\n");

	        while (i>0){
	            if (i%2==0){
	               txtS.append( "par = " + i + "\n");
	            }
	            if (i%2!=0) {
		               txtS.append( "impar = " + i + "\n");
	            }
	        i--;
	        }
	       
	     
	        
	            
	            
	        }
		
	
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {

	txtS.setText("");
	
	}
}
