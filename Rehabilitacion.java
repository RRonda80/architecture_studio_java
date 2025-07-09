package Viviendas;
import java.util.*; 
import TiposEnumerados.*;
import Personas.*;

/**
* @ (#) Rehabilitacion.java
* 
* Clase Rehabilitacion.
* Es una de las subclases que hereda de Proyecto. Añade los atributos específicos para
* este tipo de proyecto.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Rehabilitacion extends Proyecto{
    protected String direccion;
    protected Integer superficie;
 
    //primer constructor
    public Rehabilitacion (){
 
    }
 
    //constructor específico para los proyectos de tipo rehabilitación
    public Rehabilitacion (String dniCliente, String direccion,Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion,Enumerados.TipoEstados tipoestados, Integer superficie) {
           super(dniCliente, direccion, proyectoID,tipoproyecto,fechasolicitud,fechafinalizacion, 
           duracion,tipoestados);
           this.superficie = superficie;
    }
 
    //método para publicar los datos relativos a proyectos de tipo rehabilitación
    @Override
    public String toString() {
        String datosRehabilitacion = super.toString() + "\n\n DATOS ESPECÍFICOS DEL PROYECTO:"
        + "\n Superficie: " + superficie;
        return datosRehabilitacion;
    }
}