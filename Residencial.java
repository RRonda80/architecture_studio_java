package Viviendas;
import java.util.*; 
import TiposEnumerados.*;
import Personas.*;
import TiposEnumerados.*;

/**
* @ (#) Residencial.java
* 
* Clase Residencial.
* Es una de las subclases que hereda de Proyecto. Añade los atributos específicos para
* este tipo de proyecto.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Residencial extends Proyecto{
    protected String direccion;
    protected Integer superficieT;
    protected Integer superficieEd;
    protected Integer plantas;
    protected Integer hab;
    protected Integer ban;
    
    //primer constructor
    public Residencial (){
 
    }

    //constructor específico para los proyectos de tipo residencial
    public Residencial (String dniCliente, String direccion,Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion, Enumerados.TipoEstados tipoestados,Integer superficieT,Integer superficieEd,Integer plantas,Integer hab,
           Integer ban) {
           super(dniCliente,direccion,proyectoID,tipoproyecto,fechasolicitud,fechafinalizacion, 
           duracion, tipoestados);
           this.superficieT = superficieT;
           this.superficieEd = superficieEd;
           this.plantas = plantas;
           this.hab = hab;
           this.ban = ban;
    }
 
    ////método para publicar los datos relativos a proyectos de tipo residencial
    @Override
    public String toString() {
        String datosResidencial = super.toString() +  "\n\n DATOS ESPECIFICOS DEL PROYECTO:"
        +"\n Superficie del terreno: " + superficieT + "\n Superficie del edificio: " 
        + superficieEd + "\n Número de plantas: " + plantas + "\n Número de habitaciones: " 
        + hab + "\n Número de baños: " + ban;
        return datosResidencial;
    }
}
