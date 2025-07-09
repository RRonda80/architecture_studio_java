package Personas;
import TiposEnumerados.*;

/**
* @ (#) Contable.java
* 
* Clase Contable.
* Es una de las subclases que hereda de Persona y de Empleado.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Contable extends Empleado{
    public Contable (String nombre, String dni,Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {
        super(nombre, dni, telefono, correo, puesto);
    }
 
    public Contable (String nombre,Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {
        super(nombre, telefono, correo, puesto);
    }

    @Override
    public String toString() {
        String datosContable = super.toString();
        return datosContable;
    }
}
