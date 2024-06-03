	package cibertecEjercicios;
	import java.awt.EventQueue;
	import java.awt.Font;
	import javax.swing.JFrame;
	import javax.swing.JButton;
	import javax.swing.UIManager;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	public class ejercicio0250 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btnProcesar;
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
		ejercicio026 frame = new ejercicio026();
	frame.setVisible(true);
	}
	catch (Exception e) {
	e.printStackTrace();
	}
	}
	});
	}
	
	
	//Crea la GUI
	public ejercicio0250() {
	setTitle("Serie1");
	setBounds(100, 100, 450, 214);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	btnProcesar = new JButton("Procesar");
	btnProcesar.addActionListener(this);
	btnProcesar.setBounds(173, 9, 89, 23);
	getContentPane().add(btnProcesar);
	scpScroll = new JScrollPane();
	scpScroll.setBounds(10, 44, 414, 120);
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
	}
	
	
	
	//Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		
		int ter=1, sumaResultado=0;
		
		/*while (ter<=100) {
			txtS.append(""+a+"\n");
			a++;
		}*/
		
		//mientras que termino sera menos o igual a 100 {
		//1 ES MENOR O IGUAL A 100?
		//IMPRIME EL TERMINO
		//Luego lo que voy imprimiendo voy sumando y acumulando
		
		while (ter<=100) {
			txtS.append(ter +"\n");//se imprime el 2
		
			sumaResultado += ter; //Primero sumo 1 , ahora sumo 2 
			ter++; // ahora aumenta al 3
			
			//Cuando ya llega a 100 al ser evaluado por la condicion, sale del while
	}
		
		//Al salir del while, tengo que imprimir la suma
		txtS.append("Suma: " + sumaResultado);
		
		
		/*int ter=1, sumaResultado=0;
		
		do {
			txtS.append(ter + "\n");
			sumaResultado += ter;
			ter ++;
		}
		while(ter <= 100);
			txtS.append("Suma: " + sumaResultado);
			*/
		
		
	}
	}
	
	
