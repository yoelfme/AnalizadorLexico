package proyectoautomatas;

import java.util.StringTokenizer;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author YOEL
 */

public class AnalizadorLexico {
    private JTextArea miCodigo;
    public DefaultTableModel miTabla = new DefaultTableModel();
    public DefaultTableModel miTablaErrores = new DefaultTableModel();
    //private String[] tokens;
    private Lenguaje miLexico;
    private int noFila;
    private int noColumna;
    private int noFilaErrores;
    private int analisisExitoso;        // variable entera que se utiliza para comprobar si el analisis lexico fue existoso
    
    public AnalizadorLexico(JTextArea codigo){
        noColumna = 0;
        noFila = 0;
        noFilaErrores =0;
        miCodigo=codigo;
        miLexico = new Lenguaje();
        analisisExitoso = 0;
        //miTabla = new DefaultTableModel();
        divideTokens();
    }
    
    public void divideTokens(){
        miTabla.addColumn("Token");
        miTabla.addColumn("Descripcion");
        miTabla.addColumn("Columna");
        miTabla.addColumn("Fila");
        //TableColumn columna = miTabla.getColumn("Descripion");
        
        
        miTablaErrores.addColumn("Error");
        miTablaErrores.addColumn("Descripcion");
        miTablaErrores.addColumn("Columna");
        miTablaErrores.addColumn("Fila");
        
        StringTokenizer lineaTokens = new StringTokenizer(this.miCodigo.getText(),"\n");
        
        //StringTokenizer cadenaNoTokens = new StringTokenizer(this.miCodigo.getText());
        StringTokenizer verificarTokens = new StringTokenizer(this.miCodigo.getText());
        
        int validos=0;
        int errores=0;
        
        while(verificarTokens.hasMoreTokens()){
            String tokenTemporal=verificarTokens.nextToken();
            if (this.extraerDescripcion(tokenTemporal)!=null  || AnalizadorLexico.validarNombres(tokenTemporal)  || AnalizadorLexico.validarInicializacion(tokenTemporal)  || AnalizadorLexico.validarNumero(tokenTemporal))
                validos++;
            else 
                errores++;
        }
      
        
        int columna=0;
        
        String token;
        int tamanoTokenTemp=1;
        int fila=1;
        
        miTabla.setNumRows(validos);
        miTablaErrores.setNumRows(errores);
       
        
        while(lineaTokens.hasMoreTokens()){
            String cadenaTokens = lineaTokens.nextToken();
            // Es necesario que se ponga un espacio por cada palabra o signo
            StringTokenizer tokenTemp = new StringTokenizer(cadenaTokens," ",true);
            
            while (tokenTemp.hasMoreTokens()){
                    token=tokenTemp.nextToken();
                    if (token.equals(" ")){
                        columna++;
                    }
                    else {
                        if (this.extraerDescripcion(token)!=null){
                            columna += tamanoTokenTemp;
                            miTabla.setValueAt(token, noFila, 0);
                            miTabla.setValueAt(this.extraerDescripcion(token), noFila, 1);
                            miTabla.setValueAt(columna, noFila, 2);
                            miTabla.setValueAt(fila, noFila, 3);
                            tamanoTokenTemp = token.length();
                            noFila++;
                        }else if (this.validarNombres(token)){
                            columna += tamanoTokenTemp;
                            miTabla.setValueAt(token, noFila, 0);
                            miTabla.setValueAt("Nombre de variable o programa", noFila, 1);
                            miTabla.setValueAt(columna, noFila, 2);
                            miTabla.setValueAt(fila, noFila, 3);
                            tamanoTokenTemp = token.length();
                            noFila++;
                        }else if(this.validarInicializacion(token)){
                            columna += tamanoTokenTemp;
                            miTabla.setValueAt(token, noFila, 0);
                            miTabla.setValueAt("Inicializacion de variables", noFila, 1);
                            miTabla.setValueAt(columna, noFila, 2);
                            miTabla.setValueAt(fila, noFila, 3);
                            tamanoTokenTemp = token.length();
                            noFila++;
                        }else if(this.validarNumero(token)){
                            columna += tamanoTokenTemp;
                            miTabla.setValueAt(token, noFila, 0);
                            miTabla.setValueAt("Numero", noFila, 1);
                            miTabla.setValueAt(columna, noFila, 2);
                            miTabla.setValueAt(fila, noFila, 3);
                            tamanoTokenTemp = token.length();
                            noFila++;
                        }                          
                        else{
                            this.analisisExitoso++;
                            columna += tamanoTokenTemp;
                            miTablaErrores.setValueAt(token, noFilaErrores, 0);
                            miTablaErrores.setValueAt("Este token no existe en mi lexico", noFilaErrores, 1);
                            miTablaErrores.setValueAt(columna, noFilaErrores, 2);
                            miTablaErrores.setValueAt(fila, noFilaErrores, 3);
                            tamanoTokenTemp = token.length();
                            noFilaErrores++;
                        }
                    }
            }
            columna=0;
            fila++;
            tamanoTokenTemp=1;
        }
    }   
    
    public String extraerDescripcion(String token){
        String descripcion="";
        
        descripcion = (String) miLexico.miLenguaje.get(token);
        return descripcion;
    }
    
    public int obtenerResultadoAnalisis(){
        return this.analisisExitoso;
    }
    
    static boolean validarNombres(String nombre)
    {
        return nombre.matches("[a-z]+\\d*[a-zA-Z]*");
    }
    
    static boolean validarInicializacion(String validacion){
        return validacion.matches("\\{(\\((\"\\d+\")(,\"\\d+\")*\\))*\\}");
    }
    
    static boolean validarNumero(String numero){
        return numero.matches("[1-9]");
    }
}