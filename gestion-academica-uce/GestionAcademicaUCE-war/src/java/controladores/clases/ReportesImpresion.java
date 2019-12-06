/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.clases;

//import com.administracion.entidades.ActividadesDeTitulacion;
//import com.administracion.entidades.GestionAcademica;
//import com.administracion.entidades.ImparticionDeClases;
//import com.administracion.entidades.Investigacion;
//import com.administracion.entidades.PreparacionDeClases;
//import com.administracion.entidades.PreparacionDeExamenes;
//import com.administracion.entidades.Profesor;
//import com.administracion.entidades.TutoriasAcademicas;
//import com.administracion.entidades.TutoriasProyectosInvestigacion;


import entidades.CargaHoraria;
import entidades.DetalleCh;
import entidades.Usuarios;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author a
 */
public class ReportesImpresion {

    private List<CargaHoraria> cargahoraria;
    private List<DetalleCh> detallecarga;
//    private List<ImparticionDeClases> ic;
//    private List<Investigacion> iv;
//    private List<PreparacionDeClases> pc;
//    private List<PreparacionDeExamenes> pe;
//    private List<TutoriasAcademicas> ta;
//    private List<TutoriasProyectosInvestigacion> ti;
//    private List<VinculacionConLaSociedad> vs;

    private List<InfoReporte> reportes;
    private InfoReporte reporte;

    public Boolean imprimirReportedocentes(List<Usuarios> usuario, int op) throws JRException, IOException {

        reportes = new ArrayList<>();
        for (Usuarios usuario1 : usuario) {
            reporte = new InfoReporte();
            reporte.setField1(usuario1.getId());
            reporte.setField2(usuario1.getNombreP());
            reporte.setField3(usuario1.getApellidoP());
            reporte.setField4(usuario1.getTelefono());
            reportes.add(reporte);
        }
        //this.exportarPdf("DOCENTES", "REPORTE-GENERAl", reportes);

        switch (op) {
            case 1:
                this.exportarPdf("DOCENTES", "REPORTE-GENERAl", reportes);
                break;
            case 2:
                this.exportarPdf("DOCENTES", "REPORTE DOCENTES TIEMPO COMPLETO", reportes);
                break;
            case 3:
                this.exportarPdf("DOCENTES", "REPORTE DOCENTES MEDIO TIEMPO", reportes);
                break;
            case 4:
                this.exportarPdf("DOCENTES", "REPORTE DOCENTES TIEMPO PARCIAL", reportes);
                break;
        }

        return true;
    }
    
    public boolean imprimirReporteCargaHoraria(List<CargaHoraria> cargas) throws JRException, IOException{
        reportes = new ArrayList<>();
        for (CargaHoraria carga : cargas) {
            reporte = new InfoReporte();
            reporte.setField1(carga.getFecha().toString());
            //reporte.setField2(carga.getTema());
            reporte.setField3(Integer.toString(carga.getHoraInicial().getHours())+":"+Integer.toString(carga.getHoraInicial().getMinutes()) );
            reporte.setField4(Integer.toString(carga.getHoraFin().getHours())+":"+Integer.toString(carga.getHoraFin().getMinutes()));
            reportes.add(reporte);
        }
        Validaciones validar=new Validaciones();
       // long[] hm= validar.calculardiferenciaDatesHM(cargas);
        String nombre=cargas.get(0).getCodDocente().getApellidoP()+"  "+cargas.get(0).getCodDocente().getNombreP();
        nombre=nombre.concat("   "+"Total Horas"+0+"Total Minutos"+120);
        this.exportarPdfCargaHoraria(nombre, "REPORTE CARGA HORARIA", reportes);
        return true;
    }

    public long contarHorasAt(Usuarios p) {
//        long tiempo, suma = 0, result;
//
//        at = new ArrayList<>();
//        try {
//            at = p.getActividadesDeTitulacionList();
//            for (ActividadesDeTitulacion actividadesDeTitulacion : at) {
//                tiempo = actividadesDeTitulacion.getDesde().getTime() - actividadesDeTitulacion.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//            result = suma / (1000 * 60);
//            return result;
//        } catch (Exception e) {
//
//            return 0;
//        }
     return 0;
    }

    public long contarHorasIc(Usuarios p) {
//        long tiempo;
//        long suma = 0, result;
//        try {
//            ic = p.getImparticionDeClasesList();
//            for (ImparticionDeClases imparticion : ic) {
//
//                tiempo = imparticion.getDesde().getTime() - imparticion.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//
//            result = suma / (1000 * 60);
//
//            return result;
//        } catch (Exception e) {
//            return 0;
//        }
        return 0;
    }

    public long contarHorasGa(Usuarios p) {
//        long tiempo;
//        long suma = 0, result;
//        try {
//            ga = p.getGestionAcademicaList();
//            for (GestionAcademica gestion : ga) {
//
//                tiempo = gestion.getDesde().getTime() - gestion.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//
//            result = suma / (1000 * 60);
//
//            return result;
//        } catch (Exception e) {
//            return 0;
//        }
        return 0;
    }

    public long contarHorasIv(Usuarios u) {
//        long tiempo;
//        long suma = 0, result;
//        try {
//            iv = p.getInvestigacionList();
//            for (Investigacion investigacion : iv) {
//
//                tiempo = investigacion.getDesde().getTime() - investigacion.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//
//            result = suma / (1000 * 60);
//
//            return result;
//        } catch (Exception e) {
//            return 0;
//        }
      return 0;
    }
//
//    public long contarHorasPc(Profesor p) {
//        long tiempo;
//        long suma = 0, result;
//        try {
//            pc = p.getPreparacionDeClasesList();
//            for (PreparacionDeClases prepa : pc) {
//
//                tiempo = prepa.getDesde().getTime() - prepa.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//
//            result = suma / (1000 * 60);
//
//            return result;
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//
//    public long contarHorasPe(Profesor p) {
//        long tiempo;
//        long suma = 0, result;
//        pe = p.getPreparacionDeExamenesList();
//        try {
//            for (PreparacionDeExamenes prepa : pe) {
//
//                tiempo = prepa.getDesde().getTime() - prepa.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//
//            result = suma / (1000 * 60);
//
//            return result;
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//
//    public long contarHorasTa(Profesor p) {
//        long tiempo;
//        long suma = 0, result;
//        try {
//            ta = p.getTutoriasAcademicasList();
//            for (TutoriasAcademicas tuto : ta) {
//
//                tiempo = tuto.getDesde().getTime() - tuto.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//
//            result = suma / (1000 * 60);
//
//            return result;
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//
//    public long contarHorasTi(Profesor p) {
//        long tiempo;
//        long suma = 0, result;
//        try {
//            ti = p.getTutoriasProyectosInvestigacionList();
//            for (TutoriasProyectosInvestigacion tuto : ti) {
//
//                tiempo = tuto.getDesde().getTime() - tuto.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//
//            result = suma / (1000 * 60);
//
//            return result;
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//
//    public long contarHorasVs(Profesor p) {
//        long tiempo;
//        long suma = 0, result;
//        try {
//            vs = p.getVinculacionConLaSociedadList();
//            for (VinculacionConLaSociedad vin : vs) {
//
//                tiempo = vin.getDesde().getTime() - vin.getHasta().getTime();
//                suma = suma + tiempo;
//            }
//
//            result = suma / (1000 * 60);
//
//            return result;
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//    public String minutosAHoras(long tiempo){
//      long h=tiempo/60;
//      long m=tiempo%60;
//      long t=h+m;
//      int hc=Math.toIntExact(h);
//      double mc=(double)m;
//      int mcc=(int) Math.round(mc);
//      return Integer.toString(hc)+":"+Integer.toString(mcc);
//    }

    public void exportarPdfCargaHoraria(String nombre, String apellido, List<InfoReporte> datos) throws JRException, IOException {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        parametros.put("label1", "FECHA");
        parametros.put("label2", "TEMA");
        parametros.put("label3", "HORA INICIAL");
        parametros.put("label4", "HORA FINAL");
        parametros.put("nomReporte", "REPORTE CARGA HORARIA");

        String nombrepdf = apellido;
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reporteGeneral6Param.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(datos));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment;filename=" + nombrepdf);
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();

    }
    public void exportarPdf(String nombre, String apellido, List<InfoReporte> datos) throws JRException, IOException {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        parametros.put("label1", "CEDULA");
        parametros.put("label2", "NOMBRES");
        parametros.put("label3", "APELLIDOS");
        parametros.put("label4", "TELEFONO");
        parametros.put("nomReporte", "REPORTE GENERAL DE PROFESORES ");

        String nombrepdf = apellido;
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reporteGeneral6Param.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(datos));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment;filename=" + nombrepdf);
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();

    }
    public static void main(String[] args) {
        ReportesImpresion r=new ReportesImpresion();
        long t=7510;
        System.out.println("+++++");
    }

}
