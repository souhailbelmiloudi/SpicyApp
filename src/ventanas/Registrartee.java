package ventanas;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.SystemColor;


public class Registrartee extends JFrame {

	private static final long serialVersionUID = -4496036342118392502L;

	private JPanel contentPane;
	private JTextField NombreTxt;
	private JTextField apellidotxt;
	private JTextField correoTXT;
	private JPasswordField pwdSsss;
	Conexion conx = new Conexion();
	Connection con;
	Sign_in signin =new Sign_in();
	
	public Registrartee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(255, 228, 196));
		panel.setBackground(new Color(255, 127, 80));
		panel.setBounds(0, 0, 409, 439);
		contentPane.add(panel);
		
		JLabel titulo = new JLabel("¡REGÍSTRATE YA!");
		titulo.setFont(new Font("Sylfaen", Font.BOLD, 23));
		titulo.setBounds(10, 11, 235, 36);
		panel.add(titulo);
		
		JLabel subtitulo = new JLabel("Es rápido y fácil.");
		subtitulo.setForeground(new Color(250, 235, 215));
		subtitulo.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 17));
		subtitulo.setBounds(20, 34, 159, 32);
		panel.add(subtitulo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 66, 409, 7);
		panel.add(separator_1);
		
		NombreTxt = new JTextField();
		NombreTxt.setColumns(10);
		NombreTxt.setBounds(10, 120, 173, 36);
		panel.add(NombreTxt);
		
		apellidotxt = new JTextField();
		apellidotxt.setColumns(10);
		apellidotxt.setBounds(226, 120, 173, 36);
		panel.add(apellidotxt);
		
		correoTXT = new JTextField();
		correoTXT.setColumns(10);
		correoTXT.setBounds(10, 203, 389, 36);
		panel.add(correoTXT);
		
		pwdSsss = new JPasswordField();
		pwdSsss.setEchoChar('*');
		pwdSsss.setBounds(10, 274, 389, 36);
		panel.add(pwdSsss);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre ");
		lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 102, 130, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel_3.setBounds(226, 102, 130, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo electrónico");
		lblNewLabel_4.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel_4.setBounds(10, 183, 203, 25);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contraseña");
		lblNewLabel_5.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 254, 173, 25);
		panel.add(lblNewLabel_5);
		
		JLabel registrarbtn = new JLabel("Registrarte");
		registrarbtn.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
		        String nombre = NombreTxt.getText(); //Especifica el nombre del jugador
		        String correo =  correoTXT.getText(); //Especifica el correo del jugador
		        String contrasenaJugador =pwdSsss.getText() ; //Especifica la contraseña del jugador
		        String apellido = apellidotxt.getText();
		      
		      
			
	
	
		        
		         if (nombre.isEmpty()||correo.isEmpty()||apellido.isEmpty()||contrasenaJugador.isEmpty()) {
		        	JOptionPane.showMessageDialog(null, "Debe completar los datos ");
		        }else {
		        	
		        	  if (validarContrasena(contrasenaJugador) && validarCorreo(correo)) {
		        		  try {
		        			  
				        		con = conx.conectar();
				        		String consulta = "INSERT INTO jugadores VALUES (idJugador.nextval,'"+nombre+"','"+apellido+"', '"+correo+"','"+contrasenaJugador+"')";     
				        		
				    
				        		PreparedStatement ps = con.prepareStatement(consulta);
				        		ps.executeUpdate();
				       
				        		
				        		signin.setVisible(true);
								dispose();
				        	}catch( SQLException e1) {
				        		JOptionPane.showMessageDialog(null, "Error "+e1);
				        		
				        	}finally {
				        		conx.desconectar();
				        	}
				        } else {
				            JOptionPane.showMessageDialog(null,"La contraseña o el correo no válido");
				        }
		        	
		        	
		        	
		        }
	
			}
		});
		
		registrarbtn.setOpaque(true);
		registrarbtn.setHorizontalAlignment(SwingConstants.CENTER);
		registrarbtn.setForeground(Color.BLACK);
		registrarbtn.setFont(new Font("Tahoma", Font.BOLD, 23));
		registrarbtn.setBackground(new Color(102, 205, 170));
		registrarbtn.setBounds(10, 383, 389, 31);
		panel.add(registrarbtn);
		
		JLabel lblNewLabel_7 = new JLabel("Utiliza al menos 8 caracteres, una letra mayúscula, una letra minúscula ");

		lblNewLabel_7.setForeground(new Color(240, 248, 255));
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_7.setBounds(10, 307, 381, 25);
		panel.add(lblNewLabel_7);
		
		JCheckBox chckbxmostrarpassWD = new JCheckBox("Mostrar contraseña");
		chckbxmostrarpassWD.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (chckbxmostrarpassWD.isSelected()) {
					pwdSsss.setEchoChar((char) 0);
	            } else {
	            	pwdSsss.setEchoChar('*');
	            }
			}
		});
		
		
		
		chckbxmostrarpassWD.setOpaque(false);
		chckbxmostrarpassWD.setFont(new Font("Times New Roman", Font.BOLD, 12));
		chckbxmostrarpassWD.setBounds(10, 329, 149, 23);
		panel.add(chckbxmostrarpassWD);
		
		JLabel volver = new JLabel(">");
		volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signin.setVisible(true);
				dispose();
			}
		});
		volver.setForeground(SystemColor.desktop);
		volver.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 41));
		volver.setBounds(357, 11, 42, 36);
		panel.add(volver);
		
		
		
	}
	
	 // Expresión regular para verificar el formato de contraseña y  correo electrónico
	
	public boolean validarCorreo(String correo) {
	    String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	    Pattern pattern = Pattern.compile(patron);
	    Matcher matcher = pattern.matcher(correo);
	    return matcher.matches();
	}

	public boolean validarContrasena(String contrasena) {
	    // Al menos 8 caracteres, una letra mayúscula, una letra minúscula
	    String patron = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$";
	    Pattern pattern = Pattern.compile(patron);
	    Matcher matcher = pattern.matcher(contrasena);
	    return matcher.matches();
	}

}





