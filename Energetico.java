package Viviendas;
import java.util.*; 
import TiposEnumerados.*;
import Personas.*;
import Principal.*;

/**
* @ (#) Energetico.java
* 
* Clase Energetico.
* Es una de las subclases que hereda de Certificado. Añade los atributos específicos para
* este tipo de certificado.
*
* @autora Romina Ronda
* @versión mayo 2022
*/
public class Energetico extends Certificado{
    protected Enumerados.TipoEficienciaEnergetica tipoeficiencia;
    
    public Energetico (){
        
    }

    public Energetico (String dniCliente, String direccion, Integer certificadoID,
        Enumerados.TipoCertificados tipocertificado, Date fechasolicitud, Date fechaentrega, 
        Enumerados.TipoEficienciaEnergetica tipoeficiencia) {
        super(dniCliente, direccion, certificadoID, tipocertificado, fechasolicitud, 
        fechaentrega);
        this.tipoeficiencia = tipoeficiencia;
    }
 
    ////método para publicar los datos relativos a proyectos de tipo energetico
    @Override
    public String toString() {
        String datosEnergetico = super.toString() + "\n Categoría de eficiencia energética: "
        + tipoeficiencia;
        return datosEnergetico;
    }
}