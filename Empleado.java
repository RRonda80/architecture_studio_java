package Personas;
import TiposEnumerados.*;
import Viviendas.*;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
* @ (#) Empleado.java   
* 
* Clase Empleado.
* Es una subclase que hereda de la superclase Persona.
* Incluye a los empleados que podemos encontrar en el estudio: administrador/a,
* arquitecto/a, aparejador/a, contable.
*
* @autora Romina Ronda
* @versión mayo 2022
*/


public class Empleado extends Persona{
    private Enumerados.TipoEmpleados puesto;
    public Scanner input = new Scanner(System.in);
 
    public Empleado (){
    } 
 
    public Empleado (String nombre, String dni, Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {
        super(nombre, dni, telefono, correo);
        this.puesto = puesto;
    }
 
    public Empleado (String nombre, Integer telefono, String correo, 
    Enumerados.TipoEmpleados puesto) {
        super(nombre, telefono, correo);
        this.puesto = puesto;
    }

    public Enumerados.TipoEmpleados getPuesto() {
        return puesto;
    }

    public void setPuesto(Enumerados.TipoEmpleados puesto) {
        this.puesto = puesto;
    }
 
    public Empleado altaEmpleados(){ 
        System.out.print(" Introduce el nombre del empleado: ");
        String nombre = input.nextLine();  
        System.out.print(" Introduce el DNI: ");
        String dni = input.nextLine();
        System.out.print(" Introduce el teléfono: ");
        String tfno = input.nextLine();
        Integer telefono = Integer.parseInt(tfno);
        System.out.print(" Introduce el correo electrónico: ");
        String correo = input.nextLine();
        System.out.print(" Selecciona el puesto:\n");
        System.out.print(Enumerados.menuTipoEmpleados());
        String pst = input.nextLine();
        Integer puesto = Integer.parseInt(pst);
        Enumerados.TipoEmpleados tipoEmpl = Enumerados.TipoEmpleados.values()[puesto];
        Empleado empleado = null;
  
        if (Enumerados.TipoEmpleados.ADMINISTRADOR.equals(tipoEmpl)){
            empleado = new Administrador (nombre, dni, telefono, correo, tipoEmpl); 
        }
  
        if (Enumerados.TipoEmpleados.ARQUITECTO.equals(tipoEmpl)){
            empleado = new Arquitecto (nombre, dni, telefono, correo, tipoEmpl); 
        }
  
        if (Enumerados.TipoEmpleados.APAREJADOR.equals(tipoEmpl)){
            empleado = new Aparejador (nombre, dni, telefono, correo, tipoEmpl); 
        }
  
        if (Enumerados.TipoEmpleados.CONTABLE.equals(tipoEmpl)){
            empleado = new Contable (nombre, dni, telefono, correo, tipoEmpl); 
        }
   
        return empleado;
    } 
 
    public String toString() {
        String datosEmpleado = super.toString() +
        "\n Puesto: " + puesto;
        return datosEmpleado;
    }
}

