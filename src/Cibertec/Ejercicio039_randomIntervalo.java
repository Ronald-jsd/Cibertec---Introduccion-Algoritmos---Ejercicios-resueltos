	package Cibertec;
	import java.awt.EventQueue;
	import java.awt.Font;
	import javax.swing.JFrame;
	import javax.swing.JButton;
	import javax.swing.UIManager;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	
	
	
	 
	    
	public class Ejercicio039_randomIntervalo extends JFrame implements ActionListener {
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
		Ejercicio039_randomIntervalo frame = new Ejercicio039_randomIntervalo();
	frame.setVisible(true);
	}
	catch (Exception e) {
	e.printStackTrace();
	}
	}
	});
	}
	
	
	//Crea la GUI
	public Ejercicio039_randomIntervalo() {
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
		//Diseñe un programa que genere números aleatorios enteros del intervalo 200 a 600 hasta obtener
	//	un número impar mayor de 400 pero menor de 500. Imprima los números generados y determine:
		
			txtS.setText("");

			  int n = 200;
			    int SumaTotal=0;
			    int menortresc=0;
			    int intervTresaCuatr=0;
			    int intervCuatraQuin=0;
			    int mayQuin=0;
	
	
			while (!(n%2==1 && n >400 && n < 500))    {
			    
		        //NUMEROS RANDOMS DE 200 A 600
		    	n=((int)((600-200+1)*Math.random()+200));
		    	txtS.append(n + "\n");
		       	SumaTotal+=n;
		       	
		       	if (n <=300)
		       	    menortresc++;
		       	else if (n > 300 && n <=400)
		       	intervTresaCuatr++;
		       	else if(n>400 && n <= 500)
		       	intervCuatraQuin++;
		       	else if (n > 500)
		       	mayQuin++;     	
		    	}
			
  			
			txtS.append("Cantidad de la suma de los numeros " + SumaTotal  + "\n");
			txtS.append("Ctd<=300 " + menortresc + "\n");
			txtS.append("ctd >300 y <=400 " + intervTresaCuatr + "\n" );
			txtS.append("ctd de 400 a <=500=" + intervCuatraQuin +"\n" );
			txtS.append(" ctd >500 " + mayQuin + "\n" );
 
	}
	
	}	
