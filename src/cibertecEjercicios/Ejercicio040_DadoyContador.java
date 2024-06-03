	package cibertecEjercicios;
	import java.awt.EventQueue;
	import java.awt.Font;
	import javax.swing.JFrame;
	import javax.swing.JOptionPane;
	import javax.swing.JButton;
	import javax.swing.UIManager;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	
	public class Ejercicio040_DadoyContador extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btnProcesar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	
	int totalEjecuciones=0;
	
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
		Ejercicio040_DadoyContador frame = new Ejercicio040_DadoyContador();
	frame.setVisible(true);
	}
	catch (Exception e) {
	e.printStackTrace();
	}
	}
	});
	}
	
	//Crea la GUI
	public Ejercicio040_DadoyContador() {
	setTitle("Serie1");
	setBounds(100, 100, 450, 414);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	btnProcesar = new JButton("Procesar");
	btnProcesar.addActionListener(this);
	btnProcesar.setBounds(173, 9, 89, 23);
	getContentPane().add(btnProcesar);
	scpScroll = new JScrollPane();
	scpScroll.setBounds(10, 44, 414, 310);
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
	
	
	
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		//Diseñe un programa que lance tres dados aleatoriamente hasta obtener 6 en los tres dados.
		//	Imprima los puntajes obtenidos en cada dado y la cantidad de lanzamientos efectuados.

			txtS.setText(" ");
			totalEjecuciones++;
	        
	        int a=0, b=0, c=0;
	        int nLanzamientos=0;
	    
	        while (!(a == 6 && b==6 && c == 6)){
	         a=((int)((6-1+1)*Math.random()+1));
	         b=((int)((6-1+1)*Math.random()+1));
	         c=((int)((6-1+1)*Math.random()+1));
	         
	        txtS.append(a+ "\t" + b + "\t" + c  + "\n");

	        nLanzamientos++;
	        }
	
	        txtS.append("Cantidad de veces lanzadas =" + nLanzamientos + "\n");
	        txtS.append("El total de ejecuciones realizadas son = " + totalEjecuciones+"\n");
	
	        }
	     }
	     
	     
