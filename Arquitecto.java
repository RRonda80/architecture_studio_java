package Personas;
import TiposEnumerados.*;

/**
* @ (#) Arquitecto.java
* 
* Clase Arquitecto.
* Es una de las subclases que hereda de Persona y de Empleado.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Arquitecto extends Empleado{
    public Arquitecto (String nombre, String dni, Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {
        super(nombre, dni, telefono, correo, puesto);
    }
 
    public Arquitecto (String nombre, Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {
        super(nombre, telefono, correo, puesto);
    }
 
    @Override
    public String toString() {
        String datosArquitecto = super.toString();
        return datosArquitecto;
    }
}