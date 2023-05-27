package ventanas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Principal extends JPanel {
	
	private static final long serialVersionUID = 937196562338549646L;
	private JTextField entraPartisipantes;
	Participantes p = new Participantes();
	String id = Sign_in.nombre;
	
	
	public Principal() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 786, 562);
		add(panel);
		panel.setLayout(null);
		
		// Texto y descripción del modo de juego "Yo Nunca"

		JTextPane yOnuncaDiscr = new JTextPane();
		yOnuncaDiscr.setText("Este modo de juego consiste en que los jugadores deben hacer una declaración sobre algo que nunca han hecho antes. Si algún otro jugador ha hecho lo que se ha declarado, este debe tomar un trago.\r\nEs un juego muy popular en fiestas y reuniones sociales, y suele ser bastante divertido.");
		yOnuncaDiscr.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		yOnuncaDiscr.setEditable(false);
		yOnuncaDiscr.setBackground(new Color(255, 160, 122));
		yOnuncaDiscr.setBounds(10, 119, 717, 65);
		panel.add(yOnuncaDiscr);
		// Texto y descripción del modo de juego "Verdad o Reto"


		JTextPane vOrDiscr = new JTextPane();
		vOrDiscr.setText("Este es un clásico juego de fiesta en el que los jugadores deben elegir entre responder\r\n una pregunta honestamente o realizar un desafío. Si un jugador se niega a hacer una de las dos opciones,debe tomar un trago. Es un juego muy versátil que se puede adaptar a diferentes situaciones y niveles de dificultad.");
		vOrDiscr.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		vOrDiscr.setEditable(false);
		vOrDiscr.setBackground(new Color(255, 160, 122));
		vOrDiscr.setBounds(10, 278, 717, 65);
		panel.add(vOrDiscr);
		// Texto y descripción del modo de juego "Tus Preguntas"

		JTextPane picaroDiscr = new JTextPane();
		picaroDiscr.setText("Este modo de juego trata de que el propio usuario puede crear sus propias preguntas para que así darle puedas darle tu\r\n"
				+ "propia esencia y para que se adapte más a ti. En él puedes poner el nivel de preguntas que desee y jugar con estas \r\n"
				+ "hasta que quieras, !tira de imaginación y ponle ganas con tus amigos");
		picaroDiscr.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		picaroDiscr.setEditable(false);
		picaroDiscr.setBackground(new Color(255, 160, 122));
		picaroDiscr.setBounds(10, 361, 717, 57);
		panel.add(picaroDiscr);
		// Texto y descripción del modo de juego "¿Qué Prefieres?"
		JTextPane queorefieresDiscr = new JTextPane();
		queorefieresDiscr.setText("En este modo de juego, los jugadores deben elegir entre dos opciones presentadas, ambas\r\ncon consecuencias divertidas o inesperadas. Si un jugador no puede elegir, debe tomar un trago. Este juego puede ser muy entretenido y es perfecto para grupos grandes.");
		queorefieresDiscr.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		queorefieresDiscr.setEditable(false);
		queorefieresDiscr.setBackground(new Color(255, 160, 122));
		queorefieresDiscr.setBounds(10, 202, 717, 62);
		panel.add(queorefieresDiscr);
		
		JLabel LabelYO_NU_1 = new JLabel("YO NUNCA");
		LabelYO_NU_1.setHorizontalAlignment(SwingConstants.LEFT);
		LabelYO_NU_1.setForeground(Color.BLACK);
		LabelYO_NU_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		LabelYO_NU_1.setBounds(10, 104, 87, 19);
		panel.add(LabelYO_NU_1);
		
		JLabel LabelYO_NU_1_1 = new JLabel("¿QUE PREFIERES?");
		LabelYO_NU_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		LabelYO_NU_1_1.setForeground(Color.BLACK);
		LabelYO_NU_1_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		LabelYO_NU_1_1.setBounds(10, 183, 138, 19);
		panel.add(LabelYO_NU_1_1);
		
		JLabel LabelYO_NU_1_1_1 = new JLabel("VERDAD O RETO");
		LabelYO_NU_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		LabelYO_NU_1_1_1.setForeground(Color.BLACK);
		LabelYO_NU_1_1_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		LabelYO_NU_1_1_1.setBounds(10, 262, 138, 19);
		panel.add(LabelYO_NU_1_1_1);
		
		JLabel LabelYO_NU_1_1_2 = new JLabel("TUS PREGUNTAS");
		LabelYO_NU_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		LabelYO_NU_1_1_2.setForeground(Color.BLACK);
		LabelYO_NU_1_1_2.setFont(new Font("Segoe Print", Font.BOLD, 14));
		LabelYO_NU_1_1_2.setBounds(10, 343, 158, 19);
		panel.add(LabelYO_NU_1_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Añadir Participantes");
		lblNewLabel_1.setForeground(new Color(51, 0, 0));
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setBounds(10, 428, 239, 29);
		panel.add(lblNewLabel_1);
		
		entraPartisipantes = new JTextField();
		entraPartisipantes.setColumns(10);
		entraPartisipantes.setBounds(242, 428, 375, 29);
		panel.add(entraPartisipantes);
		
		JLabel addParti = new JLabel("+");
		addParti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = entraPartisipantes.getText();
				p.addParticipantes(nombre);
				entraPartisipantes.setText("");
			}
		});
		addParti.setHorizontalAlignment(SwingConstants.CENTER);
		addParti.setForeground(Color.BLACK);
		addParti.setFont(new Font("Lucida Fax", Font.BOLD, 51));
		addParti.setBounds(614, 420, 45, 37);
		panel.add(addParti);
		
		JLabel titloPrin2 ;
		if (id == null) {
		    titloPrin2 = new JLabel("Hola, nos alegra verte en nuestro juego ");
			titloPrin2.setHorizontalAlignment(SwingConstants.CENTER);
			titloPrin2.setFont(new Font("Forte", Font.ITALIC, 31));
			titloPrin2.setBounds(10, 0, 717, 49);
			panel.add(titloPrin2);
			
		}else {
			titloPrin2 = new JLabel("Hola "+ id +", nos alegra verte en nuestro juego ");
			titloPrin2.setHorizontalAlignment(SwingConstants.CENTER);
			titloPrin2.setFont(new Font("Forte", Font.ITALIC, 31));
			titloPrin2.setBounds(10, 0, 717, 49);
			panel.add(titloPrin2);}
		
		JLabel titloPrin1 = new JLabel("esperamos que lo pases genial");
		titloPrin1.setHorizontalAlignment(SwingConstants.CENTER);
		titloPrin1.setFont(new Font("Forte", Font.ITALIC, 31));
		titloPrin1.setBounds(10, 57, 717, 36);
		panel.add(titloPrin1);
		
		
	}
}
