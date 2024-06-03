	package Cibertec;
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
	import javax.swing.JComboBox;
	import javax.swing.DefaultComboBoxModel;
	
	
	public class Ejercicio020_Contador_cbo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// Declaración de variables
	private JLabel lblTipo;
	private JLabel lblCantidad;
	private JComboBox<String> cboTipo;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	//Declaración de variables globales para el a lgoritmo
	double imptot0, imptot1, imptot2, imptot3;
	int canlic0, canlic1, canlic2, canlic3;
	int canven0, canven1, canven2, canven3;
	
	
	//Lanza la aplicación
	public static void main(String[] args) {
	try {
	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	} catch (Throwable e) {
	e.printStackTrace();
	}
	EventQueue.invokeLater(new Runnable() {
	public void run() {
	try {
		Ejercicio020_Contador_cbo frame = new Ejercicio020_Contador_cbo();
	frame.setVisible(true);
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	});
	}
	//Crea la GUI
	public Ejercicio020_Contador_cbo() {
	setTitle("Licencias");
	setBounds(100, 100, 450, 449);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);
	lblTipo = new JLabel("Tipo");
	lblTipo.setBounds(10, 13, 80, 14);
	getContentPane().add(lblTipo);
	lblCantidad = new JLabel("Cantidad");
	lblCantidad.setBounds(10, 38, 80, 14);
	getContentPane().add(lblCantidad);
	cboTipo = new JComboBox<String>();
	cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] {
	"Cobre", "Bronze", "Silver", "Gold" }));
	cboTipo.setBounds(90, 10, 90, 20);
	getContentPane().add(cboTipo);
	txtCantidad = new JTextField();
	txtCantidad.setBounds(90, 35, 90, 20);
	getContentPane().add(txtCantidad);
	txtCantidad.setColumns(10);
	btnProcesar = new JButton("Procesar");
	btnProcesar.addActionListener(this);
	btnProcesar.setBounds(335, 9, 89, 23);
	getContentPane().add(btnProcesar);
	btnBorrar = new JButton("Borrar");
	btnBorrar.addActionListener(this);
	btnBorrar.setBounds(335, 34, 89, 23);
	getContentPane().add(btnBorrar);
	scpScroll = new JScrollPane();
	scpScroll.setBounds(10, 69, 414, 331);
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
	if (arg0.getSource() == btnBorrar) {
	actionPerformedBtnBorrar(arg0);
	}
	}
	//Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
	int tipodeLicencia, cantidad;
	double imppag;
	
	tipodeLicencia = getTipodeLicencia();
	cantidad = getCantidad();
	
	imppag = calcularImportePagar(tipodeLicencia, cantidad);
	
	efectuarIncrementos(tipodeLicencia, cantidad, imppag);
	
	mostrarResultados(imppag);
	}
	//Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
	txtCantidad.setText("");
	txtS.setText("");
	txtCantidad.requestFocus();
	}
	//Lee y retorna el tipo de licencia
	int getTipodeLicencia() {
	return cboTipo.getSelectedIndex();
	}
	//Lee y retorna la cantidad de licencias
	int getCantidad() {
	return Integer.parseInt(txtCantidad.getText());
	}
	//Calcula y retorna el importe a pagar
	//cantidad * el precio de cada tipo
	double calcularImportePagar(int tipLicencia, int ctd) {
	switch (tipLicencia) {
	case 0:
	return 510 * ctd;
	case 1:
	return 1500 * ctd;
	case 2:
	return 3100 * ctd;
	default:
	return 4500 * ctd;
	}
	
	}
	//Efectúa los incrementos necesarios
	void efectuarIncrementos(int tipLicencia, int ctd, double importepa) {
	switch (tipLicencia) {
	case 0:
	imptot0 += importepa;
	canlic0 += ctd;
	canven0++;
	break;
	case 1:
	imptot1 += importepa;
	canlic1 += ctd;
	canven1++;
	break;
	
	case 2:
	imptot2 += importepa;
	canlic2 += ctd;
	canven2++;
	break;
	default:
	imptot3 += importepa;
	canlic3 += ctd;
	canven3++;
	}
	}
	// Muestra el reporte solicitado
	void mostrarResultados(double importepa) {
	txtS.setText("");
	imprimir("Importe a pagar...........: " + importepa);
	imprimir("");
	imprimir("Importe total recaudado");
	imprimir("- Por licencias Cobre....: " + imptot0);
	imprimir("- Por licencias Bronze...: " + imptot1);
	imprimir("- Por licencias Silver...: " + imptot2);
	imprimir("- Por licencias Gold.....: " + imptot3);
	imprimir("");
	imprimir("Cantidad de licencias vendidas");
	imprimir("- Por licencias Cobre....: " + canlic0);
	imprimir("- Por licencias Bronze...: " + canlic1);
	imprimir("- Por licencias Silver...: " + canlic2);
	imprimir("- Por licencias Gold.....: " + canlic3);
	imprimir("");
	imprimir("Cantidad de ventas efectuadas");
	imprimir("- Por licencias Cobre....: " + canven0);
	imprimir("- Por licencias Bronze...: " + canven1);
	imprimir("- Por licencias Silver...: " + canven2);
	imprimir("- Por licencias Gold.....: " + canven3);
	}
	// Imprime una cadena con un salto de línea al final
	void imprimir(String cad) {
	txtS.append(cad + "\n");
	}
	}
	
