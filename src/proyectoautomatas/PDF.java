/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoautomatas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;

import com.itextpdf.text.*;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfContentByte;

import java.sql.*;
import javax.swing.JTextArea;

/**
 *
 * @author YOEL
 */
public class PDF {
private String strNombreDelPdf;
    
    private  Font fuenteNegra10 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD,BaseColor.BLACK);
    private  Font fuente8 = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL, BaseColor.BLACK);
    private  Font fuenteAzul25 = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD, BaseColor.BLUE);
    
    private JTextArea miCodigoImprimir;
    
    BaseColor grisClaro = new BaseColor( 230,230,230); 
    BaseColor azulClaro = new BaseColor( 124,195,255 );
    
    String strConsultaSQL;
    Document document;
    PdfWriter writer;
    String strRotuloPDF;

    
    public PDF(String titulo, String nomPDF, JTextArea miCodigo)
    {
        strRotuloPDF = titulo;
        strNombreDelPdf = nomPDF;
        miCodigoImprimir = miCodigo;
            
        try
        {  
            //Hoja tamanio carta, rotarla (cambiar a horizontal)
            document = new Document( PageSize.LETTER.rotate() );
            writer = PdfWriter.getInstance(document, new FileOutputStream(strNombreDelPdf));
            document.open();
            agregarMetaDatos(document);
            agregarContenido(document);

            document.close();
            //System.out.println("Se ha generado el PDF: "+ strNombreDelPdf);
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }

        private void agregarContenido(Document document) throws DocumentException

    {
        
        Paragraph ParrafoHoja = new Paragraph();
        ParrafoHoja.setAlignment(Element.ALIGN_CENTER);
        Paragraph Titulo = new Paragraph(strRotuloPDF.toUpperCase(),fuenteAzul25);
        Paragraph Codigo = new Paragraph(miCodigoImprimir.getText(),fuenteNegra10);
        
        Codigo.setAlignment(Element.ALIGN_LEFT);
        
        Titulo.setAlignment(Element.ALIGN_CENTER);
        // Agregamos una linea en blanco al principio del documento
        agregarLineasEnBlanco(ParrafoHoja, 1);
        
        // Colocar un encabezado (en mayusculas)
        
        //ParrafoHoja.add(new Paragraph(strRotuloPDF.toUpperCase(),fuenteAzul25) );
        ParrafoHoja.setAlignment(Element.TITLE);
        //int alineacion=ParrafoHoja.getAlignment();
        //ParrafoHoja.add(new Paragraph(String.valueOf(alineacion),fuenteAzul25) );
        agregarLineasEnBlanco(ParrafoHoja, 1);
        agregarLineasSeparadora(ParrafoHoja,2);
        //Agregar 2 lineas en blanco
        agregarLineasEnBlanco(ParrafoHoja, 2);
        document.add(Titulo);
        document.add(ParrafoHoja);
        document.add(Codigo);
    }
 
    //Agrega las lineas en blanco  especificadas a un parrafo especificado

    private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas)
    {
        for (int i = 0; i < nLineas; i++)
            parrafo.add(new Paragraph(" "));
    }
    
    private static void agregarLineasSeparadora(Paragraph parrafo, int nLineas){
        for(int i= 0; i<nLineas; i++)
            for (int j=0; j<107; j++)
                parrafo.add("_");
    }
  
    public void agregarCodigo(Paragraph parrafo){
        //para
    }
    //Agrega los metadatos del documento, los metadatos a asignar son

    //Titulo, Asunto, Palabras clave, Autor y el sw o org con el cual fue generado

    private static void agregarMetaDatos(Document document)
    {
        document.addTitle("Programa");
        document.addSubject("Programa de extension .pseudo");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Gustavo Chinchilla");
        
    }


 public void abrirPDF()
    {
        /* Abrir el archivo PDF */
        try
        {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + strNombreDelPdf);
        }
        catch (IOException e)

        {
            e.printStackTrace();
        }  
    }  
}
