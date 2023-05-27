package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu_tus_preguntas extends JPanel {

	/**
	 * Create the panel.
	 */
	public menu_tus_preguntas() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 20, 147));
		panel.setBounds(0, 0, 781, 528);
		add(panel);
		panel.setLayout(null);
		
		JLabel tus_preguntas_Label = new JLabel("TUS PREGUNTAS");
		tus_preguntas_Label.setHorizontalAlignment(SwingConstants.CENTER);
		tus_preguntas_Label.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tus_preguntas_Label.setBounds(258, 11, 229, 52);
		panel.add(tus_preguntas_Label);
		
		JLabel boton_crear = new JLabel("Crear tus preguntas");
		boton_crear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		boton_crear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		boton_crear.setBounds(51, 187, 246, 121);
		panel.add(boton_crear);
		
		JLabel boton_jugar = new JLabel("Jugar con tus preguntas");
		boton_jugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		boton_jugar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		boton_jugar.setBounds(411, 187, 246, 121);
		panel.add(boton_jugar);

	}
}
