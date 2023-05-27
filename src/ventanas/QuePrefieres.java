package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import java.awt.Cursor;

public class QuePrefieres extends JPanel {

	
	private static final long serialVersionUID = -2542708776433544751L;

	Conexion conx = new Conexion();
	Connection con = conx.conectar();
	Participantes part = new Participantes();
	JTextPane op1;
	JTextPane op2;
	JProgressBar progressBarOP1;
	JProgressBar progressBarOP2 ;
	public QuePrefieres() {
		// Configuración del panel principal
		setBackground(new Color(204, 153, 0));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Que Prefieres");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(274, 11, 216, 58);
		add(lblNewLabel);
		// Barras de progreso para las opciones
		progressBarOP1 = new JProgressBar();
		progressBarOP1.setFont(new Font("Mistral", Font.BOLD | Font.ITALIC, 15));
		progressBarOP1.setForeground(new Color(0, 0, 0));
		progressBarOP1.setStringPainted(true);
		progressBarOP2 = new JProgressBar();
		progressBarOP2.setFont(new Font("Mistral", Font.BOLD | Font.ITALIC, 16));
		progressBarOP2.setForeground(new Color(0, 0, 0));
		progressBarOP2.setStringPainted(true);
		
		// Campo de texto para la opción 1
		op1 = new JTextPane();
		op1.setEditable(false);
		op1.setOpaque(false);
		op1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				op1.setForeground(new Color(255, 0, 0));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				op1.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				updateProgressBar();
				
			}
		});
		op1.setBackground(new Color(51, 255, 255));
		op1.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		op1.setBounds(45, 187, 271, 108);
		add(op1);

		op2= new JTextPane();
		op2.setOpaque(false);
		op2.setEditable(false);
		op2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				op2.setForeground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				op2.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				updateProgressBar();
				
			}
		});
		
		JLabel nombrelabel = new JLabel("");
		nombrelabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombrelabel.setForeground(new Color(255, 0, 0));
		nombrelabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		nombrelabel.setBounds(303, 90, 165, 64);
		add(nombrelabel);
		op2.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		op2.setBackground(new Color(51, 255, 255));
		op2.setBounds(439, 187, 271, 108);
		add(op2);
		progressBarOP1.setValue(0);
		progressBarOP1.setBounds(75, 305, 207, 98);
		add(progressBarOP1);

	
		//progressBarOP2.setForeground(new Color(51, 204, 0));
		progressBarOP2.setValue(0);
		progressBarOP2.setBounds(483, 304, 207, 98);
		add(progressBarOP2);

		JLabel lblNext = new JLabel(" Siguiente ");
		lblNext.setVisible(false);
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblNext.setForeground(new Color(204, 255, 255));
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNext.setForeground(new Color(51, 204, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				nombrelabel.setText(part.elegirPartisipante());
				progressBarOP2.setValue(0);
				progressBarOP1.setValue(0);
				updateQuestion();
				
			}		
		});
	
		
		lblNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNext.setOpaque(true);
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(new Color(204, 255, 255));
		lblNext.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 27));
		lblNext.setBackground(new Color(0, 0, 0));
		lblNext.setBounds(271, 436, 240, 58);
		add(lblNext);
		
		JLabel EMPEZAR = new JLabel("EMPEZAR");
		EMPEZAR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					nombrelabel.setText(part.elegirPartisipante());
					lblNext.setVisible(true);
					EMPEZAR.setVisible(false);
					updateQuestion();
				}catch(IllegalArgumentException e3){
					
					JOptionPane.showMessageDialog(null,"Debes añadir participantes");
				}
				

				
			}
		});
		EMPEZAR.setOpaque(true);
		EMPEZAR.setHorizontalAlignment(SwingConstants.CENTER);
		EMPEZAR.setForeground(new Color(204, 255, 255));
		EMPEZAR.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 27));
		EMPEZAR.setBackground(Color.BLACK);
		EMPEZAR.setBounds(227, 436, 263, 58);
		add(EMPEZAR);
		
		
		
		

	}
	
	// Método para actualizar las preguntas mostradas en los campos de texto	
	private void updateQuestion() {
		
	    // Realizar consulta a la base de datos para obtener preguntas aleatorias
		
		String opcion1= conx.consulta("SELECT PREGUNTA FROM (SELECT  PREGUNTA FROM QUE_PREFIERES ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM = 1","PREGUNTA");
		String opcion2= conx.consulta("SELECT PREGUNTA FROM (SELECT  PREGUNTA FROM QUE_PREFIERES ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM = 1","PREGUNTA");
		
	    // Configurar el formato HTML en los campos de texto para mostrar las preguntas correctamente
		op1.setContentType("text/html"); 
		op2.setContentType("text/html"); 
		HTMLEditorKit editorKit = new HTMLEditorKit();
		op1.setEditorKit(editorKit);
		op2.setEditorKit(editorKit);
		
		String c1 = "<html><body style='font-size: 15px; font-family: Verdana;'><center><i><b>" + opcion1 + "</center></i></b></body></html>";
		String c2 = "<html><body style='font-size: 15px; font-family: Verdana;'><center><i><b>" + opcion2 + "</center></i></b></body></html>";

		op1.setText(c1);
		op2.setText(c2);
	}
	
	
	// Método para actualizar la barra de progreso correspondiente a la opción seleccionada
	
		private void updateProgressBar() {
			
		    // Realizar consulta a la base de datos para obtener preguntas aleatorias

			String opcion1= conx.consulta("SELECT PREGUNTA FROM (SELECT  PREGUNTA FROM QUE_PREFIERES ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM = 1","PREGUNTA");
			String consulta = conx.consulta("SELECT PORSENTAGE FROM QUE_PREFIERES where PREGUNTA ='"+opcion1+"'","PORSENTAGE");
			int porsentage2 = Integer.parseInt(consulta);
			int  porsentage = (100-porsentage2);
		
         if (porsentage<porsentage2) {
				
				 progressBarOP1.setForeground(new Color(255, 0, 51));
				 progressBarOP2.setForeground(new Color(51, 204, 0));
			}else {
				 progressBarOP2.setForeground(new Color(255, 0, 51));
				 progressBarOP1.setForeground(new Color(51, 204, 0));
			}
			
			progressBarOP1.setValue(porsentage);
			progressBarOP2.setValue(porsentage2);
			
		}
	
}
