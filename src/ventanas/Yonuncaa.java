package ventanas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JTextPane;

public class Yonuncaa extends JPanel {


	private static final long serialVersionUID = -3737799783602843993L;
	private Participantes p = new Participantes();
	Conexion conx = new Conexion();
	Connection con = conx.conectar();

	JTextPane resultadoPantalla2 = new JTextPane();
	public Yonuncaa() {
		
		
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 0, 818, 546);
		add(panel);
		panel.setLayout(null);
		
		
		JLabel lblYoNunca = new JLabel("Yo Nunca");
		lblYoNunca.setBounds(214, 5, 288, 76);
		lblYoNunca.setHorizontalAlignment(SwingConstants.CENTER);
		lblYoNunca.setFont(new Font("MV Boli", Font.BOLD, 37));
		panel.add(lblYoNunca);
		
	
		
		JLabel btn_Nunca = new JLabel("Nunca he hecho");
		btn_Nunca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.getNombres();
				String pregunta = conx.consulta("SELECT PREGUNTA FROM (SELECT  PREGUNTA FROM YO_NUNCA ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM = 1","PREGUNTA"); 
			
				
				resultadoPantalla2.setContentType("text/html"); 
				HTMLEditorKit editorKit = new HTMLEditorKit();
				resultadoPantalla2.setEditorKit(editorKit);
				String c = "<html><body style='font-size: 17px; font-family: Verdana;'><center><i><b>" +p.elegirPartisipante()+" " + pregunta + "</center></i></b></body></html>";
				resultadoPantalla2.setText(c);
			}
		});
		btn_Nunca.setVisible(false);
		btn_Nunca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Nunca.setOpaque(true);
		btn_Nunca.setBackground(new Color(255, 51, 0));
		btn_Nunca.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 22));
		btn_Nunca.setHorizontalAlignment(SwingConstants.CENTER);
		btn_Nunca.setBounds(30, 408, 222, 56);
		panel.add(btn_Nunca);
		
		JLabel btn_hecho = new JLabel("Lo he hecho");
		btn_hecho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.getNombres();
				String pregunta = conx.consulta("SELECT PREGUNTA FROM (SELECT  PREGUNTA FROM YO_NUNCA ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM = 1","PREGUNTA"); 
				resultadoPantalla2.setContentType("text/html"); 
				HTMLEditorKit editorKit = new HTMLEditorKit();
				resultadoPantalla2.setEditorKit(editorKit);
				String c = "<html><body style='font-size: 17px; font-family: Verdana;'><center><i><b>" +p.elegirPartisipante()+" " + pregunta + "</center></i></b></body></html>";
				resultadoPantalla2.setText(c);
			}
		});
		btn_hecho.setVisible(false);
		btn_hecho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hecho.setOpaque(true);
		btn_hecho.setBackground(new Color(204, 255, 0));
		btn_hecho.setHorizontalAlignment(SwingConstants.CENTER);
		btn_hecho.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 22));
		btn_hecho.setBounds(488, 408, 222, 56);
		panel.add(btn_hecho);
		
		JLabel btn_empezar = new JLabel("Empezar a jugar");
		btn_empezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					btn_hecho.setVisible(true);
					btn_Nunca.setVisible(true);
					btn_empezar.setVisible(false);
					p.getNombres();
					String pregunta = conx.consulta("SELECT PREGUNTA FROM (SELECT  PREGUNTA FROM YO_NUNCA ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM = 1","PREGUNTA"); 
					resultadoPantalla2.setContentType("text/html"); 
					HTMLEditorKit editorKit = new HTMLEditorKit();
					resultadoPantalla2.setEditorKit(editorKit);
					String c = "<html><body style='font-size: 17px; font-family: Verdana;'><center><i><b>" +p.elegirPartisipante()+" " + pregunta + "</center></i></b></body></html>";
					resultadoPantalla2.setText(c);
					
				}catch(IllegalArgumentException e3){
					
					JOptionPane.showMessageDialog(null,"Debes añadir participantes");
				}
			
			}
		});
		btn_empezar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_empezar.setOpaque(true);
		btn_empezar.setHorizontalAlignment(SwingConstants.CENTER);
		btn_empezar.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 22));
		btn_empezar.setBackground(new Color(204, 153, 0));
		btn_empezar.setBounds(250, 206, 228, 56);
		panel.add(btn_empezar);
		resultadoPantalla2.setOpaque(false);
		resultadoPantalla2.setEditable(false);
		
		resultadoPantalla2.setBounds(10, 177, 723, 128);
		panel.add(resultadoPantalla2);
		
		
		


	}
}
