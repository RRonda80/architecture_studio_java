package Viviendas;
import java.util.*; 
import TiposEnumerados.*;
import Personas.*;
import Principal.*;

/**
 * Beschreiben Sie hier die Klasse Proyecto.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class Vivienda {
    protected String dniCliente;
    protected String direccion;
    
    public  Vivienda () {
    }
 
    //se introducen los primeros datos de la vivienda
    public  Vivienda (String dniCliente, String direccion){
        this.dniCliente = dniCliente;
        this.direccion = direccion;
    }
 
    public String getDniCliente(){
        return dniCliente;
    }
    
    public void setDniCliente (String dniCliente){
        this.dniCliente = dniCliente;
    }
 
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion (String direccion){
     this.direccion = direccion;
    }
    
    //método para publicar los datos relativos a las viviendas del sistema
    @Override
    public String toString() {
        String datosVivienda = "\n DNI Cliente: " + dniCliente + "\n Dirección: " + direccion;
        return datosVivienda;
    } 
}
