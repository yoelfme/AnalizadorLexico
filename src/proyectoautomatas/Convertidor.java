/*
 * Clase utilizada para convertir del lenguaje psedu a el lenguaje establecido por el lenguaje
 *
 */
package proyectoautomatas;

import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yoel
 */
public class Convertidor {

    // Propiedades
    private Palabra palabras = null;
    private DefaultTableModel miTabla;

    public Convertidor(DefaultTableModel tabla) {
        this.palabras = new Palabra();
        this.miTabla = tabla;
    }

    public String convertir() {
        int fila = 1;
        int filaTemp;
        String palabra;
        String palabraConvertida;
        String codigoFinal = "";
        
        // Recorrer la tabla de tokens
        for (int i = 0; i < this.miTabla.getRowCount(); i++) {
            // Obtener la fila del token
            filaTemp = (int) miTabla.getValueAt(i, 3);
            
            // Obtener la palabra
            palabra = (String) miTabla.getValueAt(i, 0);
            
            // Convertir la palabra a mayuscula
            palabra = palabra.toUpperCase();
            
            if(filaTemp != fila) {
                fila = filaTemp;
                codigoFinal += "\n";
            }
            
            // Obtener la conversino de la palabra
            palabraConvertida = (String) this.palabras.miPalabra.get(palabra);
            
            if(palabraConvertida != null) {
                codigoFinal += palabraConvertida + " ";
            } else {
                codigoFinal += palabra.toLowerCase() + " ";
            }
            
            
        }
        
        return codigoFinal;
    }

}
