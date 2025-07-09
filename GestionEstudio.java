package Principal;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.time.*; 
import Personas.*;
import Viviendas.*;
import TiposEnumerados.*;

/**
* @ (#) Gestionestudio.java
* 
* Clase Gestion Estudio.
* 
* Esta clase se encarga de gestionar todos los objetos de las clases Empleados (Administrador,
* Arquitecto, Aparejador, Contable), Clientes y Viviendas (Proyectos y Certificados)
* Por tanto, los atributos de esta clase son aquellos que permiten almacenar este 
* tipo de objetos en su lugar correspondiente: ArrayList para Empleados y Clientes y HashMap
* para certificados y proyectos.
*
* @autora Romina Ronda
* @versión mayo 2022 */


public class GestionEstudio {
    private List<Empleado> empleados = new ArrayList<Empleado>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private Map<Integer, Proyecto> proyectos = new HashMap<Integer, Proyecto> ();
    private Map<Integer, Certificado> certificados = new HashMap<Integer, Certificado> ();
 
    public static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
 
    public void inicializarDatosTest() {  
        Cliente cliente1 = new Cliente("Eva Martinez", "44867096F", 640751211, "eva.martin@gmail.com");
        clientes.add(cliente1);
        Cliente cliente2 = new Cliente("Lucia Gonzalez", "44867095F", 640751211,"lucia.gonzalez@gmail.com");
        clientes.add(cliente2);
     
        Arquitecto empleado1 = new Arquitecto("Sandra Ramos", "22222222A", 650751211, "sandra.ramos@gmail.com",
        Enumerados.TipoEmpleados.ARQUITECTO);
        empleados.add(empleado1);
     
        Aparejador empleado2 = new Aparejador("Marta Flores", "33333333A", 660751211, "marta.flores@gmail.com",
        Enumerados.TipoEmpleados.APAREJADOR);
        empleados.add(empleado2);
     
        Contable empleado3 = new Contable("Patricia Ojeda", "44444444A", 670751211, "patricia.ojeda@gmail.com",
        Enumerados.TipoEmpleados.CONTABLE);
        empleados.add(empleado3);
     
        Contable empleado4 = new Contable("Patricia Sarmiento", "44444444B", 680751211, 
        "patricia.sarmiento@gmail.com",Enumerados.TipoEmpleados.CONTABLE);
        empleados.add(empleado4);
        
        /*Certificado certificado1 = new Certificado ("44867096F", "Manzana", 1, 
        Enumerados.TipoCertificados.PERICIAL, 20082022, 20082022, "Sandra Ramos", "Marta Flores", "Patricia Ojeda");
        certificados.put(1, certificado1);*/
    }
 
 
    public void crearEmpleado(){ 
        Empleado empleado = new Empleado ();
        empleado = empleado.altaEmpleados();
    
        boolean encontrado = false;//método para comprobar si el empleado que queremos dar de alta ya existía en el sistema
        for (int i = 0; i < empleados.size(); i++) {
            Empleado e = empleados.get(i);  
            if (e.getDni().equals(empleado.getDni())){
               encontrado = true;
               break;  
            }
        }
    
        // Si los DNI coinciden, el sistema nos indicará que el empleado ya estaba dado de alta, 
        //si no, guardará los datos en el ArrayList correspondiente. 
        if (encontrado) {
           System.out.println("\nEl empleado ya estaba en el sistema.");
        } else {
           System.out.println("\nEl empleado ha sido dado de alta correctamente.");
           empleados.add(empleado);
        }
    }
 
    //método para imprimir todos los empleados ordenados según la subclase a las que pertenecen
    public void listarEmpleados() {
        System.out.println("\n Listado de empleados:\n");
        System.out.println("\n ADMINISTRADORES:");
        for(int i = 0; i < empleados.size(); i++) { 
           if (empleados.get(i).getPuesto().equals
              (Enumerados.TipoEmpleados.ADMINISTRADOR)){
              System.out.println(empleados.get(i).toString());
           }
        }
        System.out.println("\n ARQUITECTOS:");
        for(int i = 0; i < empleados.size(); i++) { 
           if (empleados.get(i).getPuesto().equals
              (Enumerados.TipoEmpleados.ARQUITECTO)){
              System.out.println(empleados.get(i).toString());
            }
        }
        System.out.println("\n APAREJADORES:");
        for(int i = 0; i < empleados.size(); i++) { 
           if (empleados.get(i).getPuesto().equals
              (Enumerados.TipoEmpleados.APAREJADOR)){
              System.out.println(empleados.get(i).toString());
            }
        }
        System.out.println("\n CONTABLES:n");
        for(int i = 0; i < empleados.size(); i++) { 
           if (empleados.get(i).getPuesto().equals
           (Enumerados.TipoEmpleados.CONTABLE)){
           System.out.println(empleados.get(i).toString());
         }
        }
    }
 
    //método para eliminar un empleado del array; solicita el DNI del empleado en cuestión y 
    //una vez encontrado lo elimina. Si no encuentra los datos, devuelve el mensaje correspondiente.
    public void eliminarEmpleado(){
        String dni;
    
        System.out.print(" Introduce el DNI del empleado a eliminar: ");
        dni = menu.input.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(dni)){
                encontrado = true;
                empleados.remove(i); 
                System.out.println(" El empleado con el DNI " + dni + 
                " ha sido eliminado correctamente.");
           }  
    
           if (!encontrado) {
              System.out.println(" El empleado con el DNI " + dni + 
              " no se encuentra en la base de datos."); 
           }
       } 
    }
 
    //método para modificar los datos de un empleado existente en la base de datos. Elimina los datos
    //originales y los sustituye por los datos que entran de nuevo por teclado
    public void modificarEmpleado(){
        String dni;
    
        System.out.print(" Vas a modificar los datos de un empleado/a. Introduce el DNI: ");
        dni = menu.input.nextLine();  
        boolean encontrado = false;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(dni)){
               encontrado = true;
               System.out.println (" Aquí están los datos antiguos del empleado/a\n"); 
               System.out.println(empleados.get(i).toString());
               System.out.print(" Introduce los datos nuevamente\n: ");
         
               empleados.remove(i); //se elimina por completo el empleado y se añade un nuevo objeto
               Empleado empleado = new Empleado ();
               empleado = empleado.altaEmpleados();
               empleados.add(empleado);
          }
         }
    
        // Si los DNI no coinciden, el sistema nos indicará que el empleado no se encuentra en 
        //la base de datos
        if (!encontrado) {
           System.out.println(" El empleado con el DNI " + dni + 
           " no se encuentra en la base de datos."); 
        }
     }
 
 
    //método para crear y guardar un nuevo cliente en el array dedicado a este tipo de objetos
    public void crearCliente(){ 
        Cliente cliente = new Cliente ();
        cliente = cliente.altaClientes();
    
        boolean encontrado = false;//método para comprobar si el empleado que queremos dar de alta ya existía en el sistema
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);  
            if (c.getDni().equals(cliente.getDni())){
               encontrado = true;
               break;  
            }
        }
    
        // Si los DNI coinciden, el sistema nos indicará que el cliente ya estaba dado de alta, si no, 
        // uardará los datos en el ArrayList correspondiente. 
        if (encontrado) {
           System.out.println("\n El cliente ya estaba en el sistema.");
        } else {
           clientes.add(cliente);
           System.out.println("\n El cliente ha sido dado de alta correctamente.");

        }  
    }
 
    //método para listar los clientes de forma general sin datos sobre proyectos y/o certificados
    public void listarClientes() {
        System.out.println("\n Listado de clientes:\n");
  
        for(Cliente cli: clientes) {
            System.out.println(cli.toString()); 
        }
    }
 
    //método para eliminar un cliente del array; solicita el DNI del cliente en cuestión y 
    //una vez encontrado lo elimina. Si no encuentra los datos, devuelve el mensaje correspondiente.
    public void eliminarCliente(){
       String dni;
    
       System.out.print(" Introduce el DNI del cliente a eliminar: ");
       dni = menu.input.nextLine();
       for (int i = 0; i < clientes.size(); i++) {
           if (clientes.get(i).getDni().equals(dni)){
              clientes.remove(i); 
              System.out.println(" El cliente con el DNI " + dni + 
              " ha sido eliminado correctamente."); 
           }
       }  
    }
 
    //método para modificar los datos de un cliente existente en la base de datos. Elimina los datos
    //originales y los sustituye por los datos nuevos que entran por teclado
    public void modificarCliente(){
        String dni;
    
        System.out.print(" Vas a modificar los datos de un cliente. Introduce el DNI: ");
        dni = menu.input.nextLine(); 
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(dni)){
               encontrado = true;
               System.out.println (" Aquí están los datos antiguos del cliente:\n"); 
               System.out.println(clientes.get(i).toString());
               System.out.print(" Introduce los datos nuevamente\n: ");
         
               clientes.remove(i); //se elimina por completo el empleado y se añade un nuevo objeto
               Cliente cliente = new Cliente();
               cliente = cliente.altaClientes();
               clientes.add(cliente);
            }
        }
    
        // Si los DNI no coincide, el sistema nos indicará que el cliente no se encuentra en 
        //la base de datos
        if (!encontrado) {
           System.out.println(" El cliente con el DNI " + dni + " no se encuentra en la base de datos."); 
        }
    } 
  
    //el método getNumProyecto obtiene el total de proyectos que hay en el array y suma uno para 
    //crear un nuevo proyecto
    public int getNumProyecto() { 
        if (proyectos!=null && proyectos.size()>0){
           return proyectos.size() + 1;
        }else{
           return 1;
         }
    } 
    
    //este método recibe un objeto proyecto, específicamente del método altaProyecto en 
    //la clase Proyecto y recurre al método guardarProyecto para guardar los datos
    public void nuevoProyecto(Integer nuevoNum){
        Proyecto proyecto = new Proyecto();
        proyecto = proyecto.altaProyecto(nuevoNum);
    
        if (proyecto!=null){
           guardarProyecto(nuevoNum, proyecto);
         }
     }
 
    //método para guardar los objetos Proyecto en el mapa con nuevoNum como key 
    //y los datos obtenidos como values. Además, lo añade al Array específico del cliente
    public void guardarProyecto(Integer nuevoNum,Proyecto proyecto){
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++){
            if (proyecto!=null && clientes.get(i).getDni().equals(proyecto.getDniCliente())){
               encontrado =true;
               proyectos.put(nuevoNum, proyecto); 
               for (int j = 0; j < clientes.size(); j++) { 
                   if (clientes.get(j).getDni().equals(proyecto.getDniCliente())){
                       clientes.get(j).putProyecto(nuevoNum, proyecto);
                   }
                }
             }
        }
     
        if (!encontrado){   
            System.out.print("Se ha producido un error.");
            System.out.print("El cliente no se encuentra en la base de datos.");    
        }
     }
    
    //método para imprimir los proyectos que se encuentran en la base de datos 
    public void listarProyectos() {
        System.out.println("\n LISTADO DE PROYECTOS:\n");
        
        if(proyectos.size() == 0){
            System.out.println("\n Todavía no hay proyectos en el sistema.\n");
        }else{
            for(Proyecto proy: proyectos.values()) {
               System.out.println(proy.toString()); 
            }
        }
     }
 
    //método para modificar los datos de un ´proyecto existente en la base de datos. 
    //Elimina los datos originales y los sustituye por los datos nuevos que entran por teclado. En esta ocasión la 
    //función nuevoProyecto recibe el número antiguo del proyecto que se ha eliminado.
    //Para afinar más el proceso en una versión más avanzada se debería preguntar al usuario por
    //dato específico que desea modificar y actualizar exclusivamente esta información
    public void actualizarDatosProyecto(Integer numProy){
        Proyecto proyecto = proyectos.get(numProy);  
        if (proyecto!=null){
            System.out.println ("Aquí están los datos antiguos del proyecto:\n"); 
            System.out.println(proyectos.get(numProy).toString()); 
            System.out.print("\nIntroduce los datos nuevamente\n: ");     
            proyectos.remove(numProy);
            nuevoProyecto(numProy);
            System.out.println ("\nAquí están los nuevos datos del proyecto:\n"); 
            System.out.println(proyectos.get(numProy).toString());
        }else{
            System.out.println("No existe proyecto: " + numProy);
        }
    }
 
    //el método getNumCertificado obtiene el total de certificados que hay en el Mapa 
    //y suma uno para crear un nuevo índice para el nuevo certificado
    public int getNumCertificado() { 
        if (certificados!=null && certificados.size()>0){
           return certificados.size() + 1;
        }else{
           return 1;
        }
    } 
    
    //este método recibe un objeto certificado, específicamente del método altaCertificado 
    //de la clase Certificado y recurre al método guardarCertificado para guardar los datos 
    public void nuevoCertificado(Integer nuevoNumCert){
        Certificado certificado = new Certificado();
        certificado = certificado.altaCertificado(nuevoNumCert);
    
        if (certificado!=null){
           guardarCertificado(nuevoNumCert, certificado);
         }
    }
    
    //método para guardar los objetos Certificado en el mapa con nuevoNum como key 
    //y los datos obtenidos como values. Además, lo añade al Array específico del cliente
    public void guardarCertificado(Integer nuevoNumCert,Certificado certificado){
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getDni().equals(certificado.getDniCliente())){
                encontrado =true;
                certificados.put(nuevoNumCert, certificado); 
                for (int j = 0; j < clientes.size(); j++) { 
                    if (clientes.get(j).getDni().equals(certificado.getDniCliente())){
                        clientes.get(j).putCertificado(nuevoNumCert, certificado);
                    }
                }
            }
         }
     
        if (!encontrado){     
           System.out.print("Se ha producido un error.");
           System.out.print("El cliente no se encuentra en la base de datos.");   
        }
    }
    
    //método para imprimir los certficados que se encuentran en la base de datos
    public void listarCertificados() {
        System.out.println("\n LISTADO DE CERTIFICADOS:\n");
        
        for(Certificado cert: certificados.values()) {
            System.out.println(cert.toString()); 
        } 
    } 
     
    //método para imprimir las viviendas 
    public void listarViviendas(){
        System.out.println("\n LISTADO DE VIVIENDAS:\n");
         
        System.out.println("VIVIENDAS CON PROYECTOS:"); 
        for(Proyecto proy: proyectos.values()){
            System.out.println(proy.toStringVivienda()); 
        }
         
        System.out.println("VIVIENDAS CON CERTIFICADOS:");
        for(Certificado cert: certificados.values()){
            System.out.println(cert.toStringVivienda()); 
        }
    }
     
    //método para modificar los datos de un certificado existente en la base de datos. 
    //Elimina los datos originales y los sustituye por los datos nuevos que entran por teclado. 
    //En esta ocasión la función nuevoCertificado recibe el número antiguo del proyecto que 
    //se ha eliminado. Para afinar más el proceso en una versión más avanzada se debería preguntar
    //al usuario por el dato específico que desea modificar y actualizar exclusivamente esta información
    public void actualizarDatosCertificado(Integer numCert){
        Certificado certificado = certificados.get(numCert);
    
        if (certificado!=null){
            System.out.println ("Aquí están los datos antiguos del certificado:\n"); 
            System.out.println(certificados.get(numCert).toString());
       
            System.out.print("\nIntroduce los datos nuevamente\n: ");
            certificados.remove(numCert);
            nuevoCertificado(numCert);
            System.out.println ("\nAquí están los nuevos datos del certificado:\n"); 
            System.out.println(certificados.get(numCert).toString());
        }else{
            System.out.println(" No existe certificado: " + numCert);
        }
    }
 
    // El método para visualizar los proyectos y certificados de los arquitectos asignados. El método recorre los mapas
    //correspondientes y devuelve el listado impreso de los trabajos. Si fuera necesario imprimir
    //los datos del cliente, se debe introducir dando del DNI del cliente correspondiente.
    public void listarTrabajosArquitecto(String nombArquitecto) {
        boolean existenproyectos = false;
        System.out.println("\nLISTADO DE PROYECTOS PARA " + nombArquitecto);
        for(Proyecto proy: proyectos.values()) {
            if (proy.getNombArquitecto().equals(nombArquitecto)){  
               System.out.println(proy.toStringSimple());
               existenproyectos = true;
            }
         } 
         
        if (!existenproyectos){
             System.out.println("No existen proyectos para este usuario.\n");
         }
    
        boolean existencertificados = false;
        System.out.println("LISTADO DE CERTIFICADOS PARA " + nombArquitecto);
        for(Certificado cert: certificados.values()) {
            if (cert.getNombArquitecto().equals(nombArquitecto)){  
               System.out.println(cert.toStringSimple());
               existencertificados = true;
            }
         }
         
        if (!existencertificados){
            System.out.println("No existen certificados para este usuario.\n");
         }
    
        imprimirDatosCliente();
    }
 
    // El método para visualizar los proyectos y certificados de los aparejadores asignados. El método recorre los mapas
    //correspondientes y devuelve el listado impreso. Si fuera necesario imprimir
    //los datos del cliente, se debe introducir dando del DNI del cliente correspondiente.
    public void listarTrabajosAparejador(String nombAparejador) {
        boolean existenproyectos = false;
        System.out.println("\nLISTADO DE PROYECTOS PARA " + nombAparejador);
        for(Proyecto proy: proyectos.values()) {
            if (proy.getNombAparejador().equals(nombAparejador)){  
               System.out.println(proy.toStringSimple());
               existenproyectos = true;
            }
        }
            
        if (!existenproyectos){
             System.out.println("No existen proyectos para este usuario.\n");
        }
    
        boolean existencertificados = false;
        System.out.println("LISTADO DE CERTIFICADOS PARA " + nombAparejador);
        for(Certificado cert: certificados.values()) {
            if (cert.getNombAparejador().equals(nombAparejador)){  
               System.out.println(cert.toStringSimple());
               existencertificados = true;
            }
        }
         
        if (!existencertificados){
           System.out.println("No existen certificados para este usuario.");
        } 
        imprimirDatosCliente();
     }
 
    // El método para visualizar los proyectos y certificados de los contables asignados. El método recorre los mapas
    //correspondientes y devuelve el listado impreso. Si fuera necesario imprimir
    //los datos del cliente, se debe introducir dando del DNI del cliente correspondiente.
    public void listarTrabajosContable(String nombContable) {
        boolean existenproyectos = false;
        System.out.println("\nLISTADO DE PROYECTOS PARA " + nombContable);
        for(Proyecto proy: proyectos.values()) {
            if (proy.getNombContable().equals(nombContable)){  
               System.out.println(proy.toStringSimple());
               existenproyectos = true;
             }
        }
    
        if (!existenproyectos){
           System.out.println("No existen proyectos para este usuario.\n");
        }
    
        boolean existencertificados = false;
        System.out.println("LISTADO DE CERTIFICADOS PARA " + nombContable);
        for(Certificado cert: certificados.values()) {
           if (cert.getNombContable().equals(nombContable)){  
              System.out.println(cert.toStringSimple());
              existencertificados = true;
           }
        }
        
        if (!existencertificados){
           System.out.println("No existen certificados para este usuario.");
        }  
        imprimirDatosCliente();
    }
 
    //método que preguntar a administradores y arquitectos si desean imprimir los datos de
    public void imprimirDatosCliente (){
        System.out.println("¿Deseas imprimir los datos de un cliente? (S/N):"); 
        String PrintCliente = menu.input.nextLine(); 
        boolean DatosCliente = false;    
        while (!PrintCliente.equals("S") && !PrintCliente.equals("N")) { 
              System.out.println("El valor introducido no es correcto"); 
              System.out.print("¿Deseas imprimir los datos de un cliente? (S/N):"); 
              PrintCliente = menu.input.nextLine(); 
         } 
    
        if (PrintCliente.equals("S")) {
           String dni;
           System.out.print(" Introduce el DNI del cliente: ");
           dni = menu.input.nextLine();
           for (int i = 0; i < clientes.size(); i++) {
               if (clientes.get(i).getDni().equals(dni)){
                  DatosCliente = true;
                  System.out.println(clientes.get(i).toStringSimple()); 
               }
           }  
        
           if (!DatosCliente){
              System.out.println(" El cliente con el DNI " + dni + 
              " no se ha encontrado en la base de datos."); 
           }
        }else if (PrintCliente.equals("N")){
        }   
    }
 
    //método empleado por el administrador para introducir información relativa al personal 
    //encargado del certificado. Si existe el ID introducido y el nombre del personal asignado
    //se guardará toda la información a través de los métodos del objeto certificado.
    public void asignarPersonalCertificado(Integer numCert){
        Certificado certificado = certificados.get(numCert);
        if (certificado!=null){  
            if (certificado.getNombArquitecto()==null || certificado.getNombAparejador()==null
               || certificado.getNombContable()==null){
               System.out.println(certificados.get(numCert).toString()); 
               System.out.print (" Introduce el nombre del arquitecto: ");
               String nombArquitecto = menu.input.nextLine();
               Boolean existearq = false;
               for (int i = 0; i < empleados.size(); i++) {
                   if (empleados.get(i).getNombre().equals(nombArquitecto) 
                      && empleados.get(i).getPuesto().equals(Enumerados.TipoEmpleados.ARQUITECTO)) {
                      existearq = true;
                   }
               }   
        
               if (existearq){
                  certificado.setNombArquitecto(nombArquitecto); 
               }else{
                  System.out.println(" El arquitecto " + nombArquitecto + 
                  " no se encuentra en la base de datos.");
               }
        
               System.out.print (" Introduce el nombre del aparejador: ");
               String nombAparejador = menu.input.nextLine();
               Boolean existeaparejador = false;
               for (int i = 0; i < empleados.size(); i++) {
                   if (empleados.get(i).getNombre().equals(nombAparejador) && empleados.get(i).getPuesto().equals
                      (Enumerados.TipoEmpleados.APAREJADOR)) {
                      existeaparejador = true;
                   }
               }
        
               if (existeaparejador){
                  certificado.setNombAparejador(nombAparejador);
               }else{
                  System.out.println(" El aparejador " + nombAparejador + 
                  " no se encuentra en la base de datos."); 
               }
          
               System.out.print (" Introduce el nombre del contable: ");
               String nombContable = menu.input.nextLine();
               Boolean existecont = false;
               for (int i = 0; i < empleados.size(); i++) {
                  if (empleados.get(i).getNombre().equals(nombContable) && empleados.get(i).getPuesto().equals
                     (Enumerados.TipoEmpleados.CONTABLE)) {
                     existecont = true;
                  }
               }
        
               if (existecont){
                  certificado.setNombContable(nombContable);
               }else{
                  System.out.println(" El contable " + nombContable + 
                  " no se encuentra en la base de datos."); 
               }
        
               //se ha comprobado que el certificado indicado todavía no tenga personal asignado
              } else{
                  System.out.println(" El certificado: " + numCert + " ya tiene personal asignado. ");
            }
        } else {
             System.out.println(" No existe el certificado: " + numCert);
        }
    }
 
    //método empleado por el administrador para introducir información relativa al personal 
    //del proyecto. Si existe el ID introducido y el nombre del personal asignado
    //se guardará toda la información a través de los métodos del objeto certificado.
    public void asignarPersonalProyecto(Integer numProy){
        Proyecto proyecto = proyectos.get(numProy);
  
        if (proyecto!=null){
            if (proyecto.getNombArquitecto()==null && proyecto.getNombAparejador()==null
                && proyecto.getNombContable()==null){
                System.out.println(proyectos.get(numProy).toStringSimple()); 
                System.out.print (" Introduce el nombre del arquitecto: ");
                String nombArquitecto = menu.input.nextLine();
                Boolean existearq = false;
                for (int i = 0; i < empleados.size(); i++) {
                    if(empleados.get(i).getNombre().equals(nombArquitecto) && empleados.get(i).getPuesto().equals
                      (Enumerados.TipoEmpleados.ARQUITECTO)) {   
                      existearq = true;
                      proyecto.setNombArquitecto(nombArquitecto);
                    }
                }
         
                if (existearq){
                   proyecto.setNombArquitecto(nombArquitecto);
                }else{
                   System.out.println(" El arquitecto " + nombArquitecto + 
                   " no se encuentra en la base de datos.");
                }
         
                System.out.print (" Introduce el nombre del aparejador: ");
                String nombAparejador = menu.input.nextLine();

                Boolean existeaparejador = false;
                for (int i = 0; i < empleados.size(); i++) {
                    if(empleados.get(i).getNombre().equals(nombAparejador) && empleados.get(i).getPuesto().equals
                      (Enumerados.TipoEmpleados.APAREJADOR)) {
                      existeaparejador = true;
                    }
                }
          
                if (existeaparejador){
                   proyecto.setNombAparejador(nombAparejador);
                }else{
                   System.out.println(" El aparejador " + nombAparejador + 
                  " no se encuentra en la base de datos.");
                }
         
                System.out.print (" Introduce el nombre del contable: ");
                String nombContable = menu.input.nextLine();
                Boolean existecont = false;
                for (int i = 0; i < empleados.size(); i++) {
                     if(empleados.get(i).getNombre().equals(nombContable) && empleados.get(i).getPuesto().equals
                       (Enumerados.TipoEmpleados.CONTABLE)) {
                       existecont = true;
                    }
                }
         
                if (existecont){
                   proyecto.setNombContable(nombContable);
                }else{
                   System.out.println(" El contable " + nombContable + 
                   " no se encuentra en la base de datos."); 
                }
         
                //se ha comprobado que el proyecto indicado todavía no tenga personal asignado
            } else{
                System.out.println(" El proyecto: " + numProy + " ya tiene personal asignado. ");
            }
        }else {
             System.out.println(" No existe el proyecto: " + numProy);
        }
    }
 
    //Método usado por el administrador para actualizar el estado de un proyecto de "TRÁMITE"
    //a "CONTRATADO" e incluir información sobre la fecha de inicio de la obra
    //Además, de forma automática se establece que el estado de la obra es PROCESO
    public void actualizarEstadoProyecto(Integer numProy){
        Proyecto proyecto = proyectos.get(numProy);
        
        if (proyecto!=null){   
            if(contadorProyectosProceso()> 3){
            System.out.println(proyectos.get(numProy).toString()); //Imprimo datos o no
            System.out.print("\nIntroduce el nuevo estado del proyecto: \n");
            System.out.print(Enumerados.menuTipoEstados());
            String test = menu.input.nextLine();
            Integer tipoestados = Integer.parseInt(test);
            Enumerados.TipoEstados tipoEst = Enumerados.TipoEstados.values()[tipoestados];
            proyecto.setTipoEstados(tipoEst);
            System.out.print("Introduce la fecha de inicio de la obra (dd/MM/aaaa): \n");
            String fechaInicioObraCadena= menu.input.nextLine();
            Date fechainicioObra = StringADate(fechaInicioObraCadena);
            proyecto.setFechaInicioObra(fechainicioObra);
            System.out.print("\nEl estado de la obra es: "+ Enumerados.TipoEstadosObra.PROCESO);
            proyecto.setTipoEstadosObra(Enumerados.TipoEstadosObra.PROCESO);
        
            System.out.println("\n\nEl proyecto " + numProy +  " se ha actualizado correctamente.");
            System.out.println("\n¿Deseas imprimir los datos actualizados? (S/N):"); 
            String PrintProyecto = menu.input.nextLine(); 
            while (!PrintProyecto.equals("S") && !PrintProyecto.equals("N")) { 
                  System.out.println("El valor introducido no es correcto"); 
                  System.out.print("\n¿Deseas imprimir los datos actualizados? (S/N):"); 
                  PrintProyecto = menu.input.nextLine(); 
            } 
    
            if (PrintProyecto.equals("S")) {
               System.out.println(proyectos.get(numProy).toStringProyectoObra());
            }else if (PrintProyecto.equals("N")){
            } 
         }else{
            System.out.println(" Actualmente existen más de tres proyectos en obras.");
         }
        } else {
              System.out.println(" No existe proyecto: " + numProy);
        }
    }
 
    public Integer contadorProyectosProceso (){
        int numeroProy = 0;
        
        for (int i = 0; i < proyectos.size(); i++) {
            if (proyectos.get(i).getTipoEstadosObra().equals
               (Enumerados.TipoEstadosObra.PROCESO)){
               numeroProy ++;    
            }
        }  
        return numeroProy;
    }
    //método usado por el administrador para actualizar el estado de la obra de "PROCESO" a 
    //"FINALIZADA" y la fecha de fin de las obras. En una versión más avanzada se deberían
    //comprobar dos puntos: primero,que realmente el estado del proyecto sea "CONTRATADO" y
    //el estado final de la obra sea "FINALIZADA" para poder introducir la fecha de fin de obra
    public void actualizarFinObraProyecto(Integer numProy){
        Proyecto proyecto = proyectos.get(numProy);
        if (proyecto!=null){
            if (proyectos.get(numProy).getTipoEstados().equals(Enumerados.TipoEstados.TRAMITE)){
               System.out.println(" El proyecto todavía no está contratado.");
               }else{ 
               System.out.println(proyectos.get(numProy).toStringProyectoObra()); //Imprimo datos o no
               System.out.print("\nIntroduce el nuevo estado de la obra: \n");
               System.out.print(Enumerados.menuTipoEstadosObra());
               String testOb = menu.input.nextLine();
               Integer tipoestadosobra = Integer.parseInt(testOb);
               Enumerados.TipoEstadosObra tipoEstOb = Enumerados.TipoEstadosObra.values()[tipoestadosobra];
               proyecto.setTipoEstadosObra(tipoEstOb);
               System.out.print("Introduce la fecha de fin de la obra (dd/MM/aaaa): \n");  
               String fechaFinObraCadena = menu.input.nextLine();
               Date fechafinObra = StringADate(fechaFinObraCadena);
               proyecto.setFechaFinObra(fechafinObra);
        
               System.out.println("\n\nEl proyecto " + numProy +  " se ha actualizado correctamente.");
        
               System.out.println("\n¿Deseas imprimir los datos actualizados? (S/N):"); 
               String PrintProyecto = menu.input.nextLine(); 
               while (!PrintProyecto.equals("S") && !PrintProyecto.equals("N")) { 
                      System.out.println("El valor introducido no es correcto"); 
                      System.out.print("\n¿Deseas imprimir los datos actualizados? (S/N):"); 
                      PrintProyecto = menu.input.nextLine(); 
               } 
    
               if (PrintProyecto.equals("S")) {
                  System.out.println(proyectos.get(numProy).toStringProyectoObra());
               }else if (PrintProyecto.equals("N")){
               } 
            }
        } else {
             System.out.println(" No existe proyecto: " + numProy);
        }
    }
 
    //método que imprime las viviendas que necesitan llevar a cabo una inspección
    //para el certificado de inspeccion técnica después de 45 años de la construcción del
    //edificio
    public void imprimirViviendasCertInspeccion (Date fechaactual){
         long anyos_entre_certificados;
         long max_anyos = 16440; //constante que indica cuántos días son 45 años
     
         boolean existenviviendas = false;
         for(Proyecto proy: proyectos.values()) {
            anyos_entre_certificados = calcularPeriodo (fechaactual, proy.getFechaFinObra());
            if (anyos_entre_certificados >= max_anyos){
               existenviviendas = true;
               System.out.println(proy.toStringSimple());
            }
         }
     
         if (!existenviviendas){
            System.out.println("No existen viviendas para la inspección técnica.\n");
         }
     }
  
    //método que imprime las viviendas que necesitan llevar a cabo una inspección
    //para el certificado de habitabilidad después de 15 años del último certificado emitido
    public void imprimirViviendasCertHabitabilidad (Date fechaactual){
        long anyos_entre_certificados;
        long max_anyos = 5480;
     
        boolean existenviviendas = false;
     
        for(Certificado cert : certificados.values()){
            if(cert instanceof Habitabilidad){
            // convertimos cert en Habitabilidad
            Habitabilidad hab = (Habitabilidad)cert;
            // accedemos las propiedades de hab
            anyos_entre_certificados = calcularPeriodo (fechaactual, hab.getFecha_AnteriorCertificado());
            if (anyos_entre_certificados >= max_anyos){
               existenviviendas = true;
               System.out.println(cert.toStringSimple());
            } 
           }
         }
      
        if (!existenviviendas){
           System.out.println("No existen viviendas para renovar el certificado de habitabilidad.\n");
        }   
    }
     
    //método para imprimir los certificados cuyas visitas están pendientes para el aparejador 
    //asignado al certificado
    public void imprimirCertificadosVisitasPendientes(Date fechaactual){
        boolean aparejadorasignado = false;
        boolean existenvisitaspendientes = false;
        String nombAparejador;
          
        System.out.println("Introduce tu nombre:");
        nombAparejador = menu.input.nextLine();
        
        for(Certificado cert : certificados.values()){
            if (cert.getNombAparejador().equals(nombAparejador)){  
                aparejadorasignado =true;
             }
         }   
     
        if (aparejadorasignado){
            for(Certificado cert_fecha : certificados.values()){
                if(cert_fecha.getFechaEntrega().after(fechaactual)){
                    existenvisitaspendientes = true;
                    System.out.println(cert_fecha.toStringSimple());
               } 
            }        
        }else{
            System.out.println("No estás asignado en ningún certificado pendiente.\n");
        }
        
        if (!existenvisitaspendientes){
                System.out.println("No existen visitas pendientes.\n");
        }   
    }
          
    //función empleada para el cálculo de un periodo de tiempo entre dos fechas
    //devuelve un dato de tipo long que representa los días entre ambas fechas
    public Long calcularPeriodo (Date fechafinal, Date fechainicio){ 
         long tiempo_transcurrido = fechafinal.getTime () - fechainicio.getTime ();
     
         TimeUnit unidad = TimeUnit.DAYS;
     
         long dias = unidad.convert(tiempo_transcurrido, TimeUnit.MILLISECONDS);
     
         return dias;
     }
 
    //método empleado por el contable para introducir información relativa al presupuesto 
    //del certificado. Si existe el ID introducido, se guardará la información sobre el presupuesto
    //mediante el método correspondiente en el objeto Certificado.
    public void presupuestarCertificado(Integer numCert){
        Certificado certificado = certificados.get(numCert);
        boolean contableasignado = false;
        if (certificado!=null){ 
            System.out.println ("Introduce tu nombre: ");
            String nombContable = menu.input.nextLine();   
            if (certificados.get(numCert).getNombContable().equals(nombContable)){
                contableasignado=true;
                System.out.println ("Acceso para presupuestar el certificado: "); 
                System.out.println(certificados.get(numCert).toStringSimple()); 
                System.out.print (" Introduce el presupuesto para el certificado: ");
                String presup = menu.input.nextLine();
                Integer presupuesto = Integer.parseInt(presup);
                certificado.setPresupuesto(presupuesto);
                System.out.println(" El presupuesto para el certificado con ID " + numCert +
                " se ha guardado correctamente.");
            }else{
                System.out.println(" No estás asignado a este certificado.");
            }
        }else {
             System.out.println(" No existe certificado: " + numCert);
        }
    }
 
    //método empleado por el contable para introducir información relativa al presupuesto 
    //del proyecto. Si existe el ID introducido, se guardará la información sobre el presupuesto
    //mediante el método correspondiente en el objeto Proyecto.
    public void presupuestarProyecto(Integer numProy){
        Proyecto proyecto = proyectos.get(numProy);
        boolean contableasignado = false;
        if (proyecto!=null){
            System.out.println ("Introduce tu nombre: ");
            String nombContable = menu.input.nextLine();    
            if (proyectos.get(numProy).getNombContable().equals(nombContable)){
               System.out.println(proyectos.get(numProy).toStringSimple()); 
               System.out.print (" Introduce el presupuesto para el proyecto: ");
               String presup = menu.input.nextLine();
               Integer presupuesto = Integer.parseInt(presup);
               proyecto.setPresupuesto(presupuesto);
               System.out.println(" El presupuesto para el proyecto con ID " + numProy +
               " se ha guardado correctamente.");
            }else{
                System.out.println(" No estás asignado a este proyecto.");
            }
        } else {
              System.out.println(" No existe proyecto: " + numProy);
        }
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
}
