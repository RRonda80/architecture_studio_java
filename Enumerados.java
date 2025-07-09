package TiposEnumerados;
/**
* @ (#) Enumerados.java
* 
* Clase TipoEnumerados.
* En esta clase guardamos una serie de tipos enumerados que nos van a permitir
* clasificar ciertos objeto en función de su clasificación.
*
* @autora Romina Ronda
* @versión mayo 202
*/

public class Enumerados {
    public enum TipoEmpleados{
                ADMINISTRADOR,ARQUITECTO,APAREJADOR,CONTABLE
    }
 
    public enum TipoProyectos{
                RESIDENCIAL,COMERCIAL,REHABILITACION
    }
 
    public enum TipoCertificados{
                HABITABILIDAD,INSPECCION,ENERGETICO,PERICIAL
    }
 
    public enum TipoEficienciaEnergetica{
                A,B,C,D,E,F,G
    }
 
    public enum TipoEstados{
                TRAMITE, CONTRATADO
    }
 
    public enum TipoEstadosObra{
                PROCESO, FINALIZADA
    } 
 
    public static String menuTipoEmpleados(){
        String opcionempleados = "";
        for (Enumerados.TipoEmpleados tp: Enumerados.TipoEmpleados.values()){
             opcionempleados = opcionempleados + tp.ordinal() + ". " + tp.toString() + "; ";
        }
        return opcionempleados;
    }
 
    public static String menuTipoProyectos(){
        String opcionproyectos = "";
        for (Enumerados.TipoProyectos tp: Enumerados.TipoProyectos.values()){
             opcionproyectos = opcionproyectos + tp.ordinal() + ". " + tp.toString() + "; ";
        }
        return opcionproyectos;
    }
 
    public static String menuTipoCertificados(){
        String opcioncertificados = "";
        for (Enumerados.TipoCertificados tc: Enumerados.TipoCertificados.values()){
             opcioncertificados = opcioncertificados + tc.ordinal() + ". " + tc.toString() + "; ";
        }
        return opcioncertificados;
    }
 
    public static String menuTipoEficienciaEnergetica(){
        String opcioneficiencia = "";
        for (Enumerados.TipoEficienciaEnergetica efe: Enumerados.TipoEficienciaEnergetica.values()){
             opcioneficiencia = opcioneficiencia + efe.ordinal() + ". " + efe.toString() + "; ";
        }
        return opcioneficiencia;
    }
 
    public static String menuTipoEstados(){
        String opcionestados = "";
        for (Enumerados.TipoEstados te: Enumerados.TipoEstados.values()){
             opcionestados = opcionestados + te.ordinal() + ". " + te.toString() + "; ";
        }
        return opcionestados;
    }
 
    public static String menuTipoEstadosObra(){
        String opcionestadosobra = "";
        for (Enumerados.TipoEstadosObra to: Enumerados.TipoEstadosObra.values()){
             opcionestadosobra = opcionestadosobra + to.ordinal() + ". " + to.toString() + "; ";
        }
        return opcionestadosobra;
    }
}

