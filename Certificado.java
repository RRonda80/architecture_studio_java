package Viviendas;
import java.util.*; 
import java.text.SimpleDateFormat;
import java.util.Date;
import TiposEnumerados.*;
import Personas.*; 
import Principal.*;

/**
* @ (#) Certificado.java
* 
* Clase Certificado.
* 
* Hereda los atributos de DNI del cliente y dirección de la superclase Vivienda.
* Esta clase engloba todos los constructores y métodos necesarios para la creación de objetos 
* tipo Certificado y la actualización de la información por parte de los agentes implicados.
* También contiene diferentes métodos de impresión de la información relativa a los diferentes
* tipos de certificados.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Certificado extends Vivienda{
    protected Integer certificadoID;
    protected Enumerados.TipoCertificados tipocertificado;
    protected Date fechasolicitud;
    protected Date fechaentrega;
    protected Integer presupuesto;
    protected String nombArquitecto;
    protected String nombAparejador;
    protected String nombContable;

    public Scanner input = new Scanner(System.in);
    public static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); //transforma date
    public GestionEstudio estudio = new GestionEstudio();
    
    public Certificado () {
    }
 
    //los arquitectos introducen por primera vez una solicitud de certificado
    //con los siguientes datos introducidos por teclado
    public Certificado (String dniCliente, String direccion, Integer certificadoID, Enumerados.TipoCertificados 
           tipocertificado, Date fechasolicitud, Date fechaentrega){
           super(dniCliente, direccion);
           this.certificadoID = certificadoID;
           this.tipocertificado = tipocertificado;
           this.fechasolicitud = fechasolicitud;
           this.fechaentrega = fechaentrega;
    }
 
    //los administradores asignan los empleados - arquitecto, aparejador, contable - que 
    //se encargarán del certificado
    public Certificado (String dniCliente, String direccion,Integer certificadoID, Enumerados.TipoCertificados 
           tipocertificado, Date fechasolicitud, Date fechaentrega,String nombArquitecto, 
           String nombAparejador, String nombContable){
           super(dniCliente, direccion);
           this.certificadoID = certificadoID;
           this.tipocertificado = tipocertificado;
           this.fechasolicitud = fechasolicitud;
           this.fechaentrega = fechaentrega;
           this.nombArquitecto = nombArquitecto;
           this.nombAparejador = nombAparejador;
           this.nombContable = nombContable;
    }
 
    //por último, los contables actualizan los proyectos añadiendo la información relativa 
    //al presupuesto
    public Certificado (String dniCliente, String direccion, Integer certificadoID, Enumerados.TipoCertificados 
           tipocertificado, Date fechasolicitud, Date fechaentrega,String nombArquitecto, 
           String nombAparejador, String nombContable, Integer presupuesto){
           super(dniCliente, direccion);
           this.tipocertificado = tipocertificado;
           this.fechasolicitud = fechasolicitud;
           this.fechaentrega = fechaentrega;
           this.nombArquitecto = nombArquitecto;
           this.nombAparejador = nombAparejador;
           this.nombContable = nombContable;
           this.presupuesto = presupuesto;  
    }
 
    public Integer getCertificadoID(){
           return certificadoID;
    }
    
    public void setCertificadoID (Integer certificadoID){
           this.certificadoID = certificadoID;
    }
 
    public Enumerados.TipoCertificados getTipoCertificados(){
           return tipocertificado;
    }
    
    public void setTipoCertificados (Enumerados.TipoCertificados tipocertificado){
           this.tipocertificado = tipocertificado;
    }
 
    public Date getFechaSolicitud(){
           return fechasolicitud;
    }
    
    public void setFechaSolicitud(Date fechasolicitud){
           this.fechasolicitud = fechasolicitud;
    }
    
    public Date getFechaEntrega(){
           return fechaentrega;
    }
    
    public void setFechaEntrega(Date fechaentrega){
           this.fechaentrega = fechaentrega;
    }
 
    public String getNombArquitecto(){
           return nombArquitecto;
    }
    
    public void setNombArquitecto (String nombArquitecto){
           this.nombArquitecto = nombArquitecto;
    }
 
    public String getNombAparejador(){
           return nombAparejador;
    }
    
    public void setNombAparejador (String nombAparejador){
           this.nombAparejador = nombAparejador;
    }
 
    public String getNombContable(){
           return nombContable;
    }
    
    public void setNombContable (String nombContable){
           this.nombContable = nombContable;
    }
 
    public Integer getPresupuesto(){
           return presupuesto;
    }
 
    public void setPresupuesto (Integer presupuesto){
           this.presupuesto = presupuesto;
    }
 
    public Certificado altaCertificado(Integer nuevoNumCert) { 
        System.out.print("Introduce el DNI del cliente: \n");
        String dniCliente = input.nextLine();
        System.out.print("Introduce la dirección de la vivienda: \n");
        String direccion = input.nextLine();
        System.out.print("\nID del certficado es: " + nuevoNumCert + "\n");
        System.out.print("Introduce el tipo de certificado: \n");
        System.out.print(Enumerados.menuTipoCertificados());
        String cert = input.nextLine();
        Integer tipocertificado = Integer.parseInt(cert);
        Enumerados.TipoCertificados tipoCert = Enumerados.TipoCertificados.values()[tipocertificado];
        System.out.print("Introduce la fecha de solicitud (dd/MM/aaaa): \n");
        String fechaSolCadena= input.nextLine();
        Date fechasolicitud = StringADate(fechaSolCadena);
        System.out.print("Introduce la fecha de entrega al cliente: \n");
        String fechaEntCadena= input.nextLine();
        Date fechaentrega = StringADate(fechaEntCadena);
        Certificado certificado = null; 
  
        if (Enumerados.TipoCertificados.HABITABILIDAD.equals(tipoCert)){
            System.out.print("Introduce la fecha del certificado anterior (dd/MM/aaaa): \n");
            String fechaAntCadena= input.nextLine();
            Date fecha_anteriorCertificado = StringADate(fechaAntCadena);
            certificado = new Habitabilidad (dniCliente, direccion, nuevoNumCert, tipoCert,
            fechasolicitud, fechaentrega, fecha_anteriorCertificado);
        }
     
        if (Enumerados.TipoCertificados.INSPECCION.equals(tipoCert)){
            System.out.print("Introduce la fecha del construcción (dd/MM/aaaa): \n");
            String fechaAntCadena= input.nextLine();
            Date fecha_construccion = StringADate(fechaAntCadena);
            certificado = new Inspeccion (dniCliente, direccion, nuevoNumCert, tipoCert,
            fechasolicitud, fechaentrega);
        }
     
        if (Enumerados.TipoCertificados.ENERGETICO.equals(tipoCert)){
            System.out.print("Introduce categoría de eficiencia: \n");
            System.out.print(Enumerados.menuTipoEficienciaEnergetica());
            String efe = input.nextLine();
            Integer tipoeficiencia = Integer.parseInt(efe);
            Enumerados.TipoEficienciaEnergetica tipoEfe = Enumerados.TipoEficienciaEnergetica.values()
            [tipoeficiencia];
            certificado = new Energetico (dniCliente, direccion,nuevoNumCert,tipoCert,
            fechasolicitud, fechaentrega, tipoEfe);
        }
        
        if (Enumerados.TipoCertificados.PERICIAL.equals(tipoCert)){
            certificado = new Pericial (dniCliente, direccion, nuevoNumCert, tipoCert, 
            fechasolicitud, fechaentrega);
        }
  
        return certificado; 
    }
 
    //método para transformar un String instroducido por teclado en un Date que quedará guardado
    public static Date StringADate(String fechaCadena){
        Date fecha=null;
        try{
            fecha=sdf.parse(fechaCadena);
         } catch (Exception e){
            System.out.print(" La fecha introducida es errónea. Se graba la fecha actual.\n");//si la fecha introducida es
            //erronea se graba la fecha de hoy
            long miliseconds = System.currentTimeMillis();
            Date fecha_error = new Date(miliseconds);
            return fecha_error; 
        }
        return fecha;
     }
 
    //método para devolver una fecha como Date a una cadena con el formato deseado dd/MM/YYYY
    public String imprimirFecha(Date fecha) {
        return sdf.format(fecha);
    }
 
    //metodos de impresion datos vivienda DNI + direccion
     public String toStringVivienda() {
         String datosCertificado = "\n DATOS VIVIENDA: " + super.toString();
         return datosCertificado;
    }
 
    public String toString() {
        String datosCertificado ="\n DATOS VIVIENDA: " + super.toString() + 
        "\n\n DATOS CERTIFICADO: "+ "\n ID Certificado: " + certificadoID + 
        "\n Tipo de certificado: " + tipocertificado + "\n Fecha de solicitud: " 
        + imprimirFecha(fechasolicitud) + "\n Fecha de entrega: "+ imprimirFecha(fechaentrega); 
     
        if (nombArquitecto!=null){
            datosCertificado = datosCertificado + "\n Nombre del arquitecto: " + nombArquitecto;
        }else{
            datosCertificado = datosCertificado + "\n Nombre del arquitecto: todavía no asignado." ;  
        }   
     
        if (nombAparejador!=null){
            datosCertificado = datosCertificado + "\n Nombre del aparejador: " + nombAparejador;
        }else{
            datosCertificado = datosCertificado + "\n Nombre del aparejador: todavía no asignado." ;  
        }   
     
        if (nombContable!=null){
           datosCertificado = datosCertificado + "\n Nombre del contable: " + nombContable;
        }else{
           datosCertificado = datosCertificado + "\n Nombre del contable: todavía no asignado." ;  
        }
     
        if (presupuesto!=null){
           datosCertificado = datosCertificado + "\n Presupuesto: " + presupuesto;
        }else{
           datosCertificado = datosCertificado + "\n Presupuesto: falta por presupuestar." ;  
        }     
        return datosCertificado;
    }
 
    public String toStringSimple() {
        String datosCertificado = "\n DNI Cliente: " 
        + dniCliente + "\n Dirección de la vivienda: "
        + direccion + "\n ID Certificado: " + certificadoID + "\n Tipo de certificado: " 
        + tipocertificado + "\n Fecha de solicitud: " + imprimirFecha(fechasolicitud)+ 
        "\n Fecha de entrega: "+ imprimirFecha(fechaentrega); 
        return datosCertificado;
    }
}
