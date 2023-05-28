package ventanas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Conexion {

	//Variables miembro:
	Connection conexion ;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	//Variables de configuración de la conexión:
	
    // driver para conectarse a Oracle
    String driver = "oracle.jdbc.driver.OracleDriver";
    // url de la base de datos, en este caso una base de datos local
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    // usuario de la base de datos
    String usuario = "spicyApp";
    // contraseña de la base de datos
    String contrasena = "spicyApp";
    
    //Método "conectar":
   public Connection conectar () {
	   
	   try {
		// carga del driver de Oracle
           Class.forName(driver);
           // conexión a la base de datos
           this.conexion = DriverManager.getConnection(url, usuario, contrasena);
	   } catch (ClassNotFoundException e) {
	        System.err.println("Error al cargar el driver: " + e);
	   } catch (SQLException e) {
	        System.err.println("Error al conectarse a la base de datos: " + e);
	    }
	   return conexion;
   }
	
   /*Este método recibe una consulta SQL en forma de cadena y un nombre de columna. Ejecuta la consulta en la base de datos y devuelve el valor de la 
    * columna especificada de la primera fila de resultados. Si no se encuentra ninguna fila, devuelve un mensaje indicando que  no se encontraron resultados.*/
   public String consulta(String sql,String columna) {
	    
	    try {
	        // creación de la sentencia
	        stmt = conexion.createStatement();
	        // ejecución de la consulta
	        rs = stmt.executeQuery(sql);
	        if (rs.next()) {
				String randomValue = rs.getString(columna);
				return  randomValue;
			} else {
				return "No se encontraron resultados.";
			}
	    } catch (Exception e) {
	        System.err.println("Error de consulta: " + e);
	    }
	   return null;
	}

   /*Este método se encarga de cerrar el objeto ResultSet, el objeto Statement y la conexión con la base de datos.*/
   public void desconectar() {
	    try {
	        if (rs != null) {
	            rs.close();
	        }
	        if (stmt != null) {
	            stmt.close();
	        }
	        if (conexion != null) {
	            conexion.close();
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al cerrar la conexión: " + e);
	    }
	}

   ////////////////////////////////////////////////////////////////
   public  List<Map<String, Object>> consulta(String sql, String orderBy, String... columnas) {
	    List<Map<String, Object>> resultados = new ArrayList<>();

	    try {
	        // Creación de la sentencia
	        stmt = conexion.createStatement();
	        // Ejecución de la consulta
	        String consultaOrdenada = sql + " ORDER BY " + orderBy;
	        rs = stmt.executeQuery(consultaOrdenada);

	        while (rs.next()) {
	            Map<String, Object> fila = new HashMap<>();
	            for (String columna : columnas) {
	                Object valor = rs.getObject(columna);
	                fila.put(columna, valor);
	            }
	            resultados.add(fila);
	        }

	    } catch (Exception e) {
	        System.err.println("Error de consulta: " + e);
	    }

	    return resultados;
	}

	
}
