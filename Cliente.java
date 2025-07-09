package Personas;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner; 
import Viviendas.*;

/**
* @ (#) Cliente.java
* 
* Clase Cliente.
* Es una subclase que hereda de la superclase Persona.
* Lo más importante de la clase es la creación de objetos sobre los que se realizab
* ciertas acciones que vienen de la clase GestionEstudio.
* Representa a los propietarios de las viviendas y pueden solicitar diversos
* proyectos o certificados al mismo.
*
* @autora Romina Ronda
* @versión mayo 2022
**/


public class Cliente extends Persona{
    private Map<Integer, Proyecto> proyectos = new HashMap<Integer, Proyecto> ();
    private Map<Integer, Certificado> certificados = new HashMap<Integer, Certificado> ();
    public static final  Scanner input = new Scanner(System.in);
  
    public Cliente () {
    } 
 
    public Cliente (String nombre, String dni, Integer telefono, String correo) {
       super(nombre, dni, telefono, correo);
  
    }
 
    public Cliente (String nombre, String dni, Integer telefono, String correo, Map proyectos, 
       Map certificados) {
       super(nombre, dni, telefono, correo);
       this.proyectos = new HashMap<Integer, Proyecto> ();
       this.certificados = new HashMap<Integer, Certificado> ();
  
    }
 
    public Map<Integer, Proyecto> getProyectos(){
       return proyectos;
    }
 
    public void setProyectos(HashMap<Integer, Proyecto> proyectos){
        this.proyectos = proyectos;
    }
 
    public Map<Integer, Certificado> getCertificados(){
       return certificados;
    }
 
    public void setCertificados(HashMap<Integer, Certificado> certificados){
       this.certificados = certificados;
    }
 
    public void putProyecto(Integer proyectoID, Proyecto proyecto) {
       this.proyectos.put(proyectoID, proyecto);
    }
 
    public void putCertificado(Integer certificadoID, Certificado certificado) {
       this.certificados.put(certificadoID, certificado);
    }
 
    //a través del método altaClientes conseguimos los datos de los clientes que llegan al estudio
    public Cliente altaClientes(){ 
       System.out.print("Introduce el nombre del cliente: ");
       String nombre = input.nextLine();  
       System.out.print("Introduce el DNI: ");
       String dni = input.nextLine();
       System.out.print("Introduce el teléfono: ");
       String tfno = input.nextLine();
       Integer telefono = Integer.parseInt(tfno);
       System.out.print("Introduce el correo electrónico: ");
       String correo = input.nextLine();
       Cliente cliente = new Cliente (nombre, dni, telefono, correo);
       return cliente;
    }
 
 
    public void imprimirListaProyectos(){
        for (Map.Entry<Integer, Proyecto> entry: proyectos.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }
 
    public void imprimirListaCertificados(){
        for (Map.Entry<Integer, Certificado> entry: certificados.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }
 
    // no funciona correctamente
    public String toStringPrueba() {
        String datosCliente = super.toString();
        imprimirListaProyectos();
        imprimirListaCertificados();
  
        return datosCliente; 
    }
 
 
    @Override
    public String toString() {
        String datosCliente = super.toString() + "\n PROYECTOS: \n" + proyectos.entrySet() 
        + "\n CERTIFICADOS: \n"+ certificados.entrySet();
 
       return datosCliente; 
    }
 
 
    public String toStringSimple() {
        String datosCliente = super.toString();

        return datosCliente; 
    }
}
