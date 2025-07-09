package Viviendas;
import java.util.*; 
import TiposEnumerados.*;
import Personas.*;


/**
* @ (#) Comercial.java
* 
* Clase Comercial.
* Es una de las subclases que hereda de Proyecto. Añade los atributos específicos para
* este tipo de proyecto.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Comercial extends Proyecto{
    protected Integer superficieT;
    protected Integer superficieEd;
    protected String finalidad;
    
    //primer constructor
    public Comercial (){
 
    }
    
    //constructor específico para los proyectos de tipo comercial
    public Comercial (String dniCliente, String direccion,Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion,Enumerados.TipoEstados tipoestados, Integer superficieT,Integer superficieEd,String finalidad) {
           super(dniCliente, direccion, proyectoID, tipoproyecto,fechasolicitud,fechafinalizacion, 
           duracion,tipoestados);
           this.superficieT = superficieT;
           this.superficieEd = superficieEd;
           this.finalidad = finalidad;
    }
 
    //método de impresión
    @Override
    public String toString() {
        String datosComercial = super.toString() + "\n\n DATOS ESPECÍFICOS DEL PROYECTO:"
        + "\n Superficie del terreno: " + superficieT + "\n Superficie del edificio: " 
        + superficieEd + "\n Finalidad: " + finalidad;
        return datosComercial;
    }
 
 
}