/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.clases;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;



/**
 *
 * @author pochini
 */
public class CrearReporte {
    private String titulo;
   
    public  CrearReporte(String titulo){
        this.titulo=titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        CrearReporte obj=new CrearReporte("Reporte Carga Horaria");
        obj.pdf();
    }
    
    public void pdf() throws FileNotFoundException, DocumentException {
        // Se crea el documento
        Document documento = new Document();

// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
        FileOutputStream ficheroPdf = new FileOutputStream("pdfs\\fichero.pdf");

// Se asocia el documento al OutputStream y se indica que el espaciado entre
// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

// Se abre el documento.
        documento.open();
     
        try {
            Image foto = Image.getInstance("C:\\Users\\pochini\\Documents\\NetBeansProjects\\gestion-academica-uce\\GestionAcademicaUCE-war\\web\\resources\\imagenes\\logo-uce.png");
            foto.scaleToFit(100, 100);
            foto.setAlignment(Chunk.ALIGN_MIDDLE);
            documento.add(foto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Paragraph universidad = new Paragraph("Universidad Central del Ecuador",
                FontFactory.getFont("arial", // fuente
                        22, // tamaño
                        Font.ITALIC // estilo
                        )); 
        universidad.setAlignment(Element.ALIGN_CENTER);
        documento.add(universidad);             // color
        
        Paragraph facultad = new Paragraph("Facultad de Ciencias Administrativas");
        facultad.setAlignment(Element.ALIGN_CENTER);
        documento.add(facultad);
        
        //titulo de reporte 
        Paragraph tituloReporte = new Paragraph(this.titulo);
        tituloReporte.setAlignment(Element.ALIGN_CENTER);
        documento.add(tituloReporte);
        documento.close();
        

    }
    
}
