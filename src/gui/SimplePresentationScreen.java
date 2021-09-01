package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel luLabel;
	private JTextField luTextField;
	private JTextField apellidoTextField;
	private JTextField nombreTextField;
	private JTextField emailTextField;
	private JTextField githubTextField;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		//Cambiamos el icono
		Image icon = new ImageIcon(getClass().getResource("/images/tdp.png")).getImage();
		setIconImage(icon);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 325));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		luLabel = new JLabel("LU");
		luLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		luLabel.setBounds(10, 11, 26, 20);
		tabInformation.add(luLabel);
		
		JLabel apellidoLabel = new JLabel("Apellido");
		apellidoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		apellidoLabel.setBounds(10, 42, 81, 20);
		tabInformation.add(apellidoLabel);
		
		JLabel nombreLabel = new JLabel("Nombre");
		nombreLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nombreLabel.setBounds(10, 73, 81, 20);
		tabInformation.add(nombreLabel);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailLabel.setBounds(10, 104, 81, 20);
		tabInformation.add(emailLabel);
		
		JLabel githubLabel = new JLabel("Github URL");
		githubLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		githubLabel.setBounds(10, 135, 81, 20);
		tabInformation.add(githubLabel);
		
		luTextField = new JTextField(Integer.toString(studentData.getId()));
		luTextField.setBounds(120, 11, 295, 20);
		tabInformation.add(luTextField);
		luTextField.setColumns(10);
		
		apellidoTextField = new JTextField(studentData.getLastName());
		apellidoTextField.setColumns(10);
		apellidoTextField.setBounds(120, 42, 295, 20);
		tabInformation.add(apellidoTextField);
		
		nombreTextField = new JTextField(studentData.getFirstName());
		nombreTextField.setColumns(10);
		nombreTextField.setBounds(120, 73, 295, 20);
		tabInformation.add(nombreTextField);
		
		emailTextField = new JTextField(studentData.getMail());
		emailTextField.setColumns(10);
		emailTextField.setBounds(120, 104, 295, 20);
		tabInformation.add(emailTextField);
		
		githubTextField = new JTextField(studentData.getGithubURL());
		githubTextField.setColumns(10);
		githubTextField.setBounds(120, 135, 295, 20);
		tabInformation.add(githubTextField);
		
		Calendar fecha = new GregorianCalendar();
		String anio = Integer.toString(fecha.get(Calendar.YEAR));
		String mes = Integer.toString(fecha.get(Calendar.MONTH));
		String dia = Integer.toString(fecha.get(Calendar.DATE));
		
		String hora = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
		String min = Integer.toString(fecha.get(Calendar.MINUTE));
		String seg = Integer.toString(fecha.get(Calendar.SECOND));
		
		String fechaCompleta = "Esta ventana fue generada el " + dia + "/" + mes + "/" + anio + " a las " + hora + ":" + min + ":" + seg;
		JLabel lblFecha = new JLabel(fechaCompleta);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(10, 158, 405, 14);
		tabInformation.add(lblFecha);
		contentPane.add(tabbedPane);
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(445, 5, 159, 211);
		ImageIcon img = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		imagen.setIcon(new ImageIcon(img.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_SMOOTH)));
		
		contentPane.add(imagen);

	}
}
