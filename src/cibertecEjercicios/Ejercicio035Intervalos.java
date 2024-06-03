	package cibertecEjercicios;
	
	import java.awt.EventQueue;
	import java.awt.Font;
	import javax.swing.JFrame;
	import javax.swing.JButton;
	import javax.swing.UIManager;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	
	public class Ejercicio035Intervalos extends JFrame implements ActionListener {
		private static final long serialVersionUID = 1L;
	// Declaración de variables
		private JLabel lblInicio;
		private JLabel lblFin;
		private JTextField txtInicio;
		private JTextField txtFin;
		private JButton btnProcesar;
		private JButton btnBorrar;
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
						Ejercicio035Intervalos frame = new Ejercicio035Intervalos();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	// Crea la GUI
		public Ejercicio035Intervalos() {
			setTitle("Pares");
			setBounds(100, 100, 450, 239);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			lblInicio = new JLabel("Inicio");
			lblInicio.setBounds(10, 13, 80, 14);
			getContentPane().add(lblInicio);
			lblFin = new JLabel("Fin");
			lblFin.setBounds(10, 38, 80, 14);
			getContentPane().add(lblFin);
			txtInicio = new JTextField();
			txtInicio.setBounds(90, 10, 90, 20);
			getContentPane().add(txtInicio);
			txtInicio.setColumns(10);
			txtFin = new JTextField();
			txtFin.setBounds(90, 35, 90, 20);
			getContentPane().add(txtFin);
			txtFin.setColumns(10);
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(this);
			btnProcesar.setBounds(335, 9, 89, 23);
			getContentPane().add(btnProcesar);
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(this);
			btnBorrar.setBounds(335, 34, 89, 23);
			getContentPane().add(btnBorrar);
			scpScroll = new JScrollPane();
			scpScroll.setBounds(10, 69, 414, 120);
			getContentPane().add(scpScroll);
			txtS = new JTextArea();
			txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
			scpScroll.setViewportView(txtS);
		}
	
	// Direcciona eventos de tipo ActionEvent
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnProcesar) {
				actionPerformedBtnProcesar(arg0);
			}
			if (arg0.getSource() == btnBorrar) {
				actionPerformedBtnBorrar(arg0);
			}
		}
	
	//Procesa la pulsación del botón Procesar
		protected void actionPerformedBtnProcesar(ActionEvent arg0) {
			int num1=0, num2=0;
			num1 = Integer.parseInt(txtInicio.getText());
			num2 = Integer.parseInt(txtFin.getText());
		
			
			while (num1<num2) {
				if (num1%2==0) {
					txtS.append(num1 + "\n");
				}
				num1++;
			}
		}
	//Procesa la pulsación del botón Borrar
		protected void actionPerformedBtnBorrar(ActionEvent arg0) {
			txtInicio.setText("");
			txtFin.setText("");
			txtS.setText("");
			txtInicio.requestFocus();
		}
	}