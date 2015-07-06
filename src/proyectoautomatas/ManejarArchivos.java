
package proyectoautomatas;

import java.beans.EventHandler;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que se utilizara para manejar los archivos
 * @author YOEL
 */

public class ManejarArchivos {
    
    
    private static String archivoAbierto;
    private static boolean estadoArchivo = false;
    private String nombreArchivo;
    //private String archivoSinCambios;
    
    //Clase de Alex
    
    public void AbrirArchivo(JTextArea txtCodigo) throws FileNotFoundException, IOException
    {
        JFileChooser dialogo = new JFileChooser();
        //dialogo.addChoosableFileFilter(new Filtro());
        dialogo.setFileFilter(new Filtro());
        
        int seleccion = dialogo.showOpenDialog(txtCodigo);
        
        if(seleccion == 0)
        {
            File archivo = dialogo.getSelectedFile();
            archivoAbierto = archivo.getPath();
            nombreArchivo = (archivo.getName().substring(0, archivo.getName().lastIndexOf(".")));
            this.estadoArchivo = true;
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                String linea = lector.readLine();
                txtCodigo.setText("");
                while(linea != null)
                {
                    txtCodigo.setText(txtCodigo.getText() + linea + "\n");
                    //archivoSinCambios += linea + "\n";
                    linea = lector.readLine();
                }
            }
            txtCodigo.setVisible(true);
        } // fin de If
        txtCodigo.select(0, 0);
    } // fin del metodo AbrirArchivo
    
    public void Guardar(JTextArea txtCodigo) throws FileNotFoundException
    {
        if (this.estadoArchivo)
        {
           File fichero = new File(archivoAbierto);
           PrintWriter writer = new PrintWriter(fichero);
           writer.print(txtCodigo.getText());
           writer.close();
        }
        else
            this.GuardarComo(txtCodigo);
    } // fin de metodo Guardar
    
    public void GuardarComo(JTextArea txtCodigo) throws FileNotFoundException
    {
        
        JFileChooser dialogo = new JFileChooser();
        dialogo.setFileFilter(new Filtro());
        int seleccion = dialogo.showSaveDialog(txtCodigo);
        
        if(seleccion == 0)
        {
            File archivo = dialogo.getSelectedFile();
            try (PrintWriter escritor = new PrintWriter(archivo + ".pseudo")) {
                nombreArchivo = archivo.getName();
                escritor.print(txtCodigo.getText());
            }
            archivoAbierto = (archivo + ".pseudo");
            estadoArchivo = true;
        } // fin de If
    } // fin de metodo GuardarComo
    
    public void Nuevo(JTextArea txtCodigo) throws FileNotFoundException {
        if(txtCodigo.getText().compareTo("")!=0)
        {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de cerrar el documento?");

            if(confirmar == JOptionPane.OK_OPTION) 
            {
                this.Guardar(txtCodigo);
                txtCodigo.setText("");
                archivoAbierto = "";
                estadoArchivo = false;
            } // fin de if
            else if(confirmar == JOptionPane.NO_OPTION) 
            {
                txtCodigo.setText("");
                archivoAbierto = "";
                estadoArchivo = false;
            } // fin de else if
         }  //fin de if
    }
    
    public String obtenerNombreArchivo()
    {
        return nombreArchivo;
    }
    
    public String obtenerDireccionArchivo()
    {
        return archivoAbierto;
    }
    
    class Filtro extends javax.swing.filechooser.FileFilter {
        public boolean accept(File file) {
            String filename = file.getName();
            return filename.endsWith(".pseudo"); //archivos que son visibles
        }

        //el metodo "getDescription()" retorna una etiqueta pero el importante es el metodo "accept" Q SON LOS KE ACEPTA
        public String getDescription() {
            return "Todos los archivos que terminen *.pseudo";  //extension valida de posibles archivos a leer
        }
    }
}
