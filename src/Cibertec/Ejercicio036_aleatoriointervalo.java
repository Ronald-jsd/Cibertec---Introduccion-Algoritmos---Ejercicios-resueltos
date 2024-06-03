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
	public class Ejercicio036_aleatoriointervalo extends JFrame implements ActionListener {
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
		Ejercicio036_aleatoriointervalo frame = new Ejercicio036_aleatoriointervalo();
	frame.setVisible(true);
	}
	catch (Exception e) {
	e.printStackTrace();
	}
	}
	});
	}
	
	
	//Crea la GUI
	public Ejercicio036_aleatoriointervalo() {
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
//Diseñe un programa que genere números aleatorios enteros del intervalo 100 a 999 hasta obtener
//un número par -> mayor o igual a 500. Imprima lo números generados y determine:
		int n = 0;
		int sumatotal=0;
		int ctdPares=0,ctdImpares=0;
		int sumaPares=0, sumaImpares=0;
		
		txtS.setText("");
		
		//Genera los números aleatorios
		//mientras n no sea par y no sea >=500 , 
		//El bucle continuara ejecutandose mientras n sea impar o menor que 500
		while (!(n % 2 == 0 && n >= 500)){
		// Genera un número aleatorio de 100 a 999
		n = (int) ((999 - 100 + 1) * Math.random() + 100);

		// Imprime el número generado hasta que se cumpla la condicion
		//de que el numero sea par y mayor o igual a 500
		txtS.append(n + "\n");
		sumatotal+=n;	
		if (n%2==0) {
			ctdPares++;
			sumaPares+=n;
		}
		else {
			ctdImpares++;
			sumaImpares+=n;
		}
		} 			
		
		
		//sumaPares
		//sumaImpares
		
		txtS.append("---------------------------------------------------"+"\n");
		txtS.append("Suma de los numeros generados es: " + sumatotal+"\n");
		txtS.append("---------------------------------------------------"+"\n");
		txtS.append("Cantidad de numeros pares es: " + ctdPares+"\n");
		txtS.append("Cantidad de numeros impares es: " + ctdImpares+"\n");
		txtS.append("---------------------------------------------------"+"\n");
		txtS.append("Suma de los numeros pares es: " + sumaPares+"\n");
		txtS.append("Suma de los de numeros impares es: " + sumaImpares+"\n");

		
		
		
		//IMPRIMA
		//La suma de los números generados
		//• La cantidad de números pares generados
		//• La cantidad de números impares generados
		//• La suma de los números pares generados
		//• La suma de los números impares generados
		
		

	}
	}
	
	
	
	
