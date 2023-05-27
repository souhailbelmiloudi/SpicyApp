package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AVISO extends JFrame {
	private static final long serialVersionUID = 878521141809771118L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AVISO frame = new AVISO();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public AVISO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(0, 0, 559, 417);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnNosGustaraInvitarte = new JTextPane();
		txtpnNosGustaraInvitarte.setEditable(false);
		txtpnNosGustaraInvitarte.setOpaque(false);
		txtpnNosGustaraInvitarte.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		txtpnNosGustaraInvitarte.setText("Nos gustaría invitarte a crear una cuenta con nosotros para que puedas disfrutar de todas las funciones y beneficios que ofrecemos. Con una cuenta, podrás acceder a todas las características exclusivas de nuestra plataforma y recibir actualizaciones y ofertas especiales.");
		txtpnNosGustaraInvitarte.setBounds(10, 61, 539, 93);
		panel.add(txtpnNosGustaraInvitarte);
		
		JTextPane txtpnLaCreacinDe = new JTextPane();
		txtpnLaCreacinDe.setText("La creación de una cuenta es rápida y fácil, y sólo te llevará unos minutos. Simplemente sigue el enlace de registro que te proporcionaremos y sigue las instrucciones en pantalla");
		txtpnLaCreacinDe.setOpaque(false);
		txtpnLaCreacinDe.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		txtpnLaCreacinDe.setEditable(false);
		txtpnLaCreacinDe.setBounds(10, 151, 539, 70);
		panel.add(txtpnLaCreacinDe);
		
		JTextPane txtpnEstamosEmocionadosDe = new JTextPane();
		txtpnEstamosEmocionadosDe.setText("Estamos emocionados de tenerte como parte de nuestra comunidad y esperamos que disfrutes de todo lo que tenemos para ofrecer. ¡Gracias por considerarnos como tu opción!");
		txtpnEstamosEmocionadosDe.setOpaque(false);
		txtpnEstamosEmocionadosDe.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		txtpnEstamosEmocionadosDe.setEditable(false);
		txtpnEstamosEmocionadosDe.setBounds(10, 228, 539, 70);
		panel.add(txtpnEstamosEmocionadosDe);
		
		JTextPane txtpnhola = new JTextPane();
		txtpnhola.setText("¡Hola!");
		txtpnhola.setOpaque(false);
		txtpnhola.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 17));
		txtpnhola.setEditable(false);
		txtpnhola.setBounds(240, 17, 64, 33);
		panel.add(txtpnhola);
		
		JLabel lblNewLabel = new JLabel("CREAR CUENTA ");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrartee regist = new Registrartee();
				regist.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBackground(new Color(51, 204, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(22, 336, 153, 51);
		panel.add(lblNewLabel);
		
		JLabel lblVolver = new JLabel("VOLVER");
		lblVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SpicyApp  app = new SpicyApp();
				app.setVisible(true);
				dispose();
			}
		});
		lblVolver.setOpaque(true);
		lblVolver.setHorizontalAlignment(SwingConstants.CENTER);
		lblVolver.setForeground(Color.BLACK);
		lblVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVolver.setBackground(new Color(255, 51, 51));
		lblVolver.setBounds(330, 336, 166, 51);
		panel.add(lblVolver);
	}
}
