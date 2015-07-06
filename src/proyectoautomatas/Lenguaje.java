package proyectoautomatas;
import java.util.*;

/**
 * @author YOEL
 */

public class Lenguaje {
    public Hashtable miLenguaje = new Hashtable();
    
    public Lenguaje(){
        miLenguaje.put("SI","palabra reservada que indica una condicion");
        miLenguaje.put("PARA","palabra reservada la cual indica un Bucle");
        miLenguaje.put("MAS","palabra reservada  la cual valida una condicion");
        miLenguaje.put("ROTURA","Corte que se realiza para finalizar una sentencia");
        miLenguaje.put("CASO","palabra reservada que indica varios tipos de condiciones");
        miLenguaje.put("CAPTURA","palabra reservada  para realizar una excepción");
        miLenguaje.put("CLASE","palabra reservada  para definir una clase u objeto");
        miLenguaje.put("BOLEANO","Tipo de variable boleano TRUE/FALSE");
        miLenguaje.put("CARACTER","variable que define una cadena de caracteres");
        miLenguaje.put("FALTA","opcional para un interruptor");
        miLenguaje.put("BORRAR","operador para liberar la memoria dinamica reservada");
        miLenguaje.put("HACER","palabra reservada  mientras la condicion resulte verdadera");
        miLenguaje.put("DOBLE","tipo de dato con numeros de punto flotante de doble precision");
        miLenguaje.put("ENUMERAR","sintaxis  que nos permite difinir conjuntos constantes enteras de tipo enumerado");
        miLenguaje.put("EXPLICITO","inicializacion directa de un objeto para una conversion explicita");
        miLenguaje.put("EXTERNO","especificador para indicar el almacenamiento y valor de objetos y funciones globales");
        miLenguaje.put("FALSO","valor booleano falso");
        miLenguaje.put("VERDADERO","valro booleano verdadero");
        miLenguaje.put("AMIGO","modificador para clases o funcioens  para inhibir el sistema de proteccion");
        miLenguaje.put("IR","sentencia de control para transferir directamente al punto etiquetado con el identificador");
        miLenguaje.put("ENTERO","tipo de dato para valores relativamente grandes, pero sin decimales");
        miLenguaje.put("ESPACIO-NOMBRE","espacio para declarar y definir objetos , funciones y en general, cualquier identicador de tipo, clase, estructura, etc");
        miLenguaje.put("NUEVO","operador para reservar la memoria dinamica");
        miLenguaje.put("PRIVADO","palabra reservada  la cual priva la variable");
        miLenguaje.put("PROTEGIDO","palabra reservada  la cual protege una variable");
        miLenguaje.put("PUBLICO","palabra reservada  la cual deja ver una variable a cualquiera");
        miLenguaje.put("RETORNO","setencia de una salida de una funcion");
        miLenguaje.put("ESTATICO","define la variable de esa clase para asi ser consulta en cualquier parte");
        miLenguaje.put("ESTRUCTURADO","agrupa los datos");
        miLenguaje.put("INTERRUPTOR","palabra reservada para definir bloques inicializados");
        miLenguaje.put("ESTE","funcion para referirse a un dato de un objeto en concreto");
        miLenguaje.put("LANZAR","devuelve un valor y lo asigna al objeto CAPTURA");
        miLenguaje.put("PROBAR","bloque para inicializar un LANZAR Y CAPTURA");
        miLenguaje.put("USO","activa un espacio por defecto");
        miLenguaje.put("VACIO","declara una funcion que no tiene valor de retorno");
        miLenguaje.put("MIENTRAS","ejecuta repetidamente un comunicado de destino, siempre y cuando una determinada condición es verdadera.");
        miLenguaje.put("(", "Parentisis que abre");
        miLenguaje.put(")", "Parentisis que cierra");
        miLenguaje.put(">", "Signo mayor que");
        miLenguaje.put("ENTONCES", "palabra reservada entonces");
    }
}