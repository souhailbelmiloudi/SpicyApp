package ventanas;

import java.util.ArrayList;
import java.util.Random;


public class Participantes {
	//Conexion conx = new Conexion();
	String nombre;
	//Conexion conx = new Conexion();
	//Connection con = conx.conectar();
	Sign_in participate_conectado = new Sign_in();

	// lista para guardar los nombres de participantes

	static ArrayList<String> nombres = new ArrayList<>();
	

	// una instancia de la clase random
	Random rand = new Random();

	public Participantes() {
		super();
		if (Sign_in.nombre !=null) {
		nombres.add(Sign_in.nombre);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getNombres() {
		return nombres;
	}

	public void setNombres(ArrayList<String> nombres) {
		Participantes.nombres = nombres;
	}

	// metodo para añadir participantes
	public void addParticipantes(String nombre) {
		
		
		try {

			nombres.add(nombre);
			System.out.println(nombre + " añadido");
		} catch (Exception e) {
			System.out.println(" Error al añadir participante ");
		}

	}

	// selecionar un nombre aleatoeio
	public String elegirPartisipante() {
		
		String nombreElegido = nombres.get(rand.nextInt(nombres.size()));

		return nombreElegido; 
	}

}
