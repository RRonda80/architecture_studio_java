package Viviendas;
import java.util.*; 
import TiposEnumerados.*;
import Personas.*;
import Principal.*;

/**
* @ (#) Inspeccion.java
* 
* Clase Inspeccion.
* Es una de las subclases que hereda de Certificado. Añade los atributos específicos para
* este tipo de certificado.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Inspeccion extends Certificado{
    public Inspeccion (){
        
    }

    public Inspeccion (String dniCliente, String direccion, Integer certificadoID, 
        Enumerados.TipoCertificados tipocertificado,Date fechasolicitud, Date fechaentrega){
        super(dniCliente, direccion,certificadoID, tipocertificado,fechasolicitud, 
        fechaentrega);
    }
 
    ////método para publicar los datos relativos a proyectos de tipo residencial
    @Override
    public String toString() {
        String datosInspeccion = super.toString();
        return datosInspeccion;
    }
}