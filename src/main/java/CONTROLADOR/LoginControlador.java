
package CONTROLADOR;


import MODELO.Roles.RolUsuario;
import MODELO.Roles.SesionUsuario;
import MODELO.UsuarioModel;
import java.sql.SQLException;
import VISTA.LOGIN;
import VISTA.VentanaPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LoginControlador {
  private UsuarioModel usuarioModel; // Variable para referencia al modelo
    private LOGIN loginView; // Referencia a la vista de login

    public LoginControlador(LOGIN loginView) {
        this.usuarioModel = new UsuarioModel(); // Instancia del modelo para autenticación
        this.loginView = loginView; // Asigna la vista al controlador
    }

    
    public void validarCredenciales() {
    String usuario = loginView.getusuario(); // Obtener usuario desde la vista
    String contraseña = loginView.getpass(); // Obtener contraseña desde la vista

    SesionUsuario sesion = usuarioModel.verificarLogin(usuario, contraseña);

    if (sesion != null) {
        loginView.setResultado("Login successful" +sesion.getNombreUsuario().toUpperCase() );
        
        mostrarVentanaPrincipal(); // Llama al método para mostrar VentanaPrincipal
    } else {
        // Muestra el mensaje de error específico desde el modelo, o un mensaje genérico si no hay error detallado
        loginView.setResultado(usuarioModel.getMensajeError() != null ? usuarioModel.getMensajeError() : "Usuario o contraseña incorrectos");
    }
}


    // Método para mostrar la ventana principal y ocultar la de login
    private void mostrarVentanaPrincipal() {
        // Cierra la ventana de login
        loginView.setVisible(false);

        // Instancia y configura la ventana principal
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Agrega un listener para volver a mostrar el login al cerrar la ventana principal
        ventanaPrincipal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loginView.setVisible(true); // Vuelve a mostrar el login cuando se cierra VentanaPrincipal
            }
        });

        ventanaPrincipal.setVisible(true); // Muestra la ventana principal
    }

    // Método estático opcional para cambiar de ventana
    public static void cambiarVentanas(JFrame ventanaActual, JFrame ventanaSiguiente) {
        ventanaActual.setVisible(false);
        ventanaSiguiente.setVisible(true);
    }
}
