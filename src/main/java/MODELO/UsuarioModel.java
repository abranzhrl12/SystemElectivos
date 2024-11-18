
package MODELO;
import MODELO.Roles.RolUsuario;
import MODELO.Roles.SesionUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.json.JSONObject;
public class UsuarioModel {
//    public SesionUsuario verificarLogin(String usuario, String contrasena) {
//        SesionUsuario sesionUsuario = null;
//
//        try (Connection con = CONEXION.conectar();
//             PreparedStatement stmt = con.prepareStatement("SELECT public.verificar_login(?, ?)")) {
//
//            stmt.setString(1, usuario);
//            stmt.setString(2, contrasena);
//
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    String resultadoJson = rs.getString(1);
//                    JSONObject resultado = new JSONObject(resultadoJson); // Convierte el resultado a JSON
//
//                    if (resultado.getString("status").equals("success")) {
//                        // Login exitoso, obtenemos el rol
//                        String rolStr = resultado.getString("rol");
//                        RolUsuario rol = RolUsuario.valueOf(rolStr.toUpperCase());
//                        sesionUsuario = new SesionUsuario(usuario, rol);
//                    } else {
//                        // Manejar mensaje de error
//                        System.out.println("Error de login: " + resultado.getString("message"));
//                    }
//                } else {
//                    System.out.println("La función no devolvió ningún resultado.");
//                }
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error al ejecutar la función verificar_login: " + e.getMessage());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Rol no reconocido: " + e.getMessage());
//        }
//
//        return sesionUsuario;
//    }
private String mensajeError; // Variable para almacenar el mensaje de error

    public SesionUsuario verificarLogin(String usuario, String contrasena) {
        SesionUsuario sesionUsuario = null;
        mensajeError = null; // Reiniciar el mensaje de error antes de cada intento

        try (Connection con = CONEXION.conectar();
             PreparedStatement stmt = con.prepareStatement("SELECT public.verificar_login(?, ?)")) {

            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String resultadoJson = rs.getString(1);
                    JSONObject resultado = new JSONObject(resultadoJson); // Convierte el resultado a JSON

                    if (resultado.getString("status").equals("success")) {
                        // Login exitoso, obtenemos el rol
                        String rolStr = resultado.getString("rol");
                        RolUsuario rol = RolUsuario.valueOf(rolStr.toUpperCase());
                      sesionUsuario = new SesionUsuario(usuario, rol);

                    } else {
                        // Captura el mensaje de error desde el JSON
                        mensajeError = resultado.getString("message");
                    }
                } else {
                    mensajeError = "La función no devolvió ningún resultado.";
                }
            }

        } catch (SQLException e) {
            mensajeError = "Error al ejecutar la función verificar_login: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            mensajeError = "Rol no reconocido: " + e.getMessage();
        }

        return sesionUsuario;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
