/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO.Roles;

/**
 *
 * @author Abraham
 */
public class SesionUsuario {
    
    private static String nombreUsuario;
    private  static RolUsuario rol;
    private static String nom;
    public SesionUsuario(){
        
    }
    public SesionUsuario(String nombreUsuario, RolUsuario rol) {
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
 

    public RolUsuario getRol() {
        return rol;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
    
   public static String getRoluser() {
    return (rol != null) ? rol.name() : "Rol no asignado";

    
   }
 
  
}
