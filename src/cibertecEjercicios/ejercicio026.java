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
	public class ejercicio026 extends JFrame implements ActionListener {
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
	public ejercicio026() {
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
		
		do {
			txtS.append(ter + "\n");
			sumaResultado += ter;
			ter ++;
		}
		while(ter <= 100);
			txtS.append("Suma: " + sumaResultado);
	}
	}
	
	
