package tusPreguntas;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLEditorKit;

import ventanas.Conexion;
import ventanas.Participantes;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JTextPane;

public class Tus_preguntas extends JFrame {


	private static final long serialVersionUID = -3737799783602843993L;
	
	private Participantes p = new Participantes();
	Conexion conx = new Conexion();
	Connection con = conx.conectar();
	JTextPane resultadoPantalla2 = new JTextPane();
	public Tus_preguntas() {
		setVisible(true);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(0, 0, 818, 570);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblYoNunca = new JLabel("Tus Preguntas");
		lblYoNunca.setBounds(214, 5, 288, 76);
		lblYoNunca.setHorizontalAlignment(SwingConstants.CENTER);
		lblYoNunca.setFont(new Font("MV Boli", Font.BOLD, 37));
		panel.add(lblYoNunca);
		
		JLabel btn_hecho = new JLabel("Empezar a jugar");
		btn_hecho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.getNombres();
				String pregunta = conx.consulta("SELECT PREGUNTA FROM (select PREGUNTA from preguntas where preguntas.id_pregunta >159 ORDER BY DBMS_RANDOM.VALUE() )  where ROWNUM =1","PREGUNTA"); 
				resultadoPantalla2.setContentType("text/html"); 
				HTMLEditorKit editorKit = new HTMLEditorKit();
				resultadoPantalla2.setEditorKit(editorKit);
				String c = "<html><body style='font-size: 17px; font-family: Verdana;'><center><i><b>" +p.elegirPartisipante()+" " + pregunta + "</center></i></b></body></html>";
				resultadoPantalla2.setText(c);
			}
		});
		btn_hecho.setVisible(true);
		btn_hecho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_hecho.setOpaque(true);
		btn_hecho.setBackground(new Color(204, 255, 0));
		btn_hecho.setHorizontalAlignment(SwingConstants.CENTER);
		btn_hecho.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 22));
		btn_hecho.setBounds(302, 475, 222, 56);
		panel.add(btn_hecho);
		resultadoPantalla2.setOpaque(false);
		resultadoPantalla2.setEditable(false);
		
		resultadoPantalla2.setBounds(10, 177, 723, 128);
		panel.add(resultadoPantalla2);
		
		
		


	}
}
