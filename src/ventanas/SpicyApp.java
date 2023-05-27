package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.awt.SystemColor;
import java.awt.Cursor;

public class SpicyApp extends JFrame{

	private static final long serialVersionUID = 1L;
	 //variables
	JPanel PantallaModos = new JPanel();
	Yonuncaa yo = new  Yonuncaa();
	QuePrefieres queP= new QuePrefieres();
	VerdadOreto VoR=new VerdadOreto();
	Principal principal= new Principal();
	Sign_in app = new Sign_in();
	TUS_PREGUNTAS ges =new TUS_PREGUNTAS();
	AVISO avi = new AVISO();
	
	private JTextField entraPartisipantes;
	String id = Sign_in.nombre;
	Participantes p = new Participantes(); //  la clase participantes:
	//bd
	Conexion conx = new Conexion();
	Connection con = conx.conectar();
	// metodo para cambiar pantallas
   public void mostrarpantalla(JPanel p) {
	   
		 p.setSize(737,504 );
		 p.setLocation(0,0);
		 
		 PantallaModos.removeAll();
		 PantallaModos.add(p,BorderLayout.CENTER);
		 PantallaModos.revalidate();
		 PantallaModos.repaint();
   }
    
    
    
	
	
	public SpicyApp() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(0, 0, 0));
		menu.setBounds(249, 0, 737, 60);
		getContentPane().add(menu);
		menu.setLayout(null);
		
		JLabel LabelYO_NU = new JLabel("YO NUNCA");
		LabelYO_NU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mostrarpantalla(yo);
			
				 
			}
		});
		LabelYO_NU.setBounds(0, 5, 130, 55);
		LabelYO_NU.setHorizontalAlignment(SwingConstants.CENTER);
		LabelYO_NU.setForeground(new Color(255, 99, 71));
		LabelYO_NU.setFont(new Font("Segoe Script", Font.BOLD, 16));
		menu.add(LabelYO_NU);
		
		JLabel lblquePrefieres = new JLabel("¿QUE PREFIERES?");
		lblquePrefieres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				mostrarpantalla(queP);
			}
		});
		lblquePrefieres.setBounds(155, 5, 171, 55);
		lblquePrefieres.setHorizontalAlignment(SwingConstants.CENTER);
		lblquePrefieres.setForeground(new Color(255, 99, 71));
		lblquePrefieres.setFont(new Font("Segoe Script", Font.BOLD, 16));
		menu.add(lblquePrefieres);
		
		JLabel lblVerdadOReto = new JLabel("VERDAD O RETO");
		lblVerdadOReto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				mostrarpantalla(VoR);
			}
		});
		lblVerdadOReto.setBounds(347, 5, 177, 55);
		lblVerdadOReto.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerdadOReto.setForeground(new Color(255, 99, 71));
		lblVerdadOReto.setFont(new Font("Segoe Script", Font.BOLD, 16));
		menu.add(lblVerdadOReto);
		
		JLabel lblPicaro = new JLabel("TUS PREGUNTAS");
		lblPicaro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (id == null) {
					avi.setVisible(true);
					dispose();
				}else {
					mostrarpantalla(ges);
				}
				
			}
		});
		lblPicaro.setBounds(521, 5, 206, 55);
		lblPicaro.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicaro.setForeground(new Color(255, 99, 71));
		lblPicaro.setFont(new Font("Segoe Script", Font.BOLD, 16));
		menu.add(lblPicaro);
		
		JPanel imgylogo = new JPanel();
		imgylogo.setBackground(new Color(255, 160, 122));
		imgylogo.setBounds(0, 0, 251, 563);
		getContentPane().add(imgylogo);
		imgylogo.setLayout(null);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(SpicyApp.class.getResource("/imagen/new (625 × 781 px) (251 × 504 px).png")));
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagen.setBounds(0, 58, 251, 452);
		imgylogo.add(imagen);
		
		JLabel lblNewLabel = new JLabel("Spicy");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				mostrarpantalla(principal);
				
				
				
			}
		});
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(45, 0, 112, 36);
		imgylogo.add(lblNewLabel);
		
		JLabel lblApp = new JLabel("App");
		lblApp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblApp.setForeground(new Color(255, 0, 0));
		lblApp.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 28));
		lblApp.setBounds(129, 2, 112, 36);
		imgylogo.add(lblApp);
		
		JLabel C = new JLabel("Cerrar sesión");
		C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = null;
				app.setVisible(true);
				conx.desconectar();
				dispose();
				
				
			}
		});
		C.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		C.setOpaque(true);
		C.setBackground(SystemColor.desktop);
		C.setHorizontalAlignment(SwingConstants.CENTER);
		C.setForeground(Color.RED);
		C.setFont(new Font("Goudy Old Style", Font.BOLD | Font.ITALIC, 26));
		C.setBounds(0, 509, 251, 54);
		imgylogo.add(C);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Música");
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(0, 31, 87, 35);
		imgylogo.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setBackground(new Color(255, 160, 122));
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			

			    private AdvancedPlayer player;
			    private Thread playerThread;

			    // Reproduce la música de fondo.
				 
			    private void playBackgroundMusic() {
			        try {
			        	// Ruta del archivo de música
			            File musicFile = new File("../SpicyAPPpro/src/imagen/Musica_proyecto.mp3");
						// Crear un flujo de entrada para el archivo de música
			            FileInputStream fis = new FileInputStream(musicFile);
			            BufferedInputStream bis = new BufferedInputStream(fis);
						// Crear una instancia de AdvancedPlayer para reproducir el archivo de música
			            player = new AdvancedPlayer(bis);
						// Crear un hilo para reproducir la música en segundo plano
			            playerThread = new Thread(() -> {
			                try {
			                    player.play();// Iniciar la reproducción de la música
			                } catch (JavaLayerException e) {
			                    e.printStackTrace();
			                }
			            });
			         // Iniciar el hilo de reproducción de la música
			            playerThread.start();
			        } catch (FileNotFoundException e) {
			            e.printStackTrace();
			        } catch (JavaLayerException e) {
			            e.printStackTrace();
			        }
			    }
			    //Detiene la reproducción de la música de fondo.
			    public void stopBackgroundMusic() {
			        if (player != null) {
			            player.close();
						playerThread.interrupt(); // Interrumpe el hilo de reproducción de música
			        }
			    }
			    
			    public void mouseClicked(MouseEvent e) {
					
					if (chckbxNewCheckBox.isSelected()) {
						playBackgroundMusic();
		            } else {
		            	stopBackgroundMusic();
		            }
				}
				
					        
		});	
		
		
		PantallaModos.setBackground(new Color(255, 160, 122));
		PantallaModos.setBounds(249, 59, 737, 504);
		getContentPane().add(PantallaModos);
		PantallaModos.setLayout(null);
		
		JLabel titloPrin1 = new JLabel("esperamos que lo pases genial");
		titloPrin1.setHorizontalAlignment(SwingConstants.CENTER);
		titloPrin1.setFont(new Font("Forte", Font.ITALIC, 31));
		titloPrin1.setBounds(10, 47, 717, 36);
		PantallaModos.add(titloPrin1);
		
		JLabel titloPrin2;
		
		if (id == null) {
		    titloPrin2 = new JLabel("Hola, nos alegra verte en nuestro juego ");
			titloPrin2.setHorizontalAlignment(SwingConstants.CENTER);
			titloPrin2.setFont(new Font("Forte", Font.ITALIC, 31));
			titloPrin2.setBounds(10, 0, 717, 49);
			PantallaModos.add(titloPrin2);
			
		}else {
			titloPrin2 = new JLabel("Hola, "+ id +", nos alegra verte en nuestro juego ");
			titloPrin2.setHorizontalAlignment(SwingConstants.CENTER);
			titloPrin2.setFont(new Font("Forte", Font.ITALIC, 31));
			titloPrin2.setBounds(10, 0, 717, 49);
		PantallaModos.add(titloPrin2);}
		
		JTextPane yOnuncaDiscr = new JTextPane();
		yOnuncaDiscr.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		yOnuncaDiscr.setText("Este modo de juego consiste en que los jugadores deben hacer una declaración sobre algo "
				+ "que nunca han hecho antes. Si algún otro jugador ha hecho lo que se ha declarado, este debe tomar"
				+ " un trago.\r\nEs un juego muy popular en fiestas y reuniones sociales, y suele ser bastante divertido.");
		yOnuncaDiscr.setBackground(new Color(255, 160, 122));
		yOnuncaDiscr.setBounds(10, 110, 689, 49);
		PantallaModos.add(yOnuncaDiscr);
		yOnuncaDiscr.setEditable(false);
		
		JTextPane vOrDiscr = new JTextPane();
		vOrDiscr.setText("Este es un clásico juego de fiesta en el que los jugadores deben elegir entre responder\r\n"
				+ " una pregunta honestamente o realizar un desafío. Si un jugador se niega a hacer una de las dos opciones,debe "
				+ "tomar un trago. Es un juego muy versátil que se puede adaptar a diferentes situaciones y niveles de dificultad.");
		vOrDiscr.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		vOrDiscr.setEditable(false);
		vOrDiscr.setBackground(new Color(255, 160, 122));
		vOrDiscr.setBounds(10, 251, 689, 49);
		PantallaModos.add(vOrDiscr);
		
		JTextPane picaroDiscr = new JTextPane();
		picaroDiscr.setText("Este modo de juego trata de que el propio usuario puede crear sus propias preguntas para que así darle puedas darle tu\r\n"
				+ "propia esencia y para que se adapte más a ti. En él puedes poner el nivel de preguntas que desee y jugar con estas \r\n"
				+ "hasta que quieras, !tira de imaginación y ponle ganas con tus amigos");
		picaroDiscr.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		picaroDiscr.setEditable(false);
		picaroDiscr.setBackground(new Color(255, 160, 122));
		picaroDiscr.setBounds(10, 326, 699, 76);
		PantallaModos.add(picaroDiscr);
		
		JTextPane queorefieresDiscr = new JTextPane();
		queorefieresDiscr.setText("En este modo de juego, los jugadores deben elegir entre dos opciones presentadas, ambas\r\ncon consecuencias"
				+ " divertidas o inesperadas. Si un jugador no puede elegir, debe tomar un trago. Este juego puede ser muy entretenido y"
				+ " es perfecto para grupos grandes.");
		queorefieresDiscr.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 13));
		queorefieresDiscr.setEditable(false);
		queorefieresDiscr.setBackground(new Color(255, 160, 122));
		queorefieresDiscr.setBounds(10, 181, 699, 49);
		PantallaModos.add(queorefieresDiscr);
		
		JLabel LabelYO_NU_1 = new JLabel("YO NUNCA");
		LabelYO_NU_1.setHorizontalAlignment(SwingConstants.LEFT);
		LabelYO_NU_1.setForeground(new Color(0, 0, 0));
		LabelYO_NU_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		LabelYO_NU_1.setBounds(10, 95, 87, 19);
		PantallaModos.add(LabelYO_NU_1);
		
		JLabel LabelYO_NU_1_1 = new JLabel("¿QUE PREFIERES?");
		LabelYO_NU_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		LabelYO_NU_1_1.setForeground(Color.BLACK);
		LabelYO_NU_1_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		LabelYO_NU_1_1.setBounds(10, 164, 138, 19);
		PantallaModos.add(LabelYO_NU_1_1);
		
		JLabel LabelYO_NU_1_1_1 = new JLabel("VERDAD O RETO");
		LabelYO_NU_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		LabelYO_NU_1_1_1.setForeground(Color.BLACK);
		LabelYO_NU_1_1_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		LabelYO_NU_1_1_1.setBounds(10, 234, 138, 19);
		PantallaModos.add(LabelYO_NU_1_1_1);
		
		JLabel LabelYO_NU_1_1_2 = new JLabel("TUS PREGUNTAS");
		LabelYO_NU_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		LabelYO_NU_1_1_2.setForeground(Color.BLACK);
		LabelYO_NU_1_1_2.setFont(new Font("Segoe Print", Font.BOLD, 14));
		LabelYO_NU_1_1_2.setBounds(10, 311, 176, 19);
		PantallaModos.add(LabelYO_NU_1_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Añadir Participantes");
		lblNewLabel_1.setForeground(new Color(51, 0, 0));
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1.setBounds(10, 403, 239, 29);
		PantallaModos.add(lblNewLabel_1);
		
		entraPartisipantes = new JTextField();
		entraPartisipantes.addMouseListener(new MouseAdapter() {
		
		});
		entraPartisipantes.setColumns(10);
		entraPartisipantes.setBounds(249, 403, 375, 29);
		PantallaModos.add(entraPartisipantes);
		
		JLabel addParti = new JLabel("+");
		addParti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//add los partisipantes 
				String nombre = entraPartisipantes.getText();
				p.addParticipantes(nombre);
				entraPartisipantes.setText("");
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				addParti.setFont(new Font("Lucida Fax", Font.BOLD, 45));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				addParti.setFont(new Font("Lucida Fax", Font.BOLD, 51));
			}
		});
		addParti.setHorizontalAlignment(SwingConstants.CENTER);
		addParti.setForeground(Color.BLACK);
		addParti.setFont(new Font("Lucida Fax", Font.BOLD, 51));
		addParti.setBounds(620, 391, 46, 41);
		PantallaModos.add(addParti);
		
		
		

	
	}
}
