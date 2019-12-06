/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *uso de librerias : core-renderer e itext 
 * @author VirtualW7
 */
@ManagedBean(name = "printController")
@SessionScoped
public class PrintController implements Serializable {

    public PrintController() {
    }

    public void createPDF() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);

        //String url = "http://localhost:8080/GestionAcademicaUCE-war/faces/Usuarios/Coordinador_Asignatura/modulo4/acta1.xhtml";
          //String url = "http://localhost:8080/GestionAcademicaUCE-war/faces/Usuarios/Coordinador_Asignatura/modulo4/acta1.xhtml:jsessionid=" + session.getId() + "?pdf=true";
      
     String url = "http://localhost:8080/GestionAcademicaUCE-war/print.xhtml";

      
      
        try {
            System.out.println("entro al metodo $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            //   ITextRenderer renderer = new ITextRenderer();
            //System.out.println("paso1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            //que hace aqui??? supuestamente crea una url pero en fomrato cadena de la que voy a tranformar
            //URL url2 = new URL(url);
            
            
            System.out.println("url  : "+url);
            
            //String url1 = new File(url).toURI().toURL().toString();
            //System.out.println("url 1 : " + url1 + " $$$$$$$$$$$$");

            ITextRenderer renderer = new ITextRenderer();
            System.out.println("se creo objeto iText $$$$$$$$$$$4");
            
            
            





// url1 = url1 + ":jsessionid=" + session.getId() + "?pdf=true";
            renderer.setDocument(url);
            System.out.println("pasa set document $$$$$$$$$$$$$$$$");

            //renderer.setDocument(new URL(url).toString());
            System.out.println("paso2 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            renderer.layout();
            System.out.println("paso3 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            response.reset();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=\"print-file.dpf\"");

            OutputStream outputStream = response.getOutputStream();
            renderer.createPDF(outputStream);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }

        facesContext.responseComplete();

    }

}
