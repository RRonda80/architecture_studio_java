package Principal;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Scanner; //librería para usar el escaner
import java.io.IOException; //librería para usar el cls

/**
* * @ (#) Menu.java
* 
* Clase Menu.
* Esta clase presenta toda la estructura externa del programa, ya que contiene todos los 
* menús que irán guiando al usuario en el proceso de gestión.
* 
* 
* @autora Romina Ronda
* @versión mayo 2022 */


public class menu {
    public static final  Scanner input = new Scanner(System.in);
    private GestionEstudio estudio = new GestionEstudio();
  
    public static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
  
    //A lo largo de los siguientes métodos es necesaria la obtención por teclado de numerosos
    //datos de tipo int. Para garantizar que se recogen todos los posibles errores 
    //se ha realizado la función opciónInt
    public static int opcionInt(){
        try{
        int entero = input.nextInt();
        input.nextLine(); 
        return entero ;
        }
       catch(Exception e){
        input.nextLine(); 
        return -1;
        }
    }
 
    // método para imprimir el menú principal que incluye la inicialización de datos de prueba
    public void menuPrincipalInicializar() { 
        estudio.inicializarDatosTest();
        int opcionMenu;
  
        do{   
           System.out.println("\n");
           System.out.println ("Bienvenido/a al sistema de gestión. Elige la opción de entrada:");
           System.out.println("1. Entrar como administrador/a");
           System.out.println("2. Entrar como arquitecto/a");
           System.out.println("3. Entrar como aparejador/a");
           System.out.println("4. Entrar como contable");
           System.out.println("5. Salir");
      
           opcionMenu = opcionInt();
 
           switch (opcionMenu){
              case 1:
                  menuAdministrador();
                  break;
              case 2:
                  menuArquitecto();
                  break;
              case 3:
                  menuAparejador();
                  break;
              case 4:
                  menuContable();
                  break;
              case 5: System.out.println("¡Hasta la próxima!"); 
                  System.exit(5); 
                  break;
              default:
                  System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 5.");
                  break;
           }
           /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
     
        }while (opcionMenu< 1 ||opcionMenu> 5);
    }
 
    // método para imprimir el menú principal sin inicilizar datos de prueba
    public void menuPrincipal() {
        int opcionMenu;
  
        do{
      
           System.out.println("\n");
           System.out.println ("Bienvenido/a al sistema de gestión. Elige la opción de entrada:");
           System.out.println("1. Entrar como administrador/a");
           System.out.println("2. Entrar como arquitecto/a");
           System.out.println("3. Entrar como aparejador/a");
           System.out.println("4. Entrar como contable");
           System.out.println("5. Salir");
      
           opcionMenu = opcionInt(); 
 
           switch (opcionMenu){
              case 1:
                  menuAdministrador();
                  break;
              case 2:
                  menuArquitecto();
                  break;
              case 3:
                  menuAparejador();
                  break;
              case 4:
                  menuContable();
                  break;
              case 5: System.out.println("¡Hasta la próxima!"); 
                  System.exit(5); 
                  break;
              default:
                  System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 5.");
                  break;
           }
           /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
     
         }while (opcionMenu< 1 ||opcionMenu> 5);
    }


    // método para imprimir el menú del administrador/a del sistema que abre todas sus opciones de gestión
    public void menuAdministrador(){
        int opcionMenu;
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{   
          System.out.println("\n");
          System.out.println ("Has entrado como administrador/a. Elige la opción de entrada:");
          System.out.println("1. Gestión de usuarios");
          System.out.println("2. Asignación de personal");
          System.out.println("3. Gestión de proyectos");
          System.out.println("4. Gestión de certificados");
          System.out.println("5. Listar empleados");
          System.out.println("6. Listar clientes");
          System.out.println("7. Listar viviendas");
          System.out.println("8. Volver atrás");
          System.out.println("9. Salir");
      
          opcionMenu = opcionInt(); 
 
          switch (opcionMenu) {
             case 1:
                 menuGestionUsuarios();
                 break;
             case 2:
                 menuAsignarProyectosCertificados();
                 break;
             case 3:
                menuGestionProyectos();
                break;
             case 4:
                menuGestionCertificados();
                break;
             case 5:
                estudio.listarEmpleados();
                menuAdministrador();
                break;
             case 6:
                menuListarClientes();
                menuAdministrador();
                break;
             case 7:
                estudio.listarViviendas(); 
                menuAdministrador();
                break;
             case 8:
                menuPrincipal ();
                break;
             case 9: System.out.println("¡Hasta la próxima!"); 
                System.exit(9); 
                break;
             default:
                System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 9.");
                break;
            }  
        }while (opcionMenu< 1 ||opcionMenu> 9);
    }
 
    // método para imprimir el menú del gestión de usuarios para dar de alta, de baja y modificar datos de los mismos
    public void menuGestionUsuarios(){
        int opcionMenu;
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{  
          System.out.println("\n");
          System.out.println ("Estás en el apartado de gestión de usuarios. Elige la opción de entrada:");
          System.out.println("EMPLEADOS:");
          System.out.println("1. Dar de alta");
          System.out.println("2. Dar de baja");
          System.out.println("3. Modificar datos");
          System.out.println("CLIENTES:");
          System.out.println("4. Dar de alta");
          System.out.println("5. Dar de baja");
          System.out.println("6. Modificar datos");
          System.out.println("7. Volver atrás");
          System.out.println("8. Salir");
      
          opcionMenu = opcionInt(); 
 
          switch (opcionMenu) {
             case 1:
                estudio.crearEmpleado();
                menuAdministrador();
                break;
             case 2:
                estudio.eliminarEmpleado();
                menuAdministrador();
                break;
             case 3:
                estudio.modificarEmpleado();
                menuAdministrador();
                break;
             case 4:
                estudio.crearCliente();
                menuAdministrador();
                break;
             case 5:
                estudio.eliminarCliente();
                menuAdministrador();
                break;
             case 6:
                estudio.modificarCliente();
                menuAdministrador();
                break;
             case 7:
                menuAdministrador();
                break;
             case 8: System.out.println("¡Hasta la próxima!"); 
                System.exit(8); 
                break;
             default:
                System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 8.");
                break;
           }  
        }while (opcionMenu< 1 ||opcionMenu> 8);
     }
 
    // método para listar los proyectos introducidos por los arquitectos, actualizar el estado a Contratado y la fecha de finalización de la obra
    public void menuGestionProyectos(){
        int opcionMenu;
        int numProy;
        int numProy_Obra;
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{  
           System.out.println("\n");
           System.out.println ("Elige la opción más adecuada:");
           System.out.println("1. Listar proyectos");
           System.out.println("2. Actualizar estado de un proyecto");
           System.out.println("3. Actualizar fechas de una obra");
           System.out.println("4. Volver atrás");
           System.out.println("5. Salir");
      
           opcionMenu = opcionInt(); 
 
           switch (opcionMenu) {
              case 1:
                 estudio.listarProyectos();
                 menuGestionProyectos();
                 break;
              case 2:
                 System.out.println("ACTUALIZAR EL ESTADO DE UN PROYECTO:\n");
                 System.out.println("Introduce el ID del proyecto:");
                 String py = input.nextLine();
                 numProy = Integer.parseInt(py);
                 estudio.actualizarEstadoProyecto(numProy);
                 menuGestionProyectos();
                 break;
              case 3:
                 System.out.println("ACTUALIZAR EL ESTADO DE UNA OBRA:\n");
                 System.out.println("Introduce el ID del proyecto:");
                 String pyo = input.nextLine();
                 numProy_Obra = Integer.parseInt(pyo);
                 estudio.actualizarFinObraProyecto(numProy_Obra);
                 menuGestionProyectos();
                 break;
              case 4:
                 menuAdministrador();
                 break;
              case 5: System.out.println("¡Hasta la próxima!"); 
                 System.exit(5); 
                 break;
              default:
                 System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 5.");
                 break;
           }  
        }while (opcionMenu< 1 ||opcionMenu> 5);
    }
 
    // método para listar los certificados introducidos por los arquitectos, actualizar el estado a Contratado y la fecha de finalización de la obra
    public void menuGestionCertificados(){
        int opcionMenu;
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{   
           System.out.println("\n");
           System.out.println ("Elige la opción más adecuada:");
           System.out.println("1. Listar certificados");
           System.out.println("2. Listar viviendas para inspección técnica");
           System.out.println("3. Listar viviendas para certificado de habitabilidad");
           System.out.println("4. Volver atrás");
           System.out.println("5. Salir");
      
           opcionMenu = opcionInt(); 
 
        switch (opcionMenu) {
           case 1:
              estudio.listarCertificados();
              menuGestionCertificados();
              break;
           case 2:
              System.out.println("LISTADO DE VIVIENDAS PARA INSPECCIÓN TÉCNICA:\n");
              System.out.println("Introduce la fecha actual:");
              String fechaActCadena= input.nextLine();
              Date fechaactual = StringADate(fechaActCadena);
              estudio.imprimirViviendasCertInspeccion(fechaactual);
              menuAdministrador();
              break;
          case 3:
              System.out.println("LISTADO DE VIVIENDAS PARA CERTIFICADO DE HABITABILIDAD:\n");
              System.out.println("Introduce la fecha actual:");
              String fechaActCadena_cert= input.nextLine();
              Date fechaactual_cert = StringADate(fechaActCadena_cert);
              estudio.imprimirViviendasCertHabitabilidad(fechaactual_cert);
              menuAdministrador();
              break;
          case 4:
              menuAdministrador();
              break;
          case 5: System.out.println("¡Hasta la próxima!"); 
              System.exit(5); 
              break;
          default:
              System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 5.");
              break;
        }  
      }while (opcionMenu< 1 ||opcionMenu> 5);
    }
 
    // método para listar los clientes
    public void menuListarClientes(){
        int opcionMenu;
        String nombArquitecto;
        String nombAparejador;
        String nombContable;
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{  
           System.out.println("\n");
           System.out.println ("Elige la opción más adecuada:");
           System.out.println("1. Listar clientes");
           System.out.println("2. Listar trabajos y clientes por arquitecto");
           System.out.println("3. Listar trabajos y clientes por aparejador");
           System.out.println("4. Listar presupuestos y clientes por contable");
           System.out.println("5. Volver atrás");
           System.out.println("6. Salir");
      
           opcionMenu = opcionInt();
           switch (opcionMenu) {
              case 1:
                 estudio.listarClientes();
                 menuAdministrador();
                 break;
              case 2:
                 System.out.println("Introduce el nombre del arquitecto:");
                 nombArquitecto = input.nextLine();
                 estudio.listarTrabajosArquitecto(nombArquitecto);
                 menuAdministrador();
                 break;
              case 3:
                 System.out.println("Introduce el nombre del aparejador:");
                 nombAparejador = input.nextLine();
                 estudio.listarTrabajosAparejador(nombAparejador);
                 menuAdministrador();
                 break;
              case 4:
                 System.out.println("Introduce el nombre del contable:");
                 nombContable = input.nextLine();
                 estudio.listarTrabajosContable(nombContable);
                 menuAdministrador();
                 break;
              case 5:
                 menuAdministrador();
                 break;
              case 6: System.out.println("¡Hasta la próxima!"); 
                 System.exit(6); 
                 break;
              default:
                 System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 6.");
                 break;
            }  
        }while (opcionMenu< 1 ||opcionMenu> 5);
     }

    // método para imprimir el menú del arquitecto/a que abre todas sus opciones de gestión
    public void menuArquitecto(){
        int opcionMenu;
        int numProy;
        int numCert;
        String nombArquitecto = "";
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{  
           System.out.println("\n");
           System.out.println ("Has entrado como arquitecto/a. Elige la opción de entrada:");
           System.out.println("1. Listar tus clientes");
           System.out.println("2. Nuevo proyecto");
           System.out.println("3. Nuevo certificado");
           System.out.println("4. Actualizar datos de un proyecto");
           System.out.println("5. Actualizar datos de un certificado");
           System.out.println("6. Volver a atrás");
           System.out.println("7. Salir");
      
           opcionMenu = opcionInt(); 
        switch (opcionMenu) {
           case 1:
              System.out.println("LISTAR TUS CLIENTES:\n");
              System.out.println("Introduce tu nombre:");
              nombArquitecto = input.nextLine();
              estudio.listarTrabajosArquitecto(nombArquitecto);
              menuArquitecto();
              break;
           case 2:
              System.out.println("ALTA DE PROYECTOS:\n");
              Integer nuevoNum = estudio.getNumProyecto();
              estudio.nuevoProyecto(nuevoNum);
              menuArquitecto();
              break;
           case 3:
              System.out.println("ALTA DE CERTIFICADOS:\n");
              Integer nuevoNumCert = estudio.getNumCertificado();
              estudio.nuevoCertificado(nuevoNumCert);
              menuArquitecto();
              break;
           case 4:
              System.out.println("ACTUALIZAR DATOS DE UN PROYECTO:\n");
              System.out.println("Introduce el ID del proyecto:");
              String py = input.nextLine();
              numProy = Integer.parseInt(py);
              estudio.actualizarDatosProyecto(numProy);
              menuArquitecto();
              break;
           case 5:
              System.out.println("ACTUALIZAR DATOS DE UN CERTIFICADO:\n");
              System.out.println("Introduce el ID del certificado:");
              String ct = input.nextLine();
              numCert = Integer.parseInt(ct);
              estudio.actualizarDatosCertificado(numCert);
              menuArquitecto();
              break;
           case 6:
              menuPrincipal ();
              break;
           case 7: System.out.println("¡Hasta la próxima!"); 
              System.exit(7); 
              break;
           default:
              System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 7.");
              break;
        } 
      }while (opcionMenu< 1 ||opcionMenu> 5);
    }
 
    // método para imprimir el menú del administrador/a del sistema que abre todas sus opciones de gestión
    public void menuAparejador(){
        int opcionMenu;
        String nombAparejador = "";
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{  
           System.out.println(" \n");
           System.out.println ("Has entrado como aparejador/a. Elige la opción de entrada:");
           System.out.println("1. Listar proyectos y certificados");
           System.out.println("2. Listar certificados pendientes");
           System.out.println("3. Volver a atrás");
           System.out.println("4. Salir");
      
           opcionMenu = opcionInt(); 
         switch (opcionMenu) {
            case 1:
               System.out.println("Introduce tu nombre:");
               nombAparejador = input.nextLine();
               estudio.listarTrabajosAparejador(nombAparejador);
               menuAparejador();
               break;
            case 2:
               System.out.println("LISTADO DE CERTIFICADOS PENDIENTES:\n");
               System.out.println("Introduce la fecha actual:");
               String fechaActCadena= input.nextLine();
               Date fechaactual = StringADate(fechaActCadena);
               estudio.imprimirCertificadosVisitasPendientes(fechaactual);
               menuAparejador();
               break;
            case 3:
               menuPrincipal ();
               break;
            case 4: System.out.println("¡Hasta la próxima!"); 
               System.exit(4); 
               break;
            default:
               System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 4.");
               break;
         }  
       }while (opcionMenu< 1 ||opcionMenu> 4);
    }
 
    // método para imprimir el menú del administrador/a del sistema que abre todas sus opciones de gestión
    public void menuContable(){
        int opcionMenu;
        int numProy = 0;
        int numCert = 0;
        String nombContable = "";
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{
           System.out.println("\n");
           System.out.println ("Has entrado como contable. Elige la opción de entrada: ");
           System.out.println("1. Listar tus clientes");
           System.out.println("2. Presupuestar un proyecto");
           System.out.println("3. Presupuestar un certificado");
           System.out.println("4. Volver a atrás");
           System.out.println("5. Salir");
      
           opcionMenu = opcionInt();
 
           switch (opcionMenu) {
              case 1:
                 System.out.println("Introduce tu nombre:");
                 nombContable = input.nextLine();
                 estudio.listarTrabajosContable(nombContable);
                 break;
              case 2:
                 System.out.println("Presupuestar el proyecto con ID: ");
                 String py = input.nextLine();
                 numProy = Integer.parseInt(py);
                 estudio.presupuestarProyecto(numProy);
                 menuContable();
                 break;
              case 3:
                 System.out.println("Presupuestar el certificado con ID: ");
                 String nc = input.nextLine();
                 numCert = Integer.parseInt(nc);
                 estudio.presupuestarCertificado(numCert);
                 menuContable();
                 break;
              case 4:
                 menuPrincipal ();
                 break;
              case 5: System.out.println("¡Hasta la próxima!"); 
                 System.exit(5); 
                 break;
              default:
                 System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 5.");
                 break;
            } 
        }while (opcionMenu< 1 ||opcionMenu> 5);
    } 
 
    //menú inicial para que el administrador pueda asignar proyectos a los diferentes empleados
    //del sistema
    public void menuAsignarProyectosCertificados(){
        int opcionMenu;
        int numProy;
        int numCert;
        /*new ProcessBuilder ("cmd", "/c","cls").inheritIO().start().waitFor();*/
  
        do{  
           System.out.println("\n");
           System.out.println ("Elige una opción:");
           System.out.println("1. Asignar personal a un proyecto");
           System.out.println("2. Asignar personal a un certificado");
           System.out.println("3. Volver atrás");
           System.out.println("4. Salir");
      
           opcionMenu = opcionInt(); 
 
        switch (opcionMenu) {
           case 1:
              System.out.println("Asignar personal a proyecto con ID: ");
              String np = input.nextLine();
              numProy = Integer.parseInt(np);
              estudio.asignarPersonalProyecto(numProy);
              menuAdministrador();
              break;
            case 2:
              System.out.println("Asignar personal a certificado con ID: ");
              String ct = input.nextLine();
              numCert = Integer.parseInt(ct);
              estudio.asignarPersonalCertificado(numCert);
              menuAdministrador();
              break;
           case 3:
              menuAdministrador();
              break;
           case 4: System.out.println("¡Hasta la próxima!"); 
              System.exit(4); 
              break;
           default:
              System.out.println("La opción introducida no es correcta. Introduce un número de 1 a 4.");
              break;
        }
      }while (opcionMenu< 1 ||opcionMenu> 4);
    } 
 
    //método para transformar un String instroducido por teclado en un Date que quedará guardado
    public static Date StringADate(String fechaCadena){
     Date fecha=null;
     try{
        fecha=sdf.parse(fechaCadena);
     } catch (Exception e){
         System.out.print(" La fecha introducida es errónea.");  
     }
     return fecha;
    }
}