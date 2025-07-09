package Personas;
import Principal.*;
import Viviendas.*;

/**
* @ (#) Persona.java
* 
* Clase Persona.
* Es la superclase que van a heredar las subclases Arquitecto, Aparejador, Contable y Cliente.
* Persona contiene
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Persona {
    private String nombre;
    private String dni;
    private Integer telefono;
    private String correo;
 
    //tres métodos constructores para crear con la información desde teclado
    //para crear el array y guardar objetos del tipo correspondiente
    //para modificar datos de las personas ya introducidas en el sistema
    public Persona (){
 
    }
 
    public Persona (String nombre, String dni, Integer telefono, String correo) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
    }
 
    public Persona (String nombre, Integer telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getDni() {
        return dni;
    }

    public void setDni(String Dni) {
        this.dni = dni;
    }
 
    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /*@Override*/
    public String toString() {
        String datosPersona = "\n Nombre: " + nombre + "\n DNI: " + dni + "\n Teléfono: " + telefono +
        "\n Correo: " + correo;
        
        return datosPersona;
    }
}