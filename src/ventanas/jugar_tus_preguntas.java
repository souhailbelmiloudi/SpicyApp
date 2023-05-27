package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class jugar_tus_preguntas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jugar_tus_preguntas frame = new jugar_tus_preguntas();
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
	public jugar_tus_preguntas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel boton_siguiente = new JLabel("Siguiente");
		boton_siguiente.setVisible(false);
		Conexion con= new Conexion();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel boton_empezar = new JLabel("Empezar");
		boton_empezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				con.conectar();
				String consulta = "";
				con.consulta(consulta, getName());
				boton_empezar.setVisible(false);
				boton_siguiente.setVisible(true);
			}
		});
		boton_empezar.setHorizontalAlignment(SwingConstants.CENTER);
		boton_empezar.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 22));
		boton_empezar.setBackground(UIManager.getColor("Button.background"));
		boton_empezar.setBounds(271, 377, 180, 55);
		contentPane.add(boton_empezar);
		
		JLabel tus_preguntas_Label = new JLabel("TUS PREGUNTAS");
		tus_preguntas_Label.setHorizontalAlignment(SwingConstants.CENTER);
		tus_preguntas_Label.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tus_preguntas_Label.setBounds(222, 11, 229, 52);
		contentPane.add(tus_preguntas_Label);
		
				
		boton_siguiente.setBackground(new Color(0, 255, 0));
		boton_siguiente.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 22));
		boton_siguiente.setHorizontalAlignment(SwingConstants.CENTER);
		boton_siguiente.setBounds(271, 377, 162, 55);
		contentPane.add(boton_siguiente);
		
		JTextPane text_preguntas = new JTextPane();
		text_preguntas.setEnabled(false);
		text_preguntas.setEditable(false);
		text_preguntas.setBounds(33, 106, 647, 183);
		contentPane.add(text_preguntas);
	}
}
