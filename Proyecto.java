package Viviendas;
import java.util.*; 
import java.text.SimpleDateFormat;
import java.util.Date;
import TiposEnumerados.*;
import Personas.*;
import Principal.*;

/**
* @ (#) Proyecto.java
* 
* Clase Proyecto.
* 
* Hereda los atributos de DNI del cliente y dirección de la superclase Vivienda.
* Esta clase engloba todos los constructores y métodos necesarios para la creación de objetos 
* tipo Proyecto y la actualización de la información por parte de los agentes implicados.
* También contiene diferentes métodos de impresión de la información relativa a los diferentes
* tipos de proyecto.
*
* @autora Romina Ronda
* @versión mayo 2022
*/

public class Proyecto extends Vivienda{
    protected Integer proyectoID;
    protected Enumerados.TipoProyectos tipoproyecto;
    protected Date fechasolicitud;
    protected Date fechafinalizacion;
    protected Integer duracion;
    protected Integer presupuesto;
    protected String nombArquitecto;
    protected String nombAparejador;
    protected String nombContable;
    protected Enumerados.TipoEstados tipoestados;
    protected Enumerados.TipoEstadosObra tipoestadosobra;
    protected Date fechainicioObra;
    protected Date fechafinObra;

    public Scanner input = new Scanner(System.in);
    public static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); //transforma date
    public GestionEstudio estudio = new GestionEstudio();
    
    // primer constructor
    public Proyecto () {
    }
 
    //los arquitectos introducen por primera vez un proyecto con estos datos introducidos por teclado
    public Proyecto (String dniCliente, String direccion, Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion,Enumerados.TipoEstados tipoestados){
           super(dniCliente, direccion);      
           this.proyectoID = proyectoID;
           this.tipoproyecto = tipoproyecto;
           this.fechasolicitud = fechasolicitud;
           this.fechafinalizacion = fechafinalizacion;
           this.duracion = duracion;
           this.tipoestados = tipoestados;
      }
 
    //los administradores asignan los empleados - arquitecto, aparejador, contable - que 
    //se encargarán del proyecto. Asimismo en este momento el administrador introduce 
    //información sobre el estado del proyecto que puede variar entre "en trámite" o contratado
    //En este primer momento, se optará por seleccionar la opción "en trámite"
    public Proyecto (String dniCliente, String direccion,Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion, String nombArquitecto, String nombAparejador,String nombContable){
           super(dniCliente, direccion);
           this.proyectoID = proyectoID;
           this.tipoproyecto = tipoproyecto;
           this.direccion = direccion;
           this.fechasolicitud = fechasolicitud;
           this.fechafinalizacion = fechafinalizacion;
           this.duracion = duracion;
           this.nombArquitecto = nombArquitecto;
           this.nombAparejador = nombAparejador;
           this.nombContable = nombContable;
      }
 
    //los contables actualizan los proyectos añadiendo la información relativa al presupuesto
    public Proyecto (String dniCliente, String direccion,Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion, String nombArquitecto, String nombAparejador,String nombContable, 
           Integer presupuesto){
           super(dniCliente, direccion);
           this.proyectoID = proyectoID;
           this.tipoproyecto = tipoproyecto;
           this.fechasolicitud = fechasolicitud;
           this.fechafinalizacion = fechafinalizacion;
           this.duracion = duracion;
           this.nombArquitecto = nombArquitecto;
           this.nombAparejador = nombAparejador;
           this.nombContable = nombContable;
           this.presupuesto = presupuesto;   
    }
 
    //los administradores reciben nuevamente el proyecto una vez la obra ha sido contratada y 
    //fijan el calendario, es decir, introducen información sobre la fecha de inicio de la obra
    public Proyecto (String dniCliente, String direccion,Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion, String nombArquitecto, String nombAparejador,String nombContable, 
           Integer presupuesto, Enumerados.TipoEstados tipoestados, Date fechainicioObra){
           super(dniCliente, direccion);
           this.proyectoID = proyectoID;
           this.tipoproyecto = tipoproyecto;
           this.fechasolicitud = fechasolicitud;
           this.fechafinalizacion = fechafinalizacion;
           this.duracion = duracion;
           this.nombArquitecto = nombArquitecto;
           this.nombAparejador = nombAparejador;
           this.nombContable = nombContable;
           this.presupuesto = presupuesto;  
           this.tipoestados = tipoestados;
           this.fechainicioObra = fechainicioObra;
    }
    
    //los aparejadores actualizan los proyectos indicando que la obra ha finalizado
    public Proyecto (String dniCliente, String direccion,Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion, String nombArquitecto, String nombAparejador,String nombContable, 
           Integer presupuesto, Enumerados.TipoEstados tipoestados, Date fechainicioObra,
           Enumerados.TipoEstadosObra tipoestadosobra){
           super(dniCliente, direccion);
           this.proyectoID = proyectoID;
           this.tipoproyecto = tipoproyecto;
           this.fechasolicitud = fechasolicitud;
           this.fechafinalizacion = fechafinalizacion;
           this.duracion = duracion;
           this.nombArquitecto = nombArquitecto;
           this.nombAparejador = nombAparejador;
           this.nombContable = nombContable;
           this.presupuesto = presupuesto;   
           this.tipoestados = tipoestados;
           this.fechainicioObra = fechainicioObra;
           this.tipoestadosobra = tipoestadosobra;
    }
 
    //finalmente los administradores actualizan la fecha de fin de obra definitiva y estos 
    //datos pasan al histórico
    public Proyecto (String dniCliente, String direccion,Integer proyectoID,
           Enumerados.TipoProyectos tipoproyecto,Date fechasolicitud, Date fechafinalizacion, 
           Integer duracion, String nombArquitecto, String nombAparejador,String nombContable, 
           Integer presupuesto, Enumerados.TipoEstados tipoestados, Date fechainicioObra,
           Enumerados.TipoEstadosObra tipoestadosobra, Date fechafinObra){
           super(dniCliente, direccion);
           this.proyectoID = proyectoID;
           this.tipoproyecto = tipoproyecto;
           this.fechasolicitud = fechasolicitud;
           this.fechafinalizacion = fechafinalizacion;
           this.duracion = duracion;
           this.nombArquitecto = nombArquitecto;
           this.nombAparejador = nombAparejador;
           this.nombContable = nombContable;
           this.presupuesto = presupuesto;   
           this.tipoestados = tipoestados;
           this.fechainicioObra = fechainicioObra;
           this.tipoestadosobra = tipoestadosobra;
           this.fechafinObra = fechafinObra;
    }
 
    public Integer getProyectoID(){
           return proyectoID;
    }
    
    public void setProyectoID (Integer proyectoID){
           this.proyectoID = proyectoID;
    }
 
    public Enumerados.TipoProyectos getTipoProyecto(){
           return tipoproyecto;
    }
    
    public void setTipoProyecto (Enumerados.TipoProyectos tipoproyecto){
           this.tipoproyecto = tipoproyecto;
    }
 
    public Date getFechaSolicitud(){
           return fechasolicitud;
     }
    
    public void setFechaSolicitud(Date fechasolicitud){
           this.fechasolicitud = fechasolicitud;
    }
    
    public Date getFechaFinalizacion(){
           return fechafinalizacion;
    }
    
    public void setFechaFinalizacion(Date fechafinalizacion){
           this.fechafinalizacion = fechafinalizacion;
    }
    
    public Integer getDuracion(){
           return duracion;
    }
    
    public void setDuracion(Integer duracion){
           this.duracion = duracion;
    }
    
    public Integer getPresupuesto(){
           return presupuesto;
    }
 
    public void setPresupuesto (Integer presupuesto){
           this.presupuesto = presupuesto;
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
 
    public Enumerados.TipoEstados getTipoEstados(){
           return tipoestados;
    }
    
    public void setTipoEstados (Enumerados.TipoEstados tipoestados){
           this.tipoestados = tipoestados;
    }
 
    public Enumerados.TipoEstadosObra getTipoEstadosObra(){
           return tipoestadosobra;
    }
    
    public void setTipoEstadosObra (Enumerados.TipoEstadosObra tipoestadosobra){
           this.tipoestadosobra = tipoestadosobra;
    }
 
    public Date getFechaInicioObra(){
           return fechainicioObra;
    }
    
    public void setFechaInicioObra(Date fechainicioObra){
           this.fechainicioObra = fechainicioObra;
    }
 
    public Date getFechaFinObra(){
           return fechafinObra;
    }
    
    public void setFechaFinObra (Date fechafinObra){
           this.fechafinObra = fechafinObra;
    }
 
    //método que obtiene por teclado todos los datos requeridos para dar de alta por primera vez
    //un objeto de tipo Proyecto. Devuelve este objeto a un método de la clase Estudio que 
    //finaliza el proceso de alta.
    public Proyecto altaProyecto(Integer nuevoNum) { 
        System.out.print("Introduce el DNI del cliente: \n");
        String dniCliente = input.nextLine();
        System.out.print("Introduce la dirección de la vivienda: \n");
        String direccion = input.nextLine();
        System.out.print("\nID del nuevo proyecto es: " + nuevoNum + "\n");
        System.out.print("Introduce el tipo de proyecto: \n");
        System.out.print(Enumerados.menuTipoProyectos());
        String tpr = input.nextLine();
        Integer tipoproyecto = Integer.parseInt(tpr);
        Enumerados.TipoProyectos tipoProy = Enumerados.TipoProyectos.values()[tipoproyecto];
        System.out.print("Introduce la fecha de solicitud (dd/MM/aaaa): \n");
        String fechaSolCadena= input.nextLine();
        Date fechasolicitud = StringADate(fechaSolCadena);
        System.out.print("Introduce la fecha de finalización: \n");
        String fechaFinCadena= input.nextLine();
        Date fechafinalizacion = StringADate(fechaFinCadena);
        System.out.print("Introduce la duración: \n");
        String dur = input.nextLine();
        Integer duracion = Integer.parseInt(dur);
        Proyecto proyecto = null; 
  
        if (Enumerados.TipoProyectos.RESIDENCIAL.equals(tipoProy)){
           System.out.print("Introduce la superficie del terreno: \n");
           String supT = input.nextLine();
           Integer superficieT = Integer.parseInt(supT);
           System.out.print("Introduce la superficie del edificio: \n");
           String supE = input.nextLine();
           Integer superficieEd = Integer.parseInt(supE);
           System.out.print("Introduce el número de plantas: \n");
           String numP = input.nextLine();
           Integer plantas = Integer.parseInt(numP);
           System.out.print("Introduce el número de habitaciones: \n");
           String numH = input.nextLine();
           Integer hab = Integer.parseInt(numP);
           System.out.print("Introduce el número de baños: \n");
           String numB = input.nextLine();
           Integer ban = Integer.parseInt(numB);
           proyecto = new Residencial (dniCliente, direccion, nuevoNum, tipoProy,fechasolicitud, 
           fechafinalizacion,duracion,Enumerados.TipoEstados.TRAMITE,superficieT,superficieEd,plantas,hab,ban);
          }
     
        if (Enumerados.TipoProyectos.COMERCIAL.equals(tipoProy)){
           System.out.print("Introduce la superficie del terreno: \n");
           String supT = input.nextLine();
           Integer superficieT = Integer.parseInt(supT);
           System.out.print("Introduce la superficie del edificio: \n");
           String supE = input.nextLine();
           Integer superficieEd = Integer.parseInt(supE);
           System.out.print("Introduce la finalidad: \n");
           String finalidad = input.nextLine();
           proyecto = new Comercial (dniCliente,direccion, nuevoNum,tipoProy, fechasolicitud, 
           fechafinalizacion,duracion,Enumerados.TipoEstados.TRAMITE,superficieT,superficieEd,finalidad);
          }
     
        if (Enumerados.TipoProyectos.REHABILITACION.equals(tipoProy)){
           System.out.print("Introduce la superficie: \n");
           String sup = input.nextLine();
           Integer superficie = Integer.parseInt(sup);
           proyecto = new Rehabilitacion (dniCliente,direccion,nuevoNum,tipoProy,fechasolicitud, 
           fechafinalizacion, duracion, Enumerados.TipoEstados.TRAMITE,superficie);
        }
  
        return proyecto; 
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

    //método para devolver una fecha con el formato de impresión deseado dd/MM/YYYY
    public String imprimirFecha(Date fecha) {
        return sdf.format(fecha);
    }
    
    //metodos de impresion datos vivienda DNI + direccion
    public String toStringVivienda() {
        String datosProyecto = "\n DATOS VIVIENDA: " + super.toString();
        return datosProyecto;
    }
    
    //metodos de impresion 
    public String toStringSimple() {
        String datosProyecto = "\n DATOS VIVIENDA: " + super.toString() + 
        "\n\n DATOS PROYECTO: "+  "\n ID Proyecto: " + proyectoID +  
        "\n Tipo de proyecto: " + tipoproyecto + "\n Fecha de solicitud: "
        + imprimirFecha(fechasolicitud) + "\n Fecha de finalización prevista: " 
        + imprimirFecha(fechafinalizacion) + "\n Duración prevista: " + duracion +
        "\n Estados del proyecto: " + tipoestados;
        return datosProyecto;
    }
 
    //método de impresión extendido donde aparece información relativa a las personas asignadas
    public String toString() {
        String datosProyecto = "\n DATOS VIVIENDA: " + super.toString() + 
        "\n\n DATOS PROYECTO: "+  "\n ID Proyecto: " + proyectoID +  
        "\n Tipo de proyecto: " + tipoproyecto + "\n Fecha de solicitud: "
        + imprimirFecha(fechasolicitud) + "\n Fecha de finalización prevista: " 
        + imprimirFecha(fechafinalizacion) + "\n Duración prevista: " + duracion +
        "\n Estados del proyecto: " + tipoestados;
     
        if (nombArquitecto!=null){
            datosProyecto = datosProyecto + "\n Nombre del arquitecto: " + nombArquitecto;
        }else{
            datosProyecto = datosProyecto + "\n Nombre del arquitecto: todavía no asignado." ;  
        }   
     
        if (nombAparejador!=null){
           datosProyecto = datosProyecto + "\n Nombre del aparejador: " + nombAparejador;
        }else{
           datosProyecto = datosProyecto + "\n Nombre del aparejador: todavía no asignado." ;  
        }   
     
        if (nombContable!=null){
            datosProyecto = datosProyecto + "\n Nombre del contable: " + nombContable;
        }else{
            datosProyecto = datosProyecto + "\n Nombre del contable: todavía no asignado." ;  
        }
     
        if (presupuesto!=null){
           datosProyecto = datosProyecto + "\n Presupuesto: " + presupuesto;
        }else{
           datosProyecto= datosProyecto + "\n Presupuesto: falta por presupuestar." ;  
        }     
        
        return datosProyecto;
    }
 
    //método de impresión de los datos de la obra
    public String toStringProyectoObra() {
        String datosProyecto = "\n DATOS VIVIENDA: " + super.toString() + 
        "\n\n DATOS PROYECTO: "+  "\n Estado del proyecto: "+ tipoestados +
        "\n ID Proyecto: " + proyectoID +  "\n Tipo de proyecto: " + tipoproyecto + 
        "\n Fecha de solicitud: " + imprimirFecha(fechasolicitud) + 
        "\n Fecha de finalización prevista: " + imprimirFecha(fechafinalizacion) + 
        "\n Duración: " + duracion +  "\n\n DATOS OBRA: " + 
        "\n Estado de la obra: "+ tipoestadosobra +
        "\n Fecha inicio obra: " + imprimirFecha(fechainicioObra); 
     
        if (fechafinObra!=null){
           datosProyecto = datosProyecto + "\n Fecha fin de obra: " + imprimirFecha(fechafinObra);
        }else{
           datosProyecto = datosProyecto + "\n Fecha fin de obra: no establecida.";  
        } 
     
         return datosProyecto;
    }
}
