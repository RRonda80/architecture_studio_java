package Personas;
import TiposEnumerados.*;

/**
* @ (#) Aparejador.java
* 
* Clase Aparejador.
* Es una de las subclases que hereda de Persona y de Empleado.
*
* @autora Romina Ronda
* @versión mayo 2022
*/


public class Aparejador extends Empleado{
    public Aparejador (String nombre, String dni, Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {    
        super(nombre, dni, telefono, correo, puesto);
    }
 
    public Aparejador (String nombre, Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {   
        super(nombre, telefono, correo, puesto);
    }

    @Override
    public String toString() {
        String datosAparejador= super.toString();
        return datosAparejador;
    }
}
