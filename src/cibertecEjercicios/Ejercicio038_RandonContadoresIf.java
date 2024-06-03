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
	public class Ejercicio038_RandonContadoresIf extends JFrame implements ActionListener {
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
		Ejercicio038_RandonContadoresIf frame = new Ejercicio038_RandonContadoresIf();
	frame.setVisible(true);
	}
	catch (Exception e) {
	e.printStackTrace();
	}
	}
	});
	}
	
	
	//Crea la GUI
	public Ejercicio038_RandonContadoresIf() {
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
		//Diseñe un programa que genere aleatoriamente las notas de un examen de 40 estudiantes de una
		//sección y determine la nota promedio, la cantidad de notas aprobatorias y la cantidad de notas
		//desaprobatorias.
		
		double ctdNotasAprobadas=0 ,ctdNotasDesaprobadas=0;
		double notapromedio;
		double contador=0;
		int i=1;
		
		txtS.setText("");
		while (i<=40) {
			double numerorandom = (int)(Math.random()*21);
			txtS.append(numerorandom+"\n");
			if (numerorandom<13) 
				ctdNotasDesaprobadas++;
			else 
				ctdNotasAprobadas++;
			
			contador+=numerorandom;
			
			i++;
		}
		
		notapromedio=contador/(ctdNotasDesaprobadas+ctdNotasAprobadas);
		
		txtS.append("Nota promedio= "+notapromedio+"\n");
		txtS.append("Cantidad de notas aprobadas= "+ctdNotasAprobadas+"\n");
		txtS.append("Cantidad de notas desaprobadas= "+ctdNotasDesaprobadas);

		//Imprima notas aleatorias de 40 estudiantes
		//imrpima notapromedio
		//imprima ctdNotasAprobadas
		//imprima ctdNotasDesaprobadas
		
		
		
		
	}
	}
	
	
	
