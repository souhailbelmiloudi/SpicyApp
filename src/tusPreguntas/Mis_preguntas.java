package tusPreguntas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLEditorKit;

import ventanas.Conexion;
import ventanas.Participantes;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.awt.Cursor;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Mis_preguntas extends JFrame {


	private static final long serialVersionUID = 3179762559746245791L;
	private JPanel contentPane;
	int xMouse, yMouse;
	private Participantes p = new Participantes();
	Conexion conx = new Conexion();
	Connection con = conx.conectar();
	JTextPane resultadoPantalla2 = new JTextPane();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mis_preguntas frame = new Mis_preguntas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mis_preguntas() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 127, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				yMouse = e.getY();
				xMouse = e.getX();
			}
		});
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		panel.setBounds(0, 0, 822, 38);
		panel.setBackground(new Color(240, 255, 240));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(383, 5, 67, 28);
		panel.add(lblNewLabel);
		contentPane.add(panel);
		
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
		btn_hecho.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
		btn_hecho.setOpaque(true);
		btn_hecho.setBackground(new Color(210, 105, 30));
		btn_hecho.setHorizontalAlignment(SwingConstants.CENTER);
		btn_hecho.setBounds(306, 444, 222, 56);
		contentPane.add(btn_hecho);
		
		
		resultadoPantalla2.setOpaque(false);
		resultadoPantalla2.setEditable(false);
		resultadoPantalla2.setBounds(56, 173, 723, 128);
		contentPane.add(resultadoPantalla2);
		
		JLabel lblMisPreguntas = new JLabel("Mis Preguntas");
		lblMisPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMisPreguntas.setFont(new Font("Georgia", Font.BOLD, 20));
		lblMisPreguntas.setBounds(10, 56, 802, 69);
		contentPane.add(lblMisPreguntas);
		
		
		
		
	}
}
