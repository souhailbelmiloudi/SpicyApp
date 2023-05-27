package ventanas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLEditorKit;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.Cursor;
import javax.swing.JTextPane;

public class VerdadOreto extends JPanel {


	private static final long serialVersionUID = -6112397697977691571L;
	Conexion conx = new Conexion();
	Connection con = conx.conectar();
	Participantes part = new Participantes();
	JLabel nombrelabel = new JLabel("");
	JTextPane test = new JTextPane();
	public VerdadOreto() {
		setBackground(new Color(153, 204, 255));
		setLayout(null);

		JLabel titelVor = new JLabel("VERDDoRETO");
		titelVor.setForeground(new Color(51, 51, 51));
		titelVor.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 27));
		titelVor.setHorizontalAlignment(SwingConstants.CENTER);
		titelVor.setBounds(202, 10, 310, 68);

		add(titelVor);

		JLabel lblVerdd = new JLabel("VERDAD");
		lblVerdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVerdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblVerdd.setBackground(new Color(204, 51, 51));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblVerdd.setBackground(new Color(0, 153, 51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                // Obtener una pregunta de tipo "V" de forma aleatoria desde la base de datos

				String pregunta = conx.consulta("SELECT PREGUNTA FROM (SELECT  PREGUNTA FROM VERDAD_O_RETO  WHERE TIPO = 'V'  ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM = 1  ","PREGUNTA");
				test.setContentType("text/html"); 
				HTMLEditorKit editorKit = new HTMLEditorKit();
				test.setEditorKit(editorKit);
				String c = "<html><body style='font-size: 17px; font-family: Verdana;'><center><i><b>" + pregunta + "</center></i></b></body></html>";

				test.setText(c);
				
			}
		});
		lblVerdd.setBackground(new Color(0, 153, 51));
		lblVerdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerdd.setForeground(new Color(204, 255, 255));
		lblVerdd.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 27));
		lblVerdd.setBounds(10, 126, 310, 68);
		lblVerdd.setOpaque(true);
		add(lblVerdd);

		JLabel lblreto = new JLabel("RETO");
		lblreto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblreto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblreto.setBackground(new Color(0, 153, 51));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblreto.setBackground(new Color(204, 51, 51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                // Obtener una pregunta de tipo "R" de forma aleatoria desde la base de datos

				String pregunta = conx.consulta("SELECT PREGUNTA FROM (SELECT  PREGUNTA FROM VERDAD_O_RETO  WHERE TIPO = 'R'  ORDER BY DBMS_RANDOM.VALUE()) WHERE ROWNUM = 1  ","PREGUNTA");
				test.setContentType("text/html"); 
				HTMLEditorKit editorKit = new HTMLEditorKit();
				test.setEditorKit(editorKit);
				String c = "<html><body style='font-size: 17px; font-family: Verdana;'><center><i><b>" + pregunta + "</center></i></b></body></html>";

				test.setText(c);
			}
		});
		lblreto.setBackground(new Color(204, 51, 51));
		lblreto.setHorizontalAlignment(SwingConstants.CENTER);
		lblreto.setForeground(new Color(204, 255, 255));
		lblreto.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 27));
		lblreto.setBounds(379, 126, 310, 68);
		lblreto.setOpaque(true);
		add(lblreto);
		
		
		nombrelabel.setHorizontalAlignment(SwingConstants.CENTER);
		nombrelabel.setForeground(Color.RED);
		nombrelabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		nombrelabel.setBounds(264, 230, 165, 64);
		add(nombrelabel);
		
		JLabel EMPEZAR = new JLabel("Elegir jugador");
		EMPEZAR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
			
					nombrelabel.setText(part.elegirPartisipante());
					
		
					
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
		EMPEZAR.setBounds(239, 398, 263, 58);
		add(EMPEZAR);
		test.setOpaque(false);
		test.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 17));
		test.setEditable(false);
		
		
		
		test.setBounds(10, 320, 717, 68);
		add(test);

	}
}
