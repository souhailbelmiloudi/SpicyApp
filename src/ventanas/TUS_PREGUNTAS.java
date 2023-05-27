package ventanas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TUS_PREGUNTAS extends JPanel {
	
	
	private static final long serialVersionUID = -310098997241187392L;
	private JTextField anadir_Field;
	private JTextField borra_Field;
	private JTextField busca_Field;

	
	public TUS_PREGUNTAS() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 744, 510);
		add(panel);
		panel.setLayout(null);
		
		anadir_Field = new JTextField();
		anadir_Field.setBounds(10, 138, 655, 45);
		panel.add(anadir_Field);
		anadir_Field.setColumns(10);
		
		JLabel add_pre = new JLabel("+");
		add_pre.setHorizontalAlignment(SwingConstants.CENTER);
		add_pre.setForeground(Color.BLACK);
		add_pre.setFont(new Font("Lucida Fax", Font.BOLD, 51));
		add_pre.setBounds(675, 138, 46, 41);
		panel.add(add_pre);
		
		JLabel tus_preguntas_Label = new JLabel("TUS PREGUNTAS");
		tus_preguntas_Label.setHorizontalAlignment(SwingConstants.CENTER);
		tus_preguntas_Label.setFont(new Font("MV Boli", Font.BOLD, 37));
		tus_preguntas_Label.setBounds(194, 22, 382, 52);
		panel.add(tus_preguntas_Label);
		
		JLabel anadir_Label = new JLabel("Añade aquí tus nuevas preguntas");
		anadir_Label.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 18));
		anadir_Label.setBounds(10, 86, 347, 41);
		panel.add(anadir_Label);
		
		JLabel borra_Label = new JLabel("Borra aquí tus preguntas (ID)");
		borra_Label.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 18));
		borra_Label.setBounds(10, 211, 298, 41);
		panel.add(borra_Label);
		
		borra_Field = new JTextField();
		borra_Field.setColumns(10);
		borra_Field.setBounds(10, 262, 655, 45);
		panel.add(borra_Field);
		
		JLabel borrar_pre = new JLabel("-\r\n");
		borrar_pre.setHorizontalAlignment(SwingConstants.CENTER);
		borrar_pre.setForeground(Color.BLACK);
		borrar_pre.setFont(new Font("Lucida Fax", Font.BOLD, 64));
		borrar_pre.setBounds(675, 262, 46, 41);
		panel.add(borrar_pre);
		
		JLabel busca_Label = new JLabel("Busca aquí el ID de la pregunta");
		busca_Label.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 18));
		busca_Label.setBounds(10, 334, 333, 41);
		panel.add(busca_Label);
		
		busca_Field = new JTextField();
		busca_Field.setColumns(10);
		busca_Field.setBounds(10, 386, 655, 45);
		panel.add(busca_Field);
		
		JLabel buscar_pre = new JLabel("¿?");
		buscar_pre.setHorizontalAlignment(SwingConstants.CENTER);
		buscar_pre.setForeground(Color.BLACK);
		buscar_pre.setFont(new Font("Lucida Fax", Font.BOLD, 25));
		buscar_pre.setBounds(675, 386, 46, 41);
		panel.add(buscar_pre);

	}
}
