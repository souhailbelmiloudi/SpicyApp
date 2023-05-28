package tusPreguntas;

import java.awt.EventQueue;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ventanas.TUS_PREGUNTAS;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class BuscarPregunta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4621762969700703946L;
	private JPanel contentPane;
	
	int xMouse, yMouse;
	List<Map<String, Object>> prebu=TUS_PREGUNTAS.preguntas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarPregunta frame = new BuscarPregunta();
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
	public BuscarPregunta() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 473);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				yMouse = e.getY();
				xMouse = e.getX();
			}
		});
		//para permitir arrastrar la ventana
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		scrollPane.setBackground(new Color(250, 235, 215));
		
		JLabel lblNewLabel = new JLabel("Buscar Preguntas");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCerrar = new JLabel("Cerrar");
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Verdana", Font.PLAIN, 19));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(292)
					.addComponent(lblCerrar, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(303, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(309, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(286))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCerrar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		table.setBackground(new Color(230, 230, 250));
		table.setFont(new Font("Verdana", Font.BOLD, 12));
		table.setGridColor(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PREGUNTA", "ID"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(394);
		table.getColumnModel().getColumn(1).setPreferredWidth(184);
		
	
		
		for (Map<String, Object> filas : prebu) {
		    Object[] fila = new Object[2]; // Crear un arreglo de tamaño 2 para dos columnas

		    int columnIndex = 0; // Índice de la columna

		    for (String columna : filas.keySet()) {
		        Object valor = filas.get(columna);
		        fila[columnIndex] = valor; // Asignar el valor a la columna correspondiente
		        columnIndex++; // Incrementar el índice de la columna
		    }

		    ((DefaultTableModel) table.getModel()).addRow(fila);
		}


		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
