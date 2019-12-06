package controladores.modulo1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.event.FileUploadEvent;
import sesiones.modulo1.Migracion.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Migracion
 */
@Named(value = "cargarExcel")
@Dependent
public class cargarExcel {

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Creates a new instance of cargarDatos
     */
    public cargarExcel() {
    }

    public void handleFileUpload(FileUploadEvent event) throws FileNotFoundException, IOException {

        filename = event.getFile().getFileName();
        try (OutputStream out = new FileOutputStream(new File("C:\\\\Users\\Public\\" + filename))) {
            int reader = 0;
            byte[] bytes = new byte[(int) event.getFile().getSize()];
            try (InputStream in = (InputStream) event.getFile().getInputstream()) {
                while ((reader = in.read(bytes)) != -1) {
                    out.write(bytes, 0, reader);
                }
            }
            out.flush();
            out.close();
            System.out.println("Se subió el archivo...!!");

            try {
                if (MigracionLan.migrar()) {
                    FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "El archivo " + event.getFile().getFileName() + " ha sido subido existosamente..!!");
                    FacesContext.getCurrentInstance().addMessage(null, message1);
                } else {
                    FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No ha sido posible migrar los datos..!!");
                    FacesContext.getCurrentInstance().addMessage(null, message1);
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

        }

    }

}
