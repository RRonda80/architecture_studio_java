package Principal;
import java.io.IOException; //librería para usar el cls

/**
* 
* Con esta clase se inicializa el programa. 
* Para ello se introduce el método main que incluye la creación de un objeto
* menú y una llamada al menú principal.
*
* @autora Romina Ronda
* @versión 27/02/2022
*/



public class Estudio {
    public static void main (String[] args) throws IOException, InterruptedException{
        menu menu = new menu();
        menu.menuPrincipalInicializar();
   }
}