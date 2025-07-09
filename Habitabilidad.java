package Viviendas;
import java.util.*; 
import TiposEnumerados.*;
import Personas.*;
import Principal.*;

/**
* @ (#) Habitabilidad.java
* 
* Clase Habitabilidad.
* Es una de las subclases que hereda de Certificado. Añade los atributos específicos para
* este tipo de certificado.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Habitabilidad extends Certificado{
    protected String nombArquitecto;
    protected String nombAparejador;
    protected Date fecha_anteriorCertificado;   
 
    public Habitabilidad (){
        
    }

    public Habitabilidad (String dniCliente, String direccion, Integer certificadoID,
        Enumerados.TipoCertificados tipocertificado, Date fechasolicitud, Date fechaentrega,
        Date fecha_anteriorCertificado) {
        super(dniCliente,direccion, certificadoID, tipocertificado, fechasolicitud, fechaentrega);
        this.fecha_anteriorCertificado = fecha_anteriorCertificado;
    }
    
    public Date getFecha_AnteriorCertificado(){
        return fecha_anteriorCertificado;
    }
    
    public void setFecha_AnteriorCertificado(Date fecha_anteriorCertificado){
        this.fecha_anteriorCertificado = fecha_anteriorCertificado;
    }
    
    ////método para publicar los datos relativos a la clase habitabilidad
    @Override
    public String toString() {
        String datosHabitabilidad = super.toString() + "\n Fecha emisión del certificado anterior: "
        + imprimirFecha(fecha_anteriorCertificado);
        return datosHabitabilidad;
    }
}
