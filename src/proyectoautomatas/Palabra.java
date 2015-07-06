package proyectoautomatas;
import java.util.*;

/**
 * @author YOEL
 */

public class Palabra {
    public Hashtable miPalabra = new Hashtable();
    
    public Palabra(){
        miPalabra.put("SI","IF");
        miPalabra.put("PARA","FOR");
        miPalabra.put("MAS","ELSE");
        miPalabra.put("ROTURA","BREAK");
        miPalabra.put("CASO","CASE");
        miPalabra.put("CAPTURA","CATCH");
        miPalabra.put("CLASE","CLASS");
        miPalabra.put("BOLEANO","BOOL");
        miPalabra.put("CARACTER","CHAR");
        miPalabra.put("FALTA","DEFAULT");
        miPalabra.put("BORRAR","DELETE");
        miPalabra.put("HACER","DO");
        miPalabra.put("DOBLE","DOUBLE");
        miPalabra.put("ENUMERAR","ENUM");
        miPalabra.put("EXPLICITO","EXPLICIT");
        miPalabra.put("EXTERNO","EXTERN");
        miPalabra.put("FALSO","FALSE");
        miPalabra.put("VERDADERO","TRUE");
        miPalabra.put("FLOTANTE","FLOAT");
        miPalabra.put("AMIGO","FRIEND");
        miPalabra.put("IR","GOTO");
        miPalabra.put("ENTERO","INT");
        miPalabra.put("ESPACIO-NOMBRE","NAMESPACE");
        miPalabra.put("NUEVO","NEW");
        miPalabra.put("PRIVADO","PRIVATE");
        miPalabra.put("PROTEGIDO","PROTECTED");
        miPalabra.put("PUBLICO","PUBLIC");
        miPalabra.put("RETORNO","RETURN");
        miPalabra.put("ESTATICO","STATIC");
        miPalabra.put("ESTRUCTURA","STRUCT");
        miPalabra.put("INTERRUPTOR","SWITCH");
        miPalabra.put("ESTE","THIS");
        miPalabra.put("LANZAR","THROW");
        miPalabra.put("PROBAR","TRY");
        miPalabra.put("USO","USING");
        miPalabra.put("VACIO","VOID");
        miPalabra.put("MIENTRAS","WHILE");
        miPalabra.put("ENTONCES", "THEN");
    }
}