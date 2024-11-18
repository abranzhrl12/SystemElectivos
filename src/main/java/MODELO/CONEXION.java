
package MODELO;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CONEXION {
  private static final String BD = "Electivas";
    private static final String USUARIO = "Electivas_owner";
    private static final String CLAVE = "SNcHvy5kXI4p";
    private static final String URL = "jdbc:postgresql://ep-silent-lake-a649bqro.us-west-2.aws.neon.tech/" + BD + "?sslmode=require";
    
    private static HikariDataSource dataSource;

    // Configuración del pool de conexiones en un bloque estático
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USUARIO);
        config.setPassword(CLAVE);
        config.setMaximumPoolSize(10); // Número máximo de conexiones en el pool, ajusta según la carga esperada
        config.setConnectionTimeout(30000); // Tiempo de espera para obtener una conexión (en ms)
        dataSource = new HikariDataSource(config);
    }

    // Constructor privado para evitar la instanciación
    private CONEXION() {}

    // Método para obtener una conexión del pool
    public static Connection conectar() throws SQLException {
        long startTime = System.currentTimeMillis(); // Inicio del tiempo
        Connection con = dataSource.getConnection(); // Obtiene una conexión disponible del pool
        long endTime = System.currentTimeMillis(); // Fin del tiempo

        System.out.println("Conexión obtenida del pool.");
        System.out.println("Tiempo de obtención de conexión: " + (endTime - startTime) + " ms"); // Tiempo en milisegundos

        return con;
    }

    // Método para cerrar el pool de conexiones
    public static void cerrarPool() {
        if (dataSource != null) {
            dataSource.close();
            System.out.println("Pool de conexiones cerrado correctamente.");
        }
    }
}
