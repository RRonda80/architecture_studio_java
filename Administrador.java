package Personas;
import TiposEnumerados.*;

/**
* @ (#) Administrador.java
* 
* Clase Administrador.
* Es una de las subclases que hereda de Persona y de Empleado.
*
* @autora Romina Ronda
* @versión mayo 2022
*/


public class Administrador extends Empleado{
    public Administrador (String nombre, String dni, Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {
     super(nombre, dni, telefono, correo, puesto);
    }
 
    public Administrador (String nombre, Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {
     super(nombre, telefono, correo, puesto);
    }
 
    @Override
    public String toString() {
        String datosAdministrador = super.toString();
        return datosAdministrador;
    }
}
